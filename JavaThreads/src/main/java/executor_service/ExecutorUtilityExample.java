package executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorUtilityExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (Exception e) {
            }
            System.out.println("task completed");
        });
        executorService.shutdown();

        //If after shutdown, a new task is submitted for execution then it will give exception for rejection
        executorService.submit(() -> {
            System.out.println("Thread going to start its work");
        });

        //If used below method of shutdownNow() then halt the processing of task which are waiting for thread and
        //Executor service will get shutdown immediately
//        executorService.shutdownNow();
        try {
            boolean isTerminated = executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("Is Terminated: " + isTerminated);
        } catch (Exception e) {
        }
        System.out.println("Main thread is completed");
    }
}
