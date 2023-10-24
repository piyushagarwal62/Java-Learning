package imperativeprog;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Mark", Person.Gender.MALE),
                new Person("Mercy", Person.Gender.MALE),
                new Person("Max", Person.Gender.MALE),
                new Person("Anna", Person.Gender.FEMALE));

        //Imerative Approach
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Person.Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        //Declarative Approach
        people.stream().filter(person -> Person.Gender.FEMALE.equals(person.gender))
                .forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        enum Gender {
            MALE,
            FEMALE
        }
    }
}
