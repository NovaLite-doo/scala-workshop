package examples.part4option;

import java.util.Optional;

public class MainJava {
    public static void main(String[] args) {
        // Optional can be either present -> value exists or empty -> value doesn't exist

        Optional<Integer> optionalValue = Optional.of(1); // -> Some(1)

        Optional<Integer> empty = Optional.empty(); // -> None

        Optional<Integer> fromNull = Optional.ofNullable(null); // -> None

        // In Java direct assignment doesn't exist
        Optional<Integer> some = Optional.of(1);
        Optional<Integer> none = Optional.empty();

        System.out.println(optionalValue);
        System.out.println(empty);
        System.out.println(fromNull);

        // How to get value from Optional

        // .get (not recommended) why?
        Integer getSome = some.get();
        System.out.println(getSome);

        // Will throw an exception
        // Integer getNone = none.get();

        // access possible value from optional
        optionalValue.ifPresent(System.out::println);

        Optional<Integer> anotherOption = optionalValue.map(x -> x + 1); // also returns an optional value

        // get with default value if optional is empty
        Integer defaultValue = empty.orElse(0);
    }
}
