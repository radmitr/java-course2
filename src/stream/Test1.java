package stream;

import java.util.*;
import java.util.stream.Collectors;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 1. Введение в Streams. Метод map */
/**
    --------
     Stream
    --------
    Stream – это последовательность элементов, поддерживающих последовательные
             и параллельные операции над ними.

    ---------------
     Методы Stream
    ---------------
    Методы Stream не меняют саму коллекцию или массив, от которой был создан stream.

    Методы: map() 'i', filter() 'i', forEach() 't', reduce() 't', sorted() 'i'.
*/
public class Test1 {

    // map()
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello!");
        list.add("How do you do?");
        list.add("OK!");
        list.add("Bye!");
        System.out.println(list);

        // 0
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
//        System.out.println(list);

        // 1
        // stream: 6 14 3 4
        List<Integer> list2 = list.stream().map(element -> element.length())
                .collect(Collectors.toList());
        System.out.println(list2);

        // 2
        int[] array = {5, 9, 3, 8, 1};
        System.out.println(Arrays.toString(array));
        // stream: 5, 3, 1, 8, 1
        array = Arrays.stream(array).map(element -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(array));

        // 3
        Set<String> set = new TreeSet<>();

        set.add("Hello!");
        set.add("How do you do?");
        set.add("OK!");
        set.add("Bye!");
        System.out.println(set);

        // stream: 3 4 6 14
        Set<Integer> set2 = set.stream().map(e->e.length()).collect(Collectors.toSet());
        System.out.println(set2); // >> [3, 4, 6, 14]
        List<Integer> list3 = set.stream().map(e->e.length()).collect(Collectors.toList());
        System.out.println(list3); // >> [4, 6, 14, 3]
    }
}
