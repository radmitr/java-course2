package collection.map_interface;

import java.util.LinkedHashMap;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 18. LinkedHashMap */
/**
    ---------------
     LinkedHashMap
    ---------------
    LinkedHashMap является наследником HashMap. Хранит информацию о порядке добавления элементов или
    порядке их использования. Производительность методов немного ниже, чем у методов HashMap.
*/
public class LinkedHashMapEx {

    public static void main(String[] args) {
        // 1 // 2
//        LinkedHashMap<Double, Student> lhm = new LinkedHashMap<>(16, 0.75f, false);
        // 3
        LinkedHashMap<Double, Student> lhm = new LinkedHashMap<>(16, 0.75f, true);

        Student st1 = new Student("Dmitriy", "Radionov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);

        // 1
//        lhm.put(5.8, st1);
//        lhm.put(6.4, st2);
//        lhm.put(7.2, st3);
//        lhm.put(7.5, st4);

        // 2
        lhm.put(7.2, st3);
        lhm.put(7.5, st4);
        lhm.put(5.8, st1);
        lhm.put(6.4, st2);
        System.out.println(lhm);

        // 1 // 2 // 3 - порядок добавления - false, порядок использоваия - true
        System.out.println(lhm.get(6.4));
        System.out.println(lhm.get(7.5));
        System.out.println(lhm.get(7.2));
        System.out.println(lhm.get(5.8));
        System.out.println(lhm);
    }
}
