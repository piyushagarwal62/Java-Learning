package com.codebypiyush.miscellaneous;

public class SwitchExpression {

    enum CARD_TYPE {VISA, RUPAY, MASTERCARD, AMEX}
    public static void main(String[] args) {
        switchAllowIntegerUntilJava7();
        switchAllowStringAndEnumFromJava8();
        switchAllowReturnValueUsingBreakJava12();
        switchAllowArrowOperatorsToReturnValueJava12();
        switchAllowMultipleCaseJava12();
        switchAllowPatternMatchingJava17();
    }

    private static void switchAllowIntegerUntilJava7(){
        System.out.println("===Output for Java 7: Allowing only integer========");
        int value = 5;
        switch (value) {
            case 1:
                System.out.println("One");
                break;
            case 5:
                System.out.println("five");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    private static void switchAllowStringAndEnumFromJava8(){
        System.out.println("===Output for Java 8: Allowing only String and Enum========");
        String cardType = "RUPAY";
        //its important to make a string as constant/final otherwise it may not compile and give error
        final String visa = "VISA";
        switch (cardType) {
            case visa:
                System.out.println("Visa");
                break;
            case "RUPAY":
                System.out.println("RuPay");
                break;
            case "MASTER CARD":
                System.out.println("Master Card");
                break;
            default:
                System.out.println("Unknown");
        }

        CARD_TYPE rupay = CARD_TYPE.RUPAY;
        switch (rupay) {
            case VISA:
                System.out.println("Visa");
                break;
            case RUPAY:
                System.out.println("RuPay");
                break;
            case MASTERCARD:
                System.out.println("Master Card");
                break;
            case AMEX:
                System.out.println("Amex");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    private static void switchAllowReturnValueUsingBreakJava12(){
        System.out.println("===Output for Java 12: Allowing return value using break and later replaced by yield in java 13========");
        String day = "Tuesday";
        //its important to make a string as constant/final otherwise it may not compile and give error
        final String monday = "Monday";
        String ans = switch (day) {
            case monday:
                /*In java version 12, switch was known as switch expression instead of statement since now it can return
                value using break, but later it was removed in java 13 and separate keywork yield was use for the same
                */

//                break "Weekday";
                yield "Weekday";
            case "Tuesday":
                yield "Weekday";
            case "Wednesday":
                yield "Weekday";
            case "Thursday":
                yield "Weekday";
            case "Friday":
                yield "Weekday";
            case "Saturday":
                yield "Weekend";
            case "Sunday":
                yield "Weekend";
            default:
                yield "Unknown";
        };
        System.out.println("Switch Return value : " + ans);
    }

    private static void switchAllowArrowOperatorsToReturnValueJava12(){
        System.out.println("===Output for Java 12: Allowing arrow operator to return value========");
        String day = "Tuesday";
        String ans = switch (day) {
            case "Monday"-> "Week day";
            case "Tuesday"-> "Week day";
            case "Wednesday"->"Week day";
            case "Thursday"->"Week day";
            case "Friday"->"Week day";
            case "Saturday"-> "Weekend";
            case "Sunday" -> "Weekend";
            case Object s -> "Can also pass Object in pattern matching"; //its allow in java 17
        };
        System.out.println("Switch Return value : " + ans);
    }

    private static void switchAllowMultipleCaseJava12(){
        System.out.println("===Output for Java 12: Allowing multiple case in one ========");
        String day = "Tuesday";
        String ans = switch (day) {
            case "Monday","Tuesday","Wednesday","Thursday","Friday"
                    -> "Week day";
            case "Saturday", "Sunday" -> "Weekend";
            default->"Unknown";
        };
        System.out.println("Switch Return value : " + ans);
    }

    private static void switchAllowPatternMatchingJava17(){
        System.out.println("===Output for Java 17: Allowing pattern matching within switch case ========");
        final Object obj = Integer.valueOf(10);
        String ans = switch (obj) {
            //Its known as guarded Pattern introduced in java 17, but works only on some ide
//            case Integer i && (i.equals(11)) -> "It is an integer";
            case Integer i -> "It is an integer";
            case String s -> "It is a string";
            case Object s -> "It is an Employee Object";
            //It also allow to check for null case in java 17
            case null -> "Its a null object";
        };
        System.out.println("Switch Return value : " + ans);
    }
}
