package collection.map_interface;

import java.util.Hashtable;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 19. HashTable */
/**
    -----------
     HashTable
    -----------
    HashTable устаревший класс, который работает по тем же принципам, что и HashMap.
    В отличии от HashMap является synchronized. По этой причине его методы далеко не такие быстрые.

    В HashTable ни ключ, ни значение не могут быть null.

    Даже если нужна поддержка многопоточности HashTable лучше не использовать.
    Следует использовать ConcurrentHashMap.
*/
public class HashTableEx {

    public static void main(String[] args) {
        Hashtable<Double, Student> ht = new Hashtable<>();

        Student st1 = new Student("Dmitriy", "Radionov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Sidorov", 2);

        ht.put(7.8, st1);
        ht.put(9.3, st2);
        ht.put(5.8, st3);
        ht.put(6.0, st4);
//        ht.put(null, st4); // java.lang.NullPointerException
//        ht.put(6.5, null); // java.lang.NullPointerException

        System.out.println(ht);
    }
}
