package lockfree.cas;

import lockfree.withoutcas.SharedResource;

public class AtomicIntegerMain {

    public static void main(String[] args) {
        SharedResourceUsingAtomic sharedResource = new SharedResourceUsingAtomic();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread6 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread7 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread8 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread9 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread10 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        Thread thread11 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sharedResource.increment();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
            thread11.join();
        } catch (Exception e) {
        }
        System.out.println("Counter value: " + sharedResource.get());
    }

}
