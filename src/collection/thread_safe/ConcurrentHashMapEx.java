package collection.thread_safe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 23. ConcurrentHashMap */
/**
    -------------------
     ConcurrentHashMap
    -------------------
    ConcurrentHashMap имплементирует интерфейс ConcurrentMap, который в свою очередь происходит от интерфейса Map.

    В ConcurrentHashMap любое количество потоков может читать элементы не блокируя его.

    В ConcurrentHashMap, благодаря его сегментированию, при изменении какого-либо элемента блокируется только
    bucket, в котором он находится.

    В ConcurrentHashMap ни key, ни value не могут быть null.
*/
public class ConcurrentHashMapEx {

    public static void main(String[] args) throws InterruptedException {
        // 1 - exception
//        HashMap<Integer, String> map = new HashMap<>();
        // 2 - no exception
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "Dmitriy");
        map.put(2, "Oleg");
        map.put(3, "Sergey");
        map.put(4, "Ivan");
        map.put(5, "Igor");
//        map.put(8, null); // java.lang.NullPointerException
//        map.put(null, "Alexandr"); // java.lang.NullPointerException
        System.out.println(map);

        // segment locking or bucket locking

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next(); // java.util.ConcurrentModificationException
                System.out.println(i + ":" + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put(6, "Elena"); // java.util.ConcurrentModificationException
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
