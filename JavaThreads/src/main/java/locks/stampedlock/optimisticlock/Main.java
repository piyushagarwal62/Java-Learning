package locks.stampedlock.optimisticlock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            resource.producer();
        });

        Thread thread2 = new Thread(() -> {
            resource.consumer();
        });

        thread1.start();
        thread2.start();
    }
}
