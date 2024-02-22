import java.text.SimpleDateFormat;

public class ThreadLocalExample {


    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        public SimpleDateFormat get() {
            return super.get();
        }
    };

    public static void main(String[] args) {


    }

}
