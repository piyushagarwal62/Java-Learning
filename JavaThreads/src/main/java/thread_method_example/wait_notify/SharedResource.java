package thread_method_example.wait_notify;

public class SharedResource {

    boolean isItemPresent = false;

    //synchronized put the monitor lock
    public synchronized void addItem() {
        isItemPresent = true;
        System.out.println("Item added by: " + Thread.currentThread().getName()
                + " and invoking all threads which are waiting for consuming item");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("consumeItem method invoked by: " + Thread.currentThread().getName());

        //using while look to avoid "spurious wake-up", sometimes because of system noise
        while (!isItemPresent) {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting now");
                wait();
            } catch (Exception e) {
                //handle exception here
            }
        }
        System.out.println("Item Consumed by: " + Thread.currentThread().getName());
        isItemPresent = false;
    }
}
