import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Functional Interface
@FunctionalInterface
interface Greeting {
    void sayMessage(String message);
}

public class Java8FeaturesDemo {
    public static void main(String[] args) {
        // 1. Lambda Expression Example
        Greeting greeting = message -> System.out.println("Hello, " + message);
        greeting.sayMessage("Java 8");

        // 2. Functional Interface - Predicate
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        // 3. Functional Interface - Function
        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Lambda': " + stringLength.apply("Lambda"));

        // 4. Streams API Example
        List<String> names = Arrays.asList("Kurmanzhan", "Bob", "Alice", "Charlie", "David", "Eve");

        // Case-insensitive filter for names starting with 'A'
        List<String> filteredNames = names.stream()
                .filter(name -> name.toLowerCase().startsWith("a")) // Fix applied
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Filtered Names: " + filteredNames);

        // Sum of even numbers in a list using Streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOfEvens = numbers.stream()
                .filter(isEven) 
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Even Numbers: " + sumOfEvens);
    }
}
