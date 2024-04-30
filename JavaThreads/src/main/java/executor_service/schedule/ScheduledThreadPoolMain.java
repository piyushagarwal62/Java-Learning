package executor_service.schedule;

import java.util.concurrent.*;

public class ScheduledThreadPoolMain {
    public static void main(String args[]) {
        ScheduledExecutorService scheduledExecutorServiceObj = Executors.newScheduledThreadPool(2);
        //
        ScheduledFuture<?> futureWithNoReturn = scheduledExecutorServiceObj.schedule(() -> {
            System.out.println("hello without returning");
        }, 5, TimeUnit.SECONDS);

        Future<String> scheduledObj = scheduledExecutorServiceObj.schedule(() -> {
            return "hello";
        }, 5, TimeUnit.SECONDS);
        try {
            System.out.println(scheduledObj.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        scheduledObj.cancel(true);
    }
}
