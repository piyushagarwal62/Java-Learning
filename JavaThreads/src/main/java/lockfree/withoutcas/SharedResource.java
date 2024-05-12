package lockfree.withoutcas;

public class SharedResource {
    int counter;

    //One way to solve issue is to apply synchronized keyword
    public void increment() {
        counter++;
    }

    public int get() {
        return counter;
    }
}
