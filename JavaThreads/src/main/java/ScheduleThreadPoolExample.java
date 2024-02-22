import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Submit task using ThreadPool
public class ScheduleThreadPoolExample {

    public static void main(String[] args) {

        //for scheduling of tasks
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

//		10k 10k 10k
//		totat = 60k

        //task to run after 10 second delay
        service.schedule(new Task(), 10, TimeUnit.SECONDS);

        //task to run repeatedly every 10 seconds
        service.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

        //task to run repeatedly 10 seconds after previous task completes
        service.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }

}
