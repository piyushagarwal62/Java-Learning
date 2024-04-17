package main.java.stream_api;

import main.java.localdb.NamePhone;
import main.java.localdb.NamePhoneEmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingDemo {

    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> arrList = new ArrayList<>();
        arrList.add(new NamePhoneEmail("Larry", "7231231018", "abc@gmail.com"));
        arrList.add(new NamePhoneEmail("Sam", "5638231018", "sam@gmail.com"));
        arrList.add(new NamePhoneEmail("Sam", "3288231018", "sam1@gmail.com"));
        arrList.add(new NamePhoneEmail("Jammy", "9827231018", "jammy@gmail.com"));

        System.out.println("Origial List: ");

        arrList.stream().forEach((a) -> {
            System.out.println(a.getName() + ":" + a.getPhoneNum() + ":" + a.getEmail());
        });

        List<NamePhone> arr = new ArrayList<>();
        for (NamePhoneEmail namePhoneEmail : arrList) {
            if (namePhoneEmail.getName().equals("Sam")) {
            }
            arr.add(new NamePhone(namePhoneEmail.getName(), namePhoneEmail.getPhoneNum()));
        }
        System.out.println();
        Stream<NamePhone> newMap = arrList.stream().map((a) -> new NamePhone(a.getName(), a.getPhoneNum()));

        System.out.println("List of name & phone number");
        newMap.forEach((a) -> {
            System.out.println(a.getName() + ":" + a.getPhoneNum());
        });

        System.out.println("Can you find Sam?");
        Stream<NamePhone> map = arrList.stream().filter((a) -> a.getName().equals("Sam"))
                .map(a -> new NamePhone(a.getName(), a.getPhoneNum()));
        map.forEach((a) -> {
            System.out.println(a.getName() + ":" + a.getPhoneNum());
        });

        Map<String, List<NamePhoneEmail>> mapping = arrList.stream()
                .collect(Collectors.groupingBy(a -> a.getName()));
        System.out.println(mapping);

        Map<String, Long> countMapping = arrList.stream()
                .collect(Collectors.groupingBy(a -> a.getName(), Collectors.counting()));
        System.out.println(countMapping);
        // List<NamePhone> collect = newMap.collect(Collectors.toList());

    }
}
