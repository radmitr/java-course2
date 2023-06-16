package lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

/* --------------------------- 6. Lambda выражения ------------------------------- */
/* 3. Predicate */
    // 3nrd class
/**
    --------------------------
     Пакет java.util.function
    --------------------------

    ---------------------------------------------------
    Predicate<T>                    boolean test(T t);
    Используется методом removeIf
    ---------------------------------------------------
    Supplier<T>                     T get();
    ---------------------------------------------------
    Consumer<T>                     void accept(T t);
    Используется методом forEach
    ---------------------------------------------------
    Function<T, R>                  R apply(T t);
    ---------------------------------------------------
*/
public class RemoveIfMethod {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("Hello");
        al.add("Bye");
        al.add("OK");
        al.add("Learning Java");
        al.add("Specifically lambda");
        System.out.println(al);

        // 1
//        al.removeIf(element -> element.length() < 5);
//        System.out.println(al);

        // 2
        Predicate<String> p = element -> element.length() < 5;
        al.removeIf(p);
        System.out.println(al);
    }
}
