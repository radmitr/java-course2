package stream;

import java.util.Arrays;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 5. Метод sorted */
    // 1st class
/* 6. Method chaining */
    // 1st class
/**
    ---------------
     Методы Stream
    ---------------
    Методы Stream не меняют саму коллекцию или массив, от которой был создан stream.

    Методы: map() 'i', filter() 'i', forEach() 't', reduce() 't', sorted() 'i'.

    --------------------------------
     Работа метод chaining в stream
    --------------------------------
              Source                 Terminal method
   (Напр.: коллекции, массив)            (eager)
                       \                 /
                       Intermediate methods
                              (lazy)
*/
public class Test5 {

    // sorted()
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        /* ----- 5. Метод sorted ----- */
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));
        /* --------------------------- */

        /* ----- 6. Method chaining ----- */
        int result = Arrays.stream(array).filter(e -> e % 2 == 1)
                .map(e -> {if(e % 3 == 0) {e = e / 3;} return e;})
                .reduce((a, e) -> a + e).getAsInt();
        System.out.println(result);
        // 3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18
        // 3, 1, 5, 9, 21, 81, 7
        // 1, 1, 5, 3, 7, 27, 7
        // 51
        /* ------------------------------ */
    }
}
