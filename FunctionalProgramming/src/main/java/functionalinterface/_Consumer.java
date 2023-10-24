package functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        // Normal java function
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        // Consumer Functional interface
        greetCustomerConsumer.accept(maria);

        anOtherConsumerExampleWithBothMethod();

        //BiConsumer Functional interface
        greetCustomerConsumerV2.accept(maria, false);
        similarExampleWithBiConsumerWithBothMethod();

    }

    static void anOtherConsumerExampleWithBothMethod() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Create a Consumer to print the number
        Consumer<Integer> printNumber = n -> System.out.print(n + " ");

        // Create a Consumer to double the number
        Consumer<Integer> doubleNumber = n -> System.out.print(n * 2 + " ");

        // Chain the two Consumer functions using andThen
        Consumer<Integer> printAndDouble = printNumber.andThen(doubleNumber);

        // Apply the chained Consumer to each number in the list
        numbers.forEach(printAndDouble);
        System.out.println();
    }

    static void similarExampleWithBiConsumerWithBothMethod() {
        // Create a BiConsumer to add two numbers
        BiConsumer<Integer, Integer> addNumbers = (a, b) -> System.out.println(a + b);

        // Create a BiConsumer to multiply two numbers
        BiConsumer<Integer, Integer> multiplyNumbers = (a, b) -> System.out.println(a * b);

        // Chain the two BiConsumer functions using andThen
        BiConsumer<Integer, Integer> addAndMultiply = addNumbers.andThen(multiplyNumbers);

        // Apply the chained BiConsumer to two numbers
        addAndMultiply.accept(3, 5);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*********"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + customer.customerPhoneNumber);

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "*********"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
