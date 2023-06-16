package collection.map_interface;

import java.util.HashMap;
import java.util.Map;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 13. Введение в Map. HashMap */
/**
    ---------
     HashMap
    ---------
    Элементами HashMap являются пары ключ/значение.
    HashMap не запоминает порядок добавления элементов. Его методы работают очень быстро.

    Ключи элементов должны быть уникальными. Ключ может быть null.
    Значения элементов могут повторяться. Значения могут быть null.

    Методы: put(), putIfAbsent(), get(), remove(), containsKey(), containsValue(), keySet(), values(), entrySet().
*/
public class HashMapEx {

    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();

        // 1 - put()
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        System.out.println(map1);

        // 2 - the same value
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        map1.put(98745, "Nikolay Petrov");
//        System.out.println(map1);

        // 3 - key = null, value = null
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        map1.put(1000, "Oleg Ivanov");
//        map1.put(null, "Sergey Petrov");
//        map1.put(85214, null);
//        System.out.println(map1);

        // 4 - putIfAbsent()
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        map1.putIfAbsent(1000, "Oleg Ivanov");
//        System.out.println(map1);

        // 5 - get()
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        map1.putIfAbsent(1000, "Oleg Ivanov");
//        System.out.println(map1);
//        System.out.println(map1.get(1000));
//        System.out.println(map1.get(1001));

        // 6 - remove()
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        map1.putIfAbsent(1000, "Oleg Ivanov");
//        System.out.println(map1);
//        map1.remove(15879);
//        System.out.println(map1);

        // 7 - containsValue()
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        map1.putIfAbsent(1000, "Oleg Ivanov");
////        System.out.println(map1);
//        map1.remove(15879);
////        System.out.println(map1);
//        System.out.println(map1.containsValue("Ivan Ivanov"));
//        System.out.println(map1.containsValue("Oleg Ivanov"));

        // 8 - containsKey()
//        map1.put(1000, "Dmitriy Radionov");
//        map1.put(3568, "Ivan Ivanov");
//        map1.put(6578, "Mariya Sidorova");
//        map1.put(15879, "Nikolay Petrov");
//        map1.putIfAbsent(1000, "Oleg Ivanov");
//        map1.remove(15879);
//        System.out.println(map1.containsKey(500));
//        System.out.println(map1.containsKey(6578));

        // 9 - keySet(), values()
        map1.put(1000, "Dmitriy Radionov");
        map1.put(3568, "Ivan Ivanov");
        map1.put(6578, "Mariya Sidorova");
        map1.put(15879, "Nikolay Petrov");
        map1.putIfAbsent(1000, "Oleg Ivanov");
        map1.remove(15879);
        System.out.println(map1.keySet());
        System.out.println(map1.values());

        Map<String, String> map2 = new HashMap<>();
        map2.put("Sasha", "Kind");
        map2.put("Misha", "Clever");
    }
}
