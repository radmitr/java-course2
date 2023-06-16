package stream;

import java.util.Arrays;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 3. Метод forEach */
    // 1st class
/**
    ---------------
     Методы Stream
    ---------------
    Методы Stream не меняют саму коллекцию или массив, от которой был создан stream.

    Методы: map() 'i', filter() 'i', forEach() 't', reduce() 't', sorted() 'i'.
*/
public class Test3 {

    // forEach()
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};

        System.out.println(Arrays.toString(array));

        // 1
        Arrays.stream(array).forEach(el -> {
            el *= 2;
            System.out.println(el);
        });
        System.out.println(Arrays.toString(array));
        System.out.println("-------------------");

        // 2.1
        Arrays.stream(array).forEach(el -> System.out.println(el));
        System.out.println("-------------------");
        // 2.2 - method reference
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("-------------------");

        // 3.1 - method reference
        Arrays.stream(array).forEach(Utils::myMethod);
        System.out.println("-------------------");
        // 3.2
        Arrays.stream(array).forEach(el -> Utils.myMethod(el));
        System.out.println("-------------------");
    }
}

class Utils {
    public static void myMethod(int a) {
        a = a + 5;
        System.out.println("Element = " + a);
    }
}
