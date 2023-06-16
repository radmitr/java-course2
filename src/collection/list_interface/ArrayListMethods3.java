package collection.list_interface;

import java.util.ArrayList;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 4. Методы ArrayList. Часть 2 */
    // 1st class
/**
    ------------------
     Методы ArrayList
    ------------------
    add(DataType element)  boolean
    add(int index, DataType element)  boolean
    get(int index)  DataType
    set(int index, DataType element)  DataType
    remove(Object element)  boolean
    remove(int index)  DataType
    addAll(ArrayList aL)  boolean
    addAll(int index, ArrayList aL)  boolean
    clear()  void
    indexOf(Object element)  int
    lastIndexOf(Object element)  int
    size()  int
    isEmpty()  boolean
    contains(Object element)  boolean
    toString()  String
*/
public class ArrayListMethods3 {

    // addAll(), clear(), indexOf(), lastIndexOf(), size(), isEmpty(), contains(), toString()
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Dmitriy");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        // 4
        arrayList1.add("Ivan");
        System.out.println(arrayList1);
        System.out.println("------------------------------------");

        // 1 // 2 // 3
//        ArrayList<String> arrayList2 = new ArrayList<>();
//        arrayList2.add("!!!");
//        arrayList2.add("???");

        // 1 - addAll(Collection<? extends E> c)
////        arrayList1.addAll(arrayList2);
////        System.out.println(arrayList1);
////        System.out.println("------------------------------------");
//        // 2 - addAll(int index, Collection<? extends E> c)
//        arrayList1.addAll(1, arrayList2);
//        System.out.println(arrayList1);
//        System.out.println("------------------------------------");

        // 3 - clear()
//        arrayList1.clear();
//        System.out.println(arrayList1);
//        System.out.println("------------------------------------");

        // 4 - indexOf()
        System.out.println(arrayList1.indexOf("Ivan"));
        System.out.println("------------------------------------");

        // 5 - lastIndexOf()
        System.out.println(arrayList1.lastIndexOf("Ivan"));
        System.out.println("------------------------------------");

        // 6 - size()
        System.out.println(arrayList1.size());
        System.out.println("------------------------------------");

        // 7 - isEmpty()
        System.out.println(arrayList1.isEmpty());
//        arrayList1.clear();
//        System.out.println(arrayList1.isEmpty());
        System.out.println("------------------------------------");

        // 8 - contains()
        System.out.println(arrayList1.contains("Kolya"));
        System.out.println(arrayList1.contains("Mariya"));
        System.out.println("------------------------------------");

        // 9 - toString()
        System.out.println(arrayList1.toString());
        System.out.println("------------------------------------");
    }
}
