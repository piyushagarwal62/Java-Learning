package completablefuture;

import java.util.concurrent.*;

public class ThenCombineMain {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("Task: " + Thread.currentThread().getName());
                return 10;
            }, poolExecutor);

            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
                System.out.println("Task: " + Thread.currentThread().getName());
                return "k ";
            }, poolExecutor);
            //You can also try rmoving poolExecutor from the parameter, where then it will use forkjoinpool

            CompletableFuture<String> combineFuture = asyncTask1.thenCombine(asyncTask2, (Integer var1, String var2) -> var1 + var2);

            System.out.println("In Main thread:" + combineFuture.get());
            if(combineFuture.isDone()) {
                System.out.println("is async task finished: " + combineFuture.isDone());
                poolExecutor.shutdown();
            }
        } catch (Exception e) {
        }
        System.out.println("Main thread finished:" + Thread.currentThread().getName());
    }

}
