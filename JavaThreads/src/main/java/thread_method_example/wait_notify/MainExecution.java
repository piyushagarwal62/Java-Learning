package thread_method_example.wait_notify;

public class MainExecution {

    public static void main(String[] args) {
        System.out.println("main method start");

        SharedResource sharedResource = new SharedResource();

        //producer thread
        Thread producerThread = new Thread(new ProduceTask(sharedResource));

        Thread consumerThread = new Thread(new ConsumeTask(sharedResource));

        //thread is in "RUNNABLE state"
        producerThread.start();
        consumerThread.start();

        System.out.println("Main method ends");
    }
}
