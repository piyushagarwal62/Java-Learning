package future_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DifferentSubmitTypes {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //Use case 1
        //submit returns no value back since its using runnable
        Future<?> futureObj = poolExecutor.submit(() -> {
                System.out.println("Task1 with Runnable");
        });
        try {
            Object object = futureObj.get();
            System.out.println(object == null);
        } catch (Exception e) {
        }

        //Use Case 2
        //submit returns value but this is used with Runnable and FutureTask
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObject2 = poolExecutor.submit(() -> {
            output.add(100);
            System.out.println("Task2 with Runnable and return object");
        }, output);
        try {
            List<Integer> outputFromFutureObject = futureObject2.get();
            System.out.println(outputFromFutureObject.get(0));
        } catch (Exception e) {
        }

        //Use Case 3
        Future<List<Integer>> futureObject3 = poolExecutor.submit(() -> {
            System.out.println("Task3 with Callable");
            List<Integer> listObj = new ArrayList<>();
            listObj.add(200);
            return listObj;
        });
        try {
            List<Integer> outputFromFutureObject3 = futureObject3.get();
            System.out.println(outputFromFutureObject3.get(0));
        } catch (Exception e) {
        }

    }

}
