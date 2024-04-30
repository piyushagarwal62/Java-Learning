package thread_method_example.monitorlock;

public class MonitorThread1 implements Runnable {

    MonitorLockExample obj;

    public MonitorThread1(MonitorLockExample obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.task1();
    }
}
