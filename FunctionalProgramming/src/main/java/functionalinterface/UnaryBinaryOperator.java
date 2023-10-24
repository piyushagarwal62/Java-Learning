package functionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperator {
    public static void main(String[] args) {
        UnaryOperator<Integer> doubleValue = x -> x * 2;
        int result = doubleValue.apply(5); // Result: 10
        System.out.println("Result: " + result);

        BinaryOperator<Integer> max = (a, b) -> (a >= b) ? a : b;
        int binaryResult = max.apply(8, 5); // Result: 8
        System.out.println("Result: " + binaryResult);
    }
}
