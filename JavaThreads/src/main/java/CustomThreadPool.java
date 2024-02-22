import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {

    public static void main(String[] args) {

        // create the pool with Fixed array blocking queue
        ExecutorService service = new ThreadPoolExecutor(10, 100, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));

        try {
            service.execute(new Task());
        } catch (RejectedExecutionException e) {
            System.out.println("task rejected" + e.getMessage());
        }

        //If want custom rejection handler
        ExecutorService service1 = new ThreadPoolExecutor(10, 100, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300),
                new CustomRejectionHandler());

        try {
            service1.execute(new Task());
        } catch (RejectedExecutionException e) {
            System.out.println("task rejected" + e.getMessage());
        }

    }

    private static class CustomRejectionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //logging/operations to perform on rejection
        }
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }

}
