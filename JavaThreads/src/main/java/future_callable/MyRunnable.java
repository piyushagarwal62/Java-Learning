package future_callable;

import java.util.List;

public class MyRunnable implements Runnable {

    List<Integer> list;

    public MyRunnable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add(300);
        //It has to do some more work lets say
    }
}
