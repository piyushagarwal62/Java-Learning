package executor_service.schedule;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledAtFixedRate {
    public static void main(String args[]) {
        ScheduledExecutorService scheduledExecutorServiceObj = new ScheduledThreadPoolExecutor(15);
        Future<?> scheduledObj = scheduledExecutorServiceObj.scheduleAtFixedRate(() -> {
            System.out.println("task going to start by" + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
                System.out.println("Task completed");
            } catch (Exception e) {

            }
        }, 5, 3, TimeUnit.SECONDS);
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is finished");
    }
}
