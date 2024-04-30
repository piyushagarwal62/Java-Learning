package lockfree.withoutcas;

public class Main {
    //If number of threads are less or equal to cpu core then output is correct
    //but when number of threads are more and cpu core at a time cannot run all of them, then output changes which is not right
    //here as we have 11 threads and each thread is incrementing counter value by 100 by one at a time.
    //So total should be 1100 but its either 800 or 900
    //Which shoes that without synchronized block this may not work correctly.
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

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
