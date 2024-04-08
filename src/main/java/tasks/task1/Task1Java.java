package tasks.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a list with all element combinations from two lists
 */
public class Task1Java {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Character> characters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));

        // Imperative programming approach
        List<String> combinations = new ArrayList<>();
        for (Integer number : numbers) {
            for (Character character : characters) {
                String combination = number.toString() + character;
                combinations.add(combination);
            }
        }
        System.out.println(combinations);

        // Functional java
        List<String> combinations2 = numbers.stream()
                .flatMap(number -> characters.stream().map(letter -> number.toString() + letter))
                .toList();

        System.out.println(combinations2);

    }
}
