import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Submit task using ThreadPool
public class CachedThreadPoolExample {

    public static void main(String[] args) {

        //create the pool
        ExecutorService service = Executors.newCachedThreadPool();

//		thread queue = T1 | T2 | T3

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
