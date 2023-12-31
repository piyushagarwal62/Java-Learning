package callbacks;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello2("John",
                null,
                () -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("no lastName provided");
                    System.out.println(Thread.currentThread().getName());
                });

        hello("John", null, value -> {
            System.out.println("no lastName provided for " + value);
        });


    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            Thread t1 = new Thread(callback);
            t1.setName("hello2 Thread");
            t1.start();
            System.out.println("hello11: " + Thread.currentThread().getName());
        }
    }

    //Similar to JavaScript code
//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName)
//        } else {
//            callback();
//        }
//    }
}