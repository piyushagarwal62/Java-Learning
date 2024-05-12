package lockfree.cas;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedResourceUsingAtomic {

    AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
        //This will do three steps
        //Read, Modify, Update
    }

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //new thread will be created and it will perform the task
        Future<?> futureObj = poolExecutor.submit(() -> {
            System.out.println("this is the task, which thread will execute");
        });

        //caller is checking the status of the thread it created
        System.out.println(futureObj.isDone());
    }
    public int get() {
        return counter.get();
    }
}