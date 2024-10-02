package completablefuture;

import java.util.concurrent.*;

public class SupplyAsyncMain {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 8, 1, TimeUnit.HOURS,
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
            Thread t1 = new Thread(() -> {
                try {
                    System.out.println("In separate thread:" + asyncTask.get());
                    //When second time we call get(), it does not runs the complete method of run but rather just return
                    // the result which is cached by Future Object.
                    System.out.println("In separate thread:" + asyncTask.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
            t1.start();
            //If want to print isDone()
//            t1.join();
            //If suppose within Main thread we call get() method then main thread is waiting for the result from
            //CompletableFuture object till task is complete.
//            System.out.println(asyncTask.get());

            if (asyncTask.isDone()) {
                System.out.println("is async task finished: " + asyncTask.isDone());
                poolExecutor.shutdown();
            } else {
                System.out.println("Task is not done");
            }
        } catch (Exception e) {
        }
        System.out.println("Main thread finished:" + Thread.currentThread().getName());

    }
}
