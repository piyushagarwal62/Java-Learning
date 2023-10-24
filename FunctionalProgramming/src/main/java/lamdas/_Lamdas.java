package lamdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Lamdas {
    public static void main(String[] args) {
        Integer number = null;
        int counter = 0;

        Function<String, String> upperCaseName1 = name -> name.toUpperCase();

        //Similar by using method reference
        Function<String, String> upperCaseName2 = String::toUpperCase;


        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            //Should be avoided since this will lead to impure function and maintaining variable state which are outside the lamdas
            //counter = 0;

            // logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName1.apply("piyush"));
        System.out.println(upperCaseName2.apply("agarwal"));
        System.out.println(upperCaseName.apply("Alex", null));
    }
}
