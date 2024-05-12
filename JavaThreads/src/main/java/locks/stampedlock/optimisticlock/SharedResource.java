package locks.stampedlock.optimisticlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    int a = 10;
    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Take optimistic lock by: " + Thread.currentThread().getName());
            a = 11;
            Thread.sleep(6000);
            if (lock.validate(stamp)) {
                System.out.println("Updated a value successfully");
            } else {
                System.out.println("rollback of work");
                a = 10;//rollback
            }
        } catch (Exception e) {

        }
        //For optimistic, dont require unlock since its gonna try for read lock which is optimistic
    }

    public void consumer() {
        long stamp = lock.writeLock();
        System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());

        try {
            System.out.println("performing work by : " + Thread.currentThread().getName());
            a = 9;
        } catch (Exception e) {

        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock release by: " + Thread.currentThread().getName());
        }
    }
}
