import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UsingCallableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // create the pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future> allFutures = new ArrayList<>();
        // submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            // submit the tasks for execution
            Future<Integer> future = service.submit(new Task());
            allFutures.add(future);
        }

        //100 futures, with 100 placeholders

        // perform some unrelated operations
        //100 seconds

        for (int i = 0; i < 100; i++) {
            Future<Integer> future = allFutures.get(i);
            Integer result = future.get(); // get() method is a blocking operation
            System.out.println("Result of future #" + i + "=" + result);

            //Wait only certain time for the results
            try {
                //It waits for future to 1 seconds to get the value or throws exception
                Integer result1 = future.get(1, TimeUnit.SECONDS);
                System.out.println("Result from the task is" + result);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                System.out.println("Couldn't complete task before timeout");
            }

            //Cancel the task
            //Can interupt once the task as started for which need to set value as true
            //or else it wont allow to cancel once started
            future.cancel(false);

            //Returns true if task was cancelled
            future.isCancelled();

            //Returns true is task is completed (successfully or otherwise)
            future.isDone();
        }
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }

}
