package collection.set_interface;

import java.util.LinkedHashSet;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 22. LinkedHashSet */
/**
    ---------------
     LinkedHashSet
    ---------------
    LinkedHashSet является наследником HashSet. Хранит информацию о порядке добавления элементов.
    Производительность методов немного ниже, чем у методов HashSet.
    В основе LinkedHashSet лежит HashMap. У элементов данного HashMap: ключи - это элементы LinkedHashSet,
    значения – это константа-заглушка.
*/
public class LinkedHashSetEx {

    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        // 1 - add()
        lhs.add(5);
        lhs.add(3);
        lhs.add(1);
        lhs.add(8);
        lhs.add(10);
        System.out.println(lhs);

        // 2 - remove()
        lhs.remove(8);
        System.out.println(lhs);

        // 3 - contains()
        System.out.println(lhs.contains(8));
        System.out.println(lhs.contains(10));
    }
}
