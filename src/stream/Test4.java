package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 4. Метод reduce */
/**
    ---------------
     Методы Stream
    ---------------
    Методы Stream не меняют саму коллекцию или массив, от которой был создан stream.

    Методы: map() 'i', filter() 'i', forEach() 't', reduce() 't', sorted() 'i'.
*/
public class Test4 {

    // reduce()
    public static void main(String[] args) {
        // 1
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        int result = list.stream().reduce((accumulator, element) -> accumulator * element).get();
        System.out.println(result); // >> 960
        // stream: 5, 8, 2, 4, 3
        // accumulator = 5  40  80  320  (960)
        // element     = 8   2   4    3

        // 2
        List<Integer> list100 = new ArrayList<>();
        // 2.1 - exception
        // java.util.NoSuchElementException
//        int result100 = list100.stream().reduce((accumulator, element) -> accumulator * element).get();
//        System.out.println(result100);
        // 2.2 - class Optional
        Optional<Integer> opt = list100.stream().reduce((accumulator, element) -> accumulator * element);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        } else {
            System.out.println("Not present");
        }
        // 2.3 - class Optional
        Optional<Integer> opt2 = list.stream().reduce((accumulator, element) -> accumulator * element);
        if (opt2.isPresent()) {
            System.out.println(opt2.get());
        } else {
            System.out.println("Not present");
        }

        // 3 - identity = 1, without get(),
        int result2 = list.stream().reduce(1, (accumulator, element) -> accumulator * element);
        System.out.println(result2); // >> 960
        // stream: 5, 8, 2, 4, 3
        // accumulator = 1  5  40  80  360  (960)
        // element     = 5  8   2   4    3

        // 4 - identity = 1, without get(), null
        int result21 = list100.stream().reduce(1, (accumulator, element) -> accumulator * element);
        System.out.println(result21); // >> 1
        // stream: null
        // accumulator = 1     1
        // element     = null

        // 5
        List<String> list3 = new ArrayList<>();

        list3.add("Hello!");
        list3.add("How do you do?");
        list3.add("OK!");
        list3.add("Bye!");

        String result3 = list3.stream().reduce((a, e) -> a + " " + e).get();
        System.out.println(result3);
    }
}
