package locks.readwritelock;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread thread1 = new Thread(() -> {
            resource.produce(lock);
        });

        Thread thread2 = new Thread(() -> {
            resource.produce(lock);
        });


        SharedResource resource1 = new SharedResource();
        Thread thread3 = new Thread(() -> {
            resource1.consume(lock);
        });
        System.out.println("Main Thread" + LocalDateTime.now());
        thread1.start();
        thread3.start();
        thread2.start();
    }
}
