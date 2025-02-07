import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// Generic Class
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

// Utility class with a Generic Method
class Utils {
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

public class GenericsReflectionDemo {
    public static void main(String[] args) {
        // 1. Using a Generic Class
        Box<Integer> intBox = new Box<>(10);
        Box<String> strBox = new Box<>("Hello Generics");

        System.out.println("Integer Box Value: " + intBox.getValue());
        System.out.println("String Box Value: " + strBox.getValue());

        // 2. Using a Generic Method
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C"};

        System.out.print("Integer Array: ");
        Utils.printArray(intArray);

        System.out.print("String Array: ");
        Utils.printArray(strArray);

        // 3. Reflection API: Inspecting the Box class
        inspectClass(Box.class);
    }

    public static void inspectClass(Class<?> clazz) {
        System.out.println("\n--- Reflection API Output ---");
        System.out.println("Class Name: " + clazz.getName());

        // Inspect Generic Type Parameters
        Type superClass = clazz.getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            Type[] typeArguments = ((ParameterizedType) superClass).getActualTypeArguments();
            for (Type type : typeArguments) {
                System.out.println("Generic Type: " + type.getTypeName());
            }
        }

        // List class methods
        System.out.println("\nMethods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(" - " + method.getName());
        }
    }
}

