package thread_method_example.daemon;

import thread_method_example.resume_suspend_issue.SharedResource;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("Main Thread Started");
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread0 calling produce method");
            sharedResource.produce();
        });
        thread1.setDaemon(true);
        thread1.start();

        try {
            Thread.sleep(1000);
            System.out.println("Daemon threads dies as soon as user thread is finished, like main thread");
        } catch (Exception e) {
            //Handle exception here
        }
        System.out.println("Main thread is finishing its work");
    }
}
