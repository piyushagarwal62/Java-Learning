package thread_method_example.buffer_wait_notify;

/*
 * Two threads, a producer and a consumer, share a common, fixed-size buffer as a queue.
 * The producer's job is to generate data and put it into the buffer, while the consumer's
 * job is to consume the data from the buffer
 * The problem is to make sure that the producer won't produce data if the buffer is full,
 * and the consumer won't consume the data if the buffer is empty.
 * */
public class MainClass {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    sharedResource.produce(i);
//                    Thread.sleep(1000l);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    sharedResource.consume();
//                    Thread.sleep(1000l);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        consumer.start();
        producer.start();
    }
}
