package collection.set_interface;

import java.util.TreeSet;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 21. TreeSet */
    // 1st class
/**
    ---------
     TreeSet
    ---------
    TreeSet хранит элементы в отсортированном по возрастанию порядке.
    В основе TreeSet лежит TreeMap. У элементов данного TreeMap: ключи - это элементы TreeSet,
    значения – это константа-заглушка.

    Методы: first(), last(), tailSet(), headSet(), subSet().
*/
public class TreeSetEx1 {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 0 - add()
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(10);
//        treeSet.add(null); // java.lang.NullPointerException
        System.out.println(treeSet);

        // 1 - remove()
        treeSet.remove(2);
        System.out.println(treeSet);

        // 2 - contains()
        System.out.println(treeSet.contains(2));
    }
}
