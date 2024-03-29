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

        forOptionalEmpty();
        forOptionalWithNull();
        forOptionalIfPresent();
        usingOptionalWithClass();
        usingOptionalWithGetMethod();
    }

    static void forOptionalEmpty() {
        System.out.println("====forOptionalEmpty======");
        Optional empty = Optional.empty();
        System.out.println(empty.isPresent()); // false
        System.out.println(empty.isEmpty()); // true
    }

    static void forOptionalWithNull() {
        System.out.println("====forOptionalWithNull======");
        Optional<String> hello = Optional.ofNullable(null);
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String orElse = hello.orElse("world");

        hello.ifPresent(System.out::println);

        orElse = hello.map(String::toUpperCase)
                .orElse("world");
        System.out.println(orElse);

        hello.map(String::toUpperCase).orElseThrow(IllegalStateException::new);
    }


    static void forOptionalIfPresent() {
        System.out.println("====forOptionalIfPresent======");
        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        hello.ifPresent(System.out::println);
        hello.ifPresentOrElse(System.out::println, () -> System.out.println("world"));
    }

    static void usingOptionalWithClass() {
        System.out.println("====usingOptionalWithClass======");
        Person person = new Person("Alex", "ALEX@gmail.com");
        person.getEmail()
                .ifPresentOrElse(x -> System.out.println(x.toLowerCase()),
                        () -> System.out.println("Email not provided"));

        System.out.println(person.getEmail()
                .map(String::toLowerCase)
                .orElse("Email not provided"));
    }

    static void usingOptionalWithGetMethod() {
        System.out.println("====Optional with get() method======");
        //It is good to use get, but it may also throw exception if value not found.
        //So can use with isPresent() or orElseGet() to get the value
        Optional value = Optional.ofNullable("String Value");
        if(value.isPresent()){
            System.out.println(value.get());
        }
        Person person = null;
        Optional<Person> personObject = Optional.of(person);
        //Supposing the value is empty or null
        Person alex = personObject.orElseGet(() -> new Person("Alex", "alex@gmail.com"));
        System.out.println(alex.getName()); // true
    }

    static class Person {
        String name;
        String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
