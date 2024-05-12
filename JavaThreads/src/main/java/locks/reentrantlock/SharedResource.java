package locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;

    //Another way is to create single main resource object and then synchronize using lock object below,
    //instead of passing in produce method here
//    ReentrantLock lock;


    public void produce(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {

        } finally {
            System.out.println("Lock release by: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
