package locks.readwritelock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;

    public void produce(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName()
                    + " :" + LocalDateTime.now().toLocalTime());
            isAvailable = true;
            Thread.sleep(8000);
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
            System.out.println("Read Lock release by: " + Thread.currentThread().getName()
                    + " :" + LocalDateTime.now().toLocalTime());
        }
    }

    public void consume(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName()
                    + " :" + LocalDateTime.now().toLocalTime());
            isAvailable = false;
            Thread.sleep(8000);
        } catch (Exception e) {

        } finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock release by: " + Thread.currentThread().getName()
                    + " :" + LocalDateTime.now().toLocalTime());
        }
    }
}
