package thread_method_example.threadInit;

import java.util.concurrent.TimeUnit;

public class MultithreadingLearning {
    public static void main(String args[]) {
        System.out.println("Going inside main method: " + Thread.currentThread().getName());
        Runnable r = () -> {
            System.out.println("hello world");
            try {
                TimeUnit.SECONDS.sleep(7);
                System.out.println("after sleep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread = new Thread (r);
        thread.start();
        System.out.println("Finish main method: 1 "+ Thread.currentThread().getName());
    }
}