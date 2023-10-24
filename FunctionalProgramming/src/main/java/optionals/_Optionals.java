package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class _Optionals {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElse("default value");
        System.out.println(value);

        Object value1 = Optional.ofNullable("Hello")
                .orElse("default value");
        System.out.println(value1);

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("Exception");
        Object value2 = Optional.ofNullable("hello")
                .orElseThrow(exception);
        System.out.println(value2);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));
    }
}
