package stream;

import java.util.ArrayList;
import java.util.List;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 18. Parallel Stream */
/**
    -----------------
     Parallel stream
    -----------------
    Parallel stream – это возможность использования нескольких ядер процессора при выполнении
                      каких-либо операций со stream.

    list.parallelStream(). …

    Stream<T> s = Stream.of(…);
    s.parallel(). …
*/
public class ParallelStream {

    // 1, 2, 3, 4, ... 1_000_000_000
    // --------------------------------
    // I:             1 - 250_000_000
    // II:  250_000_001 - 500_000_000
    // III: 500_000_001 - 750_000_000
    // IV:  750_000_001 - 1_000_000_000

    // parallelStream()
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();

        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        // 0 - stream()
        double sumResult = list.stream()
                .reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("sumResult = " + sumResult); // >> sumResult = 16.25
        // 1 - parallelStream()
        double sumResult2 = list.parallelStream()
                .reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("sumResult2 = " + sumResult2); // >> sumResult2 = 16.25

        // 0.1 - stream()
        double divisionResult = list.stream()
                .reduce((accumulator, element) -> accumulator / element).get();
        System.out.println("divisionResult = " + divisionResult); // >> divisionResult = 8.0
        // 1.1 - parallelStream()
        double divisionResult2 = list.parallelStream()
                .reduce((accumulator, element) -> accumulator / element).get();
        System.out.println("divisionResult2 = " + divisionResult2); // divisionResult2 = 0.5 !!!!!!!!
        // I:  10 / 5 = 2
        // II: 1 / 0.25 = 4
        // ----------------
        // 2 / 4 = 0.5
    }
}
