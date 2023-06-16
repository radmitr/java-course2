package collection.set_interface;

import java.util.HashSet;
import java.util.Set;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 20. Введение в Set. HashSet */
    // 1st class
/**
    -----------------
     Set and HashSet
    -----------------
    Set – коллекция, хранящая уникальные элементы. Методы данной коллекции очень быстры.

    HashSet не запоминает порядок добавления элементов. В основе HashSet лежит HashMap. У элементов
    данного HashMap: ключи - это элементы HashSet, значения – это константа-заглушка.

    Методы: add(), size(), isEmpty(), remove(), contains(), addAll(), retainAll(), removeAll().
*/
public class HashSetEx1 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // 1 - add()
        set.add("Dmitriy");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");
        set.add("Igor");
        set.add(null);

        System.out.println(set);
        for (String s : set) {
            System.out.println(s);
        }

        // 2 - remove()
        set.remove("Dmitriy");
        System.out.println(set);
        set.remove(null);
        System.out.println(set);

        // 3 - size()
        System.out.println(set.size());

        // 4 - isEmpty()
        System.out.println(set.isEmpty());

        // 5 - contains()
        System.out.println(set.contains("Misha"));
        System.out.println(set.contains("Marina"));
    }
}
