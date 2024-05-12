package executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Submit task using ThreadPool
public class CPUIntensiveFixedThreadPool {

    public static void main(String[] args) {

        //create the pool
        int numberOfCores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numberOfCores);

        //submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }

}
