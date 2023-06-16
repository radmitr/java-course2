package collection.list_interface;

import java.util.ArrayList;
import java.util.Iterator;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 6. Интерфейс Iterator */
/**
    ----------
     Iterator
    ----------
    some code
       ………
    Iterator<DataType> iter = aL.iterator();
    while (iter.hasNext())
    {
        System.out.println(iter.next());
    }
*/
public class IteratorEx {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Dmitriy");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

        Iterator<String> iterator = arrayList1.iterator();

        // 1
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("------------------------------------");

        // 2 - с помощью iterator можно изменять в цикле
//        iterator.remove(); // java.lang.IllegalStateException
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
//        iterator.remove(); // java.lang.IllegalStateException
        System.out.println(arrayList1);
        System.out.println("------------------------------------");
    }
}
