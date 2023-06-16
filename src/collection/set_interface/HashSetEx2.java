package collection.set_interface;

import java.util.HashSet;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 20. Введение в Set. HashSet */
    // 2nd class
/**
    -----------------
     Set and HashSet
    -----------------
    Set – коллекция, хранящая уникальные элементы. Методы данной коллекции очень быстры.

    HashSet не запоминает порядок добавления элементов. В основе HashSet лежит HashMap. У элементов
    данного HashMap: ключи - это элементы HashSet, значения – это константа-заглушка.

    Методы: add(), size(), isEmpty(), remove(), contains(), addAll(), retainAll(), removeAll().
*/
public class HashSetEx2 {

    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(1);
        hashSet1.add(8);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(4);
        hashSet2.add(5);
        hashSet2.add(3);
        hashSet2.add(8);

        // 1 - union by addAll()
        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);
        System.out.println(union);

        // 2 - intersection by retainAll(()
        HashSet<Integer> intersection = new HashSet<>(hashSet1);
        intersection.retainAll(hashSet2);
        System.out.println(intersection);

        // 3 - subtraction by removeAll()
        HashSet<Integer> subtraction = new HashSet<>(hashSet1);
        subtraction.removeAll(hashSet2);
        System.out.println(subtraction);

        // 4 - symmetric subtraction by subtraction of union and intersection
        HashSet<Integer> symmetricSubtraction = new HashSet<>(union);
        symmetricSubtraction.removeAll(intersection);
        System.out.println(symmetricSubtraction);
    }
}
