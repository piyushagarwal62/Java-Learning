package completablefuture;

import java.util.concurrent.*;

public class SupplyAsyncMain {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asyncTask = CompletableFuture.supplyAsync(() -> {
                //"this is the task which need to be completed by thread";
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task: " + Thread.currentThread().getName());
                return "task completed";
            }, poolExecutor);
            System.out.println("Main thread waiting:" + Thread.currentThread().getName());
            //Suppose do not want to make main thread wait for the async task, then can call in separate thread.
            new Thread(() -> {
                try {
                    System.out.println("In separate thread:" + asyncTask.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).start();

            //If suppose within Main thread we call get() method then main thread is waiting for the result from
            //CompletableFuture object till task is complete.
//            System.out.println(asyncTask.get());

            if (asyncTask.isDone()) {
                System.out.println("is async task finished: " + asyncTask.isDone());
                poolExecutor.shutdown();
            }
        } catch (Exception e) {
        }
        System.out.println("Main thread finished:" + Thread.currentThread().getName());

    }
}
