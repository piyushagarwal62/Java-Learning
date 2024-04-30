package virtualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {
    public static void main(String[] args) {
        Thread thread = Thread.startVirtualThread(() -> {
            System.out.println("this is start virtual thread");
        });

        Thread thread1 = Thread.ofVirtual().start(() -> {
            System.out.println("this is ofvirtual thread");
        });

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(() -> System.out.println("using executor service"));
        executorService.shutdown();
        System.out.println("Main thread is finished");
    }
}
