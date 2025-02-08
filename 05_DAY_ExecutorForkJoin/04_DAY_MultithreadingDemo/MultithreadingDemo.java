import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1. Creating a Thread using Thread class
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(500); // Simulating work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 2. Creating a Thread using Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " (Runnable) - Count: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 3. Shared Resource with Synchronization
class Counter {
    private int count = 0;

    public synchronized void increment() { 
        count++; 
        System.out.println(Thread.currentThread().getName() + " - Count: " + count);
    }
    
    public int getCount() { return count; }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        System.out.println("Starting Multithreading Demo...");

        // 4. Creating Threads
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.start();
        thread2.start();

        // 5. Using Runnable
        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();

        // 6. Using ExecutorService for Thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new MyRunnable());
        executor.execute(new MyRunnable());
        executor.shutdown();

        // 7. Synchronization Example
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) counter.increment();
        });

        t1.start();
        t2.start();

        // Wait for t1 & t2 to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.getCount());
        System.out.println("Multithreading Demo Finished.");
    }
}
