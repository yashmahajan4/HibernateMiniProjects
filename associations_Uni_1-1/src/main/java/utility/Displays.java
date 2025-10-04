package utility;
import java.util.List;
import java.util.Objects;

public final class Displays {

    private static final String SEPARATOR = "=======================================================================";

    private Displays() {
        // Utility class, prevent instantiation
        throw new AssertionError("Cannot instantiate utility class");
    }

    public static void print(Object obj) {
        System.out.println(SEPARATOR);
        System.out.println(Objects.toString(obj, "No data available"));
        System.out.println(SEPARATOR);
    }

    public static <T> void print(List<T> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No records found");
            return;
        }

        String className = items.get(0) != null ? items.get(0).getClass().getSimpleName() : "Object";
        System.out.println("====== " + className + " List ======");

        items.forEach(item -> System.out.println(Objects.toString(item, "null")));

        System.out.println("===================================");
    }
}
