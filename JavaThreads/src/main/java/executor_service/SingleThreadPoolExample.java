package executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Submit task using ThreadPool
public class SingleThreadPoolExample {

    public static void main(String[] args) {

        // for scheduling of tasks
        ExecutorService service = Executors.newSingleThreadExecutor();

        // submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        service.shutdown();

        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }

}
