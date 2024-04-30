package locks.semaphorelock;

import java.util.concurrent.Semaphore;

public class SharedResource {

    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);
    //In Semaphore lock can be acquire at a time by more than one thread.
    //Like lets say if they are two printers where lock can be acquire for two thread for two resources

    public void produce() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {

        } finally {
            lock.release();
            System.out.println("Lock release by: " + Thread.currentThread().getName());
        }
    }
}
