package completablefuture;

import java.util.concurrent.*;

public class ThenAcceptMain {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                System.out.println("Task: " + Thread.currentThread().getName());
                return "hello";
            }, poolExecutor);

            CompletableFuture<Void> voidCompletableFuture = asyncTask.thenAccept((String val) -> {
                System.out.println("Printing value: " + val);
            });

            System.out.println("In Main thread:" + asyncTask.get());
            if(asyncTask.isDone()) {
                System.out.println("is async task finished: " + asyncTask.isDone());
                poolExecutor.shutdown();
            }
        } catch (Exception e) {
        }
        System.out.println("Main thread finished:" + Thread.currentThread().getName());
    }

}
