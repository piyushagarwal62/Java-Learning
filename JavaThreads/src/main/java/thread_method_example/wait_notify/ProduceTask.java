package thread_method_example.wait_notify;

public class ProduceTask implements Runnable {

    SharedResource sharedResource;

    public ProduceTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000l);
        } catch (Exception e) {
            //handle any exception here
        }
        sharedResource.addItem();
    }
}
