package main.java.stream_api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BasicStreamDemo {

    public static void main(String[] args) {
        List<Integer> arrList = List.of(45, 56, 23, 20, 71, 5, 8);
/*
		int min = arrList.get(0);
		for (int i = 1; i < arrList.size(); i++) {
			if(min> arrList.get(i)){
				min = arrList.get(i);
			}
		}
		System.out.println(min);
*/
        System.out.println("Origial List: " + arrList);

        Stream<Integer> stream = arrList.stream(); // Created a stream
        Optional<Integer> minValue = stream.min(Integer::compare);//Process
        Optional<Integer> minValueWithReduce = stream.reduce(Integer::min);
        if (minValue.isPresent()) {
            System.out.println("Min Value: " + minValue.get());//Consume
            System.out.println("Min Value with Reduce: " + minValueWithReduce.get());
        }

        stream = arrList.stream();//Create Stream
        Optional<Integer> maxValue = stream.max(Integer::compare);
        if (maxValue.isPresent()) {
            System.out.println("Max Value: " + maxValue.get());
        }

        Stream<Integer> sorted = arrList.stream().sorted(); //process stream

        System.out.println("Display all the values in sorted format");
        sorted.forEach((n) -> System.out.println("Values are: " + n)); //consume stream

        System.out.println("Display only odd values");
        sorted = arrList.stream().sorted(); //Create Stream
        sorted.filter((n) -> n % 2 == 1).forEach(System.out::println);

        System.out.println("Display values that are odd and greater then 10");
        sorted = arrList.stream().sorted();
        sorted.filter(n -> n % 2 == 1).filter(n -> n > 10).forEach(System.out::println);

    }
}
