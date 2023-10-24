package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        //Function takes single argument and return single value
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiple = multiplyByOneFunction.apply(increment2);
        System.out.println(multiple);

        Function<Integer, Integer> addBy1ThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyByOneFunction);
        System.out.println(addBy1ThenMultiplyBy10.apply(4));

        //Bi Function takes two argument and return single value
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyFunction.apply(4, 100));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByOneFunction = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int increment, int multiplyBy) {
        return (increment + 1) * multiplyBy;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
            (incrementNumber, multiplyNumber) -> (incrementNumber + 1) * multiplyNumber;
}
