import java.util.ArrayList;
import java.util.List;

public class PerformanceTuning {
    private static final int DATA_SIZE = 10_000_000;

    public static void main(String[] args) {
        // Simulate memory allocation
        List<byte[]> memoryConsumer = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            memoryConsumer.add(new byte[DATA_SIZE]);
            System.out.println("Allocated " + (i + 1) + "0MB of memory");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Memory allocation completed. Running GC...");
        System.gc(); 
    }
}

