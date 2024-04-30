package completablefuture;

import java.util.concurrent.*;

public class ThenComposeMain {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                //"this is the task which need to be completed by thread";
                try {
                    System.out.println("Thread Name which runs 'supplyAsync': " + Thread.currentThread().getName());
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task: " + Thread.currentThread().getName());
                return "hello";
            }, poolExecutor).thenCompose((String val) -> {
                System.out.println("Thread Name which runs 'thenCompose': " + Thread.currentThread().getName());
                return CompletableFuture.supplyAsync(() -> val + " world");
            }).thenComposeAsync((String val) -> {
                System.out.println("Thread Name which runs 'thenComposAsync': " + Thread.currentThread().getName());
                return CompletableFuture.supplyAsync(() -> val + " All");
            }).thenComposeAsync((String val) -> {
                System.out.println("Thread Name which runs 'thenComposAsync' with poolexecutor: " + Thread.currentThread().getName());
                return CompletableFuture.supplyAsync(() -> val + " Friend");
            }, poolExecutor);
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
