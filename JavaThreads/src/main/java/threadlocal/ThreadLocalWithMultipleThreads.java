package threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalWithMultipleThreads {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            threadLocalObj.set(Thread.currentThread().getName());
            //Additional other work done by task
            //Require to call remove method, otherwise it may give same name of thread
            //can comment and uncomment remove method and check output
            threadLocalObj.remove();
        });

        for (int i = 0; i < 15; i++) {
            //Since Thread local is not cleaned, so they may be chances that if a thread is used for multiple
            //other task, then the thread local will give same name.
            //i.e. reusing same thread local
            executorService.submit(() -> {
                System.out.println(threadLocalObj.get());
            });
        }
    }
}
