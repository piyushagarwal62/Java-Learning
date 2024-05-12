package thread_method_example.resume_suspend_issue;

public class MainClass {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        System.out.println("Main Thread Started");
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread0 calling produce method");
            sharedResource.produce();
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            System.out.println("Thread1 calling produce method");
            sharedResource.produce();
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("Thread0 is suspended");
        thread1.suspend();
        //This statement won't release the acquired lock and hence the other thread remains in waiting state always
        //waiting for resource to release.

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("Thread0 is Resumed");
        //If thread0 is no resumed then another thread never able to acquire lock
//        thread1.resume();
        System.out.println("Main thread is finishing its work");
    }
}
