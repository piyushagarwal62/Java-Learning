package executor_service;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        System.out.println("Thread Executor Pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectionExecutionHandler());
        executor.allowCoreThreadTimeOut(true);

        for (int i = 0; i < 7; i++) {
            executor.submit(() -> {
                try{
                    Thread.sleep(500);
                } catch (Exception e){
                    //handle exception here
                }
                System.out.println("Task Processed by : " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }

    private static class CustomThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(Thread.NORM_PRIORITY);
//            thread.setDaemon(true);
            return thread;
        }
    }

    private static class CustomRejectionExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
//            System.out.println("Task rejected: " + runnable.toString());
        }
    }
}


