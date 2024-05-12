package thread_method_example.join;

import thread_method_example.resume_suspend_issue.SharedResource;

public class JoinMethodDemo {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("Main Thread Started");
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread0 calling produce method");
            sharedResource.produce();
        });
        thread1.start();

        try {
            System.out.println("Main Thread is waiting for thread0 to finish now");
            thread1.join();
        } catch (Exception e) {
            //Handle exception here
        }
        System.out.println("Main thread is finishing its work");
    }
}
