package collection.list_interface;

import java.util.ArrayList;
import java.util.List;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 2. ArrayList */
/**
    -----------
     ArrayList
    -----------
    В основе ArrayList лежит массив Object

    ArrayList<DataType> list1 = new ArrayList<DataType>();
    ArrayList<DataType> list2 = new ArrayList<>();
    ArrayList<DataType> list3 = new ArrayList<>(30);
    ArrayList<DataType> list4 = new ArrayList<>(list3);
*/
public class ArrayListEx {

    public static void main(String[] args) {
        // 1
        ArrayList<String> arrayList1 = new ArrayList<>(); // размер по умолчанию = 10, дальнее увеличение = 10 * 1,5 + 1
        arrayList1.add("Dmitriy");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
//        arrayList1.add(50); // ошибка
        System.out.println(arrayList1);

        // 2
        ArrayList<String> arrayList2 = new ArrayList<>(200);
        arrayList2.add("Dmitriy");
        arrayList2.add("Ivan");

        // 3
        List<String> arrayList3 = new ArrayList<>(200);

        // 4
        ArrayList<String> arrayList4 = new ArrayList<>(arrayList1);
        System.out.println(arrayList4);
        System.out.println(arrayList1 == arrayList4);

        // 5 - так не стоит делать
        ArrayList arrayList5 = new ArrayList(); // массив Object
        arrayList5.add("Dmitriy");
        arrayList5.add("Ivan");
        arrayList5.add("Mariya");
        arrayList5.add(50);
        arrayList5.add(new Car());
        System.out.println(arrayList5);

        // Если выясняется, что места не хватает, внутри ArrayList’a создается новый массив
        // размером (размерСтарогоМассива * 1.5) + 1
    }
}

class Car {
}
