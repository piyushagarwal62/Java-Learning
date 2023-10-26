package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleProgram1 {

    public static void main(String[] args) {
        List<Person> people = getPeopleList();
        List<Person> femaleList = new ArrayList<>();
        //Imperative Approach
        for (Person person : people) {
            if (Person.Gender.FEMALE.equals(person.getGender())) {
                femaleList.add(person);
            }
        }
        femaleList.forEach(System.out::println);

        //Declarative Approach

        //Filter
        List<Person> femalesCollection = people.stream()
                .filter(person -> Person.Gender.FEMALE.equals(person.getGender()))
                .collect(Collectors.toList());
        femalesCollection.forEach(System.out::println);

        //Sort
        Stream<Person> sortedList = people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender));
        sortedList.forEach(System.out::println);

        //All Match
        boolean allMatch = people.stream().allMatch(person -> person.getAge() > 14);
        System.out.println("All Match:" + allMatch);

        //Any Match
        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 44);
        System.out.println("Any Match:" + anyMatch);

        //None Match
        boolean noneMatch = people.stream().noneMatch(person -> person.getAge() < 14);
        System.out.println("None Match:" + noneMatch);

        //Max
        people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
        //Min
        people.stream().min(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

        //Group
        Map<Person.Gender, List<Person>> groupByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

        //Optinal and Map
        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Person.Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        System.out.print("Oldest Female Name: ");
        oldestFemaleAge.ifPresent(System.out::println);
    }

    private static List<Person> getPeopleList() {
        return List.of(new Person("Alex", 25, Person.Gender.MALE),
                new Person("Alice", 35, Person.Gender.FEMALE),
                new Person("Aliya", 38, Person.Gender.FEMALE),
                new Person("Maxi", 15, Person.Gender.MALE),
                new Person("Alem", 30, Person.Gender.MALE),
                new Person("Rocky", 45, Person.Gender.FEMALE),
                new Person("Rihana", 15, Person.Gender.FEMALE),
                new Person("Sandara", 19, Person.Gender.FEMALE),
                new Person("Green", 28, Person.Gender.MALE)
        );
    }
}
