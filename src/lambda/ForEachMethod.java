package lambda;

import java.util.ArrayList;
import java.util.List;

/* --------------------------- 6. Lambda выражения ------------------------------- */
/* 5. Consumer */
    // 2nd class
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
public class ForEachMethod {

    public static void main(String[] args) {
        // 1
        List<String> list = List.of("Hello!", "How do you do?", "It's OK.", "Bye!");

        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("");
        list.forEach(str -> System.out.println(str));
        System.out.println("");

        // 2
        List<Integer> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.forEach(el -> {
            System.out.println(el);
            el *= 2;
            System.out.println(el);
        });
    }
}
