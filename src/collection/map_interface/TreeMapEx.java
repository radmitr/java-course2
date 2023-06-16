package collection.map_interface;

import java.util.Comparator;
import java.util.TreeMap;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 17. TreeMap */
/**
    ---------
     TreeMap
    ---------
    Элементами TreeMap являются пары ключ/значение.
    В TreeMap элементы хранятся в отсортированном по возрастанию порядке.

    В основе TreeMap лежит красно-чёрное дерево. Это позволяет методам работать быстро, но не быстрее,
    чем методы HashMap.

    Методы: put(), get(), remove(), tailMap(), descendingMap(), headMap(), lastEntry(), firstEntry().
*/
public class TreeMapEx {

    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();

        Student st1 = new Student("Dmitriy", "Radionov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);
        Student st5 = new Student("Vasiliy", "Smirnov", 1);
        Student st6 = new Student("Sasha", "Kapustin", 3);
        Student st7 = new Student("Elena", "Sidorova", 4);
        // 0.1
//        Student st8 = new Student("Elena", "Sidorova", 4);
        // 0.2
//        Student st8 = new Student("Petr", "Sidorov", 4);

        // 0 - put()
        treeMap.put(5.8, st1);
        treeMap.put(9.1, st7);
        treeMap.put(6.4, st2);
        treeMap.put(7.5, st4);
        treeMap.put(7.2, st3);
        treeMap.put(8.2, st6);
        treeMap.put(7.9, st5);
        System.out.println(treeMap);

        // 0.1
//        treeMap.put(3.2, st8);
        // 0.2
//        treeMap.put(9.1, st8);
//        System.out.println(treeMap);

        // 1 - get()
        System.out.println(treeMap.get(6.4));
        // 2 - remove()
//        treeMap.remove(5.8);
//        System.out.println(treeMap);
        // 3 - descendingMap()
        System.out.println(treeMap.descendingMap());
        // 4 - tailMap()
        System.out.println(treeMap.tailMap(7.3));
        // 5 - headMap()
        System.out.println(treeMap.headMap(7.3));
        // 6 - lastEntry()
        System.out.println(treeMap.lastEntry());
        // 7 - firstEntry()
        System.out.println(treeMap.firstEntry());

        /////////////////////////////////////////////////////////////////
        // 8 - with implements Comparable
        TreeMap<Student, Double> treeMap2 = new TreeMap<>();
        treeMap2.put(st1, 5.8); // java.lang.ClassCastException // after Student implements Comparable no exception
        treeMap2.put(st7, 9.1);
        treeMap2.put(st2, 6.4);
        treeMap2.put(st4, 7.5);
        treeMap2.put(st3, 7.2);
        treeMap2.put(st6, 8.2);
        treeMap2.put(st5, 7.9);
        System.out.println(treeMap2);

        // 9 - Comparator
        TreeMap<Student, Double> treeMap3 = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        // 10 - lambda
        TreeMap<Student, Double> treeMap4 = new TreeMap<>((o1, o2) -> o1.name.compareTo(o2.name));

        // 11 - Comparator.comparing()
        TreeMap<Student, Double> treeMap5 = new TreeMap<>(Comparator.comparing(o -> o.name));
        /////////////////////////////////////////////////////////////////

        // 12 - comment equals and hashcode in class Student
        Student st8 = new Student("Elena", "Sidorova", 4);
        System.out.println(treeMap2.containsKey(st8)); // в TreeMap используется compareTo()
                                                       // в отличии от HashMap, где используется hashCode() и equals().
        System.out.println(treeMap2.containsValue(9.1)); // используется equals(), а hashCode() не используется

        // 13 - red-black tree (не сбалансировано)
        TreeMap<Double, Student> treeMap6 = new TreeMap<>();
        treeMap6.put(5.8, st1);
        treeMap6.put(6.4, st2);
        treeMap6.put(7.2, st3);
        treeMap6.put(7.5, st4);
        treeMap6.put(7.9, st5);
        treeMap6.put(8.2, st6);
        treeMap6.put(9.1, st7);
        System.out.println(treeMap6);
    }
}
