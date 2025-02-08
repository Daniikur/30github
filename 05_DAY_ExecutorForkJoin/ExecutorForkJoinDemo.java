import java.util.concurrent.*;

// Task for Executor Framework
class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Executing Task ID: " + taskId + " by " + Thread.currentThread().getName());
    }
}

// Task for Fork-Join Framework
class ForkJoinTaskExample extends RecursiveTask<Integer> {
    private final int start, end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= 5) { 
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, mid);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(mid + 1, end);

            leftTask.fork();  
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}

public class ExecutorForkJoinDemo {
    public static void main(String[] args) {
        System.out.println("=== Executor Framework Demo ===");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            executor.execute(new Task(i));
        }

        executor.shutdown();  

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Executor tasks took too long, forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Fork-Join Framework Demo ===");
        
        // Using try-with-resources to ensure ForkJoinPool is closed properly
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            ForkJoinTaskExample task = new ForkJoinTaskExample(1, 20);
            int sum = forkJoinPool.invoke(task);
            System.out.println("Sum of numbers from 1 to 20: " + sum);
        }
    }
}
