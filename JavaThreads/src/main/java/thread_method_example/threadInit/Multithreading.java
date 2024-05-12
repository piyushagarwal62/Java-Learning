package thread_method_example.threadInit;

public class Multithreading implements Runnable{
    @Override
    public void run() {
        System.out.println("code executed by thread: " + Thread.currentThread().getName());
    }
}
