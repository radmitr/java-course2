package collection.list_interface;

import java.util.ArrayList;
import java.util.List;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 5. Методы ArrayList и связанные с ним методы. Часть 3 */
    // 2nd class
/*
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
public class ArrayListMethods5 {

    // removeAll(), retainAll(), containsAll(), subList(), toArray(), toArray(T[] a), List.of(), List.copyOf()
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Dmitriy");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        System.out.println(arrayList1);
        System.out.println("------------------------------------");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Ivan");
        arrayList2.add("Mariya");
        arrayList2.add("Igor");

        // 1 - removeAll()
//        arrayList1.removeAll(arrayList2);
//        System.out.println(arrayList1);
//        System.out.println("------------------------------------");

        // 2 - retainAll()
//        arrayList1.retainAll(arrayList2);
//        System.out.println(arrayList1);
//        System.out.println("------------------------------------");

        // 3 - containsAll()
//        boolean result = arrayList1.containsAll(arrayList2);
//        System.out.println(result);
//
//        arrayList2.remove("Igor");
//        result = arrayList1.containsAll(arrayList2);
//        System.out.println(result);
//        System.out.println("------------------------------------");

        // 4 - subList()
        arrayList1.add("Elena");
        System.out.println("ArrayList = " + arrayList1);
        List<String> myList = arrayList1.subList(1, 4); // myList является представлением arrayList1 (view)
        System.out.println("Sub list = " + myList);
        myList.add("Fedor");
        System.out.println("Sub list = " + myList);
        System.out.println("ArrayList = " + arrayList1);
        arrayList1.add("Sveta");
        System.out.println("ArrayList = " + arrayList1);
//        System.out.println("Sub list = " + myList); // java.util.ConcurrentModificationException
        System.out.println("------------------------------------");

        // 5 - toArray() -> Object[]
        Object[] array = arrayList1.toArray();

        // 6 - toArray(T[] a) -> T[]
//        String[] array2 = arrayList1.toArray(new String[7]);
//        String[] array2 = arrayList1.toArray(new String[9]);
//        String[] array2 = arrayList1.toArray(new String[2]); // java создаст массив необходимого размера
        String[] array2 = arrayList1.toArray(new String[0]); // java создаст массив необходимого размера
        for (String s : array2) {
            System.out.println(s);
        }
        System.out.println("------------------------------------");

        // 7 - List.of() [java 9]
        List<Integer> list1 = List.of(3, 8, 13); // на выходе list1 неизменяем
//        List<Integer> list1 = List.of(3, 8, null); // java.lang.NullPointerException
        System.out.println(list1);
//        list1.add(100); // java.lang.UnsupportedOperationException
        System.out.println("------------------------------------");

        // 8 - List.copyOf() [java 9]
        List<String> list2 = List.copyOf(arrayList1); // на выходе list2 неизменяем
        System.out.println(list2);
//        list2.add("Grisha"); // java.lang.UnsupportedOperationException
        System.out.println("------------------------------------");
    }
}
