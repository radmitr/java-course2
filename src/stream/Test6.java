package stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 6. Method chaining */
    // 3rd class
/* 7. Метод concat */
/* 8. Метод distinct */
/* 9. Метод count */
/* 10. Метод peak */
/**
    --------------------------------
     Работа метод chaining в stream
    --------------------------------
              Source                 Terminal method
   (Напр.: коллекции, массив)            (eager)
                       \                 /
                       Intermediate methods
                              (lazy)

    ---------------
     Методы Stream
    ---------------
    Методы: concat(), distinct() 'i', count() 't', peek() 'i', flatMap() 'i', collect() 't'.
                                                                              /     \
                                                                    groupingBy()   partitioningBy()
*/
public class Test6 {

    // concat(), distinct(), count(), peek()
    public static void main(String[] args) {
        /* ----- 6. Method chaining ----- */
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        // 1 - not being executed, because there is no terminal
//        stream1.filter(e -> {
//            System.out.println("!!!");
//            return e % 2 == 0;
//        });
        // 2 - executed
        stream1.filter(e -> {
            System.out.println("!!!");
            return e % 2 == 0;
        }).collect(Collectors.toList());
        System.out.println("-----------------------");
        /* ------------------------------ */

        /* ----- 7. Метод concat ----- */
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream3 = Stream.of(6, 7, 8, 9, 10);
        Stream<Integer> stream4 = Stream.concat(stream2, stream3);
        stream4.forEach(System.out::println);
        System.out.println("-----------------------");
        /* --------------------------- */

        /* ----- 8. Метод distinct ----- */
//        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
//        stream5.distinct().forEach(System.out::println);
//        System.out.println("-----------------------");
        /* ----------------------------- */

        /* ----- 9. Метод count ----- */
//        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
//        // 1
////        System.out.println(stream5.count());
//        // 2
//        System.out.println(stream5.distinct().count()); //  if "// 1" java.lang.IllegalStateException
//        System.out.println("-----------------------");
        /* -------------------------- */

        /* ----- 10. Метод peak ----- */
        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println(stream5.distinct().peek(System.out::println).count());
        System.out.println("-----------------------");
        /* -------------------------- */
    }
}
