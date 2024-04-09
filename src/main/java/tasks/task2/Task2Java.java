package tasks.task2;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/** Capitalize the first letter of each word in sentence
 */
public class Task2Java {
    public static void main(String[] args) {
        var text = "this is a simple text.";

        // Functional Java
        var capitalized = Arrays.stream(text.split(" ")).map(StringUtils::capitalize).toList();
        var result = String.join(" ", capitalized);

        System.out.println(result);

    }
}
