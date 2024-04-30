package threadlocal;

public class BasicThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //main thread
        threadLocal.set(Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("task1");
        });

        thread.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        //here we have main thread
        System.out.println("Main thread: " + threadLocal.get());
    }
}
