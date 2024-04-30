package thread_method_example.resume_suspend_issue;

public class SharedResource {

    boolean isAvailable = false;

    public synchronized void produce() {
        System.out.println("Lock acquired by: " + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            //handle some exception here
        }
        System.out.println("Lock released by: " + Thread.currentThread().getName());
    }
}
