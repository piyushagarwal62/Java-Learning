package completablefuture;

import java.util.concurrent.*;

public class ThenApplyMain {
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
                return "task completed";
            }, poolExecutor).thenApply((String val) -> {
                System.out.println("Thread Name which runs 'thenApply': " + Thread.currentThread().getName());
                return val + " Coding";
            }).thenApplyAsync((String val) -> {
                System.out.println("Thread Name which runs 'thenApplyAsync' with default poolexecutor: " + Thread.currentThread().getName());
                return val + " Practise";
            }).thenApplyAsync((String val) -> {
                System.out.println("Thread Name which runs 'thenApplyAsync' with existing poolexecutor: " + Thread.currentThread().getName());
                return val + " Learning";
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
