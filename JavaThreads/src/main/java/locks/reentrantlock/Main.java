package locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();

        SharedResource resource2 = new SharedResource();
        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            resource1.produce(lock);
        });

        Thread thread2 = new Thread(() -> {
            resource2.produce(lock);
        });

        thread1.start();
        thread2.start();
    }
}
