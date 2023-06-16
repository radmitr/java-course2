package collection.list_interface;

import java.util.ArrayList;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 3. Методы ArrayList. Часть 1 */
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
public class ArrayListMethods1 {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        // 1.1 - add(E e)
//        ArrayList<String> arrayList1 = new ArrayList<>();
//        arrayList1.add("Dmitriy");
//        arrayList1.add("Ivan");
//        arrayList1.add("Mariya");
//        System.out.println("------------------------------------");
        // 1.2 - add(int index, E element)
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Dmitriy");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add(1, "Misha");
//        arrayList1.add(6, "Misha"); // java.lang.IndexOutOfBoundsException

        for (String s : arrayList1) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        // 2 - get(int index)
        System.out.println(arrayList1.get(2));
        System.out.println("------------------------------------");
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
        System.out.println("------------------------------------");

        // 3 - set(int index, E element)
        arrayList1.set(1, "Masha");
        System.out.println(arrayList1);
        System.out.println("------------------------------------");

        // 4 - remove(int index)
        arrayList1.remove(0);
//        arrayList1.remove(8); // java.lang.IndexOutOfBoundsException
        System.out.println(arrayList1);
        System.out.println("------------------------------------");
    }
}
