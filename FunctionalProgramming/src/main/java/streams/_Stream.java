package streams;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    //world == WSOSRSLSD
//    worolodo = waralada
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        List<Person> people1 = people.stream().filter(person -> person.name.startsWith("A"))
                .collect(Collectors.toList());
        people.stream().map(person -> "worolorod".replace("o", "a")).forEach(System.out::println);
        people.stream().map(person -> person.gender)
                .collect(Collectors.toList());

        System.out.println("Get Distinct Gender");
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Get Distinct Name");
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Get length of each name");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);
        //Alternate way with all extraction
        printLengthOfPersonNameWithExtraction(people);

        System.out.println("Any Female available in list" +
                people.stream().anyMatch(person -> FEMALE.equals(person.gender)));

        Predicate<Person> personPredicate = person -> PREFER_NOT_TO_SAY.equals(person.gender);
        System.out.println("All Prefer not to say available in list" +
                people.stream().allMatch(personPredicate));
    }

    static void printLengthOfPersonNameWithExtraction(List<Person> people) {
        System.out.println("Get length of each name");
        Function<Person, String> functionName = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(functionName)
                .mapToInt(length)
                .forEach(println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}