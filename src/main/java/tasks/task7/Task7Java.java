package tasks.task7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Create a list with all element combinations from two lists
 */
public class Task7Java {
    public static void main(String[] args) {
        final CompletableFuture<List<Integer>> numbers = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(1, 2, 3, 4);
        });

        final CompletableFuture<List<Character>> letters = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList('a', 'b', 'c');
        });

        final CompletableFuture<List<String>> combinations = numbers.thenCombine(letters, (numbersList, charactersList) -> {
            final List<String> result = new ArrayList<>();
            for (Integer number : numbersList) {
                for (Character character : charactersList) {
                    result.add(String.format("%d%c", number, character));
                }
            }
            return result;
        });

        System.out.println(combinations);
        try {
            System.out.println(combinations.get(1, TimeUnit.MINUTES));
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
