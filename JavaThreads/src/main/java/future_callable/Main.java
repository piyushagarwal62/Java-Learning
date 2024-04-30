package future_callable;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //new thread will be created and it will perform the task
        //Here ?(wild card) is used, since not sure what submit is returning, it can also be Void or any other data type.
        //So can also use ? as wild card
        Future<?> futureObj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(7000l);
                System.out.println("this is the task, which thread will execute");
            } catch (Exception e) {

            }
        });

        //caller is checking the status of the thread it created
        System.out.println(futureObj.isDone());
        try{
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e){
            System.out.println("TimeoutException happened");
        } catch (Exception e){
            System.out.println("Exception happened");
        }

        try {
            futureObj.get();
        } catch (Exception e) {
        }
        System.out.println("is Done: " + futureObj.isDone());
        System.out.println("is Cancelled: " + futureObj.isCancelled());
    }
}
