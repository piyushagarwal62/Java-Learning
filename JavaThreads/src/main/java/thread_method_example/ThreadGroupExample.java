package thread_method_example;

public class ThreadGroupExample {
    public static void main(final String[] args) {
        final Runnable runnable1 = () -> {
            System.out.println("Runnable One");
        };

        final Runnable runnable2 = () -> {
            System.out.println("Runnable Two");
        };

        final Runnable runnable3 = () -> {
            System.out.println("Runnable Three");
        };

        final Runnable runnable4 = () -> {
            System.out.println("Runnable Four");
        };

        final ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");

        final Thread thread1 = new Thread(threadGroup, runnable1, "ThreadOne");
        thread1.start();
        final Thread thread2 = new Thread(threadGroup, runnable2, "ThreadTwo");
        thread2.start();
        final Thread thread3 = new Thread(threadGroup, runnable3, "ThreadThree");
        thread3.start();
        final Thread thread4 = new Thread(threadGroup, runnable4, "ThreadFour");
        thread4.start();
        System.out.println("Thread group name :: " + threadGroup.getName());

        threadGroup.list();
    }
}