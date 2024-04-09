package examples.part3functions;

import java.util.List;

public class MainJava {
    public static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static int increment(int x) {
        return x + 1;
    }

    public static int doubleNumber(int x) {
        return x * 2;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 1, 7, 2, 4, 6, 8, 10);

        // pass function as argument
        List<Integer> doubledNumbers = numbers.stream().map(MainJava::doubleNumber).toList();

        // use an anonymous(inline) defined function
        List<Integer> anonymousFunc = numbers.stream().map(x -> x * 2).toList();

        // it is possible to chain functions
        List<Integer> chainFunctions = numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(MainJava::increment)
                .map(MainJava::doubleNumber)
                .toList();

        chainFunctions.forEach(System.out::println);

        // Java doesn't support type inference like Scala, so return type must be explicitly stated

        System.out.println(factorialTail(3));

        String input = "123321";
        System.out.println(isPalindrome(input));
        System.out.println(isPalindromeRec(input));
        System.out.println(isPalindromeRev(input));
    }

    // Recursion (stack vs tail)
    public static long factorialStack(long n) {
        if (n == 0)
            return 1;
        else
            return n * factorialStack(n - 1);
    }

    public static long factorialTail(long n) {
        return fact(n, 1);
    }

    private static long fact(long n, long acc) {
        if (n == 0)
            return acc;
        else
            return fact(n - 1, n * acc);
    }

    public static boolean isPalindrome(String input) {
        boolean result = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                result = false;
            }
        }
        return result;
    }

    public static boolean isPalindromeRec(String input) {
        if (input.length() <= 1) {
            return true;
        } else {
            if (input.charAt(0) != input.charAt(input.length() - 1)) {
                return false;
            } else {
                return isPalindromeRec(input.substring(1, input.length() - 1));
            }
        }
    }

    public static boolean isPalindromeRev(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }
}
