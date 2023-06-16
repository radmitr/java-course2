package collection.list_interface;

import java.util.Arrays;
import java.util.List;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 5. Методы ArrayList и связанные с ним методы. Часть 3 */
    // 1st class
/**
    ------------------------------------------
     Методы ArrayList и связанные с ArrayList
    ------------------------------------------
    Arrays.asList(DataType[])  List<DataType>
    removeAll(Collection<?> c)  boolean
    retainAll(Collection<?> c) boolean
    containsAll(Collection<?> c)  boolean
    subList(int fromIndex, int toIndex)  List<E>
    toArray()  Object[]
    toArray(T[] a)  T[]
    List.of(E … elements)  List<E>
    List.copyOf(Collection<E> c)  List<E>
*/
public class ArrayListMethods4 {

    // asList()
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder[] array = {sb1, sb2, sb3, sb4};
        List<StringBuilder> list = Arrays.asList(array); // list очень тесно связан с массивом array
        System.out.println(list);

//        array[0].append("!!!");
        array[0] = new StringBuilder("F");
        System.out.println(list);
    }
}
