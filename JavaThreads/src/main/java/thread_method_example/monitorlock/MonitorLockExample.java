package thread_method_example.monitorlock;

public class MonitorLockExample {

    static Integer abc = 10;
    Integer xyz = 20;
    //Monitor lock helps to make sure that only 1 thread goes inside the particular section of code(a synchronized block or method)
    //Monitor lock for a thread is applied on synchronized block or method for the same object.
    //So for an object if thread is executing any synchronized block
    // then another thread cannot entered into lock state for same object,
    // so it will have to wait unless the monitor lock is released by first thread.
    // The lock which is applied on the object that monitors its state
    public synchronized void task1() {//acquire lock
        //do something
        try {
            System.out.println("inside task1");
            Thread.sleep(10000);
        } catch (Exception e) {
            //exception handling here
        }
        synchronized (xyz){

        }
    }//release lock

    public static synchronized void task4(){

        synchronized (abc) {

        }
    }
    public void task2() {
        System.out.println("task2, but before synchronized");
        synchronized (this) {
            System.out.println("task2, inside synchronized");
        }
    }

    public void task3() {
        System.out.println("inside task3");
    }

    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();
        MonitorThread1 runnable1 = new MonitorThread1(obj);

        Thread t1 = new Thread(runnable1);
        //Two way of writing the code, one by passing runnable object
        //and another way using lamba expression to directly call the method to run in run method.
        //Since runnable is a functional interface, so can use lamba directly
        Thread t2 = new Thread(() -> {
            obj.task2();
        });
        Thread t3 = new Thread(() -> {
            obj.task3();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}