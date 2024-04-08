package examples.part1basics;

import java.util.*;

public class MainJava {
    public static void main(String[] args) {
        // final => immutable
        final String name = "Jane"; // var

        // anotherName = "John"; => ERROR

        // mutable
        String example = "hello";
        example = "goodbye";

        class Person {
          final String firstName;
          String lastName;

          public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
          }

          @Override
          public String toString() {
              return String.format("%s %s", firstName, lastName);
          }
        }

        Person person = new Person("John", "Doe");
        System.out.println(person.firstName);
        System.out.println(person);

        // Define list, map, set

        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);

        List<Integer> numbersFromRange = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbersFromRange.add(i);
        }

        // unordered by default
        Set<Integer> numbersSet = new HashSet<>();
        numbersSet.add(1);
        numbersSet.add(1);
        numbersSet.add(3);
        numbersSet.add(2);
        numbersSet.add(2);
        numbersSet.add(2);
        numbersSet.add(4);
        numbersSet.add(5);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        System.out.println(numbersList);
        System.out.println(numbersFromRange);
        System.out.println(numbersSet);
        System.out.println(map);
    }
}
