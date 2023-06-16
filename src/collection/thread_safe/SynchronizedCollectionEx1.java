package collection.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 22. Синхронизированные коллекции */
    // 1st class
/**
    -----------------------------------------
     Коллекции для работы с многопоточностью
    -----------------------------------------
    ----- Synchronized collections: -----
    Получаются из традиционных коллекций благодаря их обёртыванию

    Collections.synchronizedXYZ(коллекция)

    Методы: Collections.synchronizedList(), Collections.synchronizedSet(),
            Collections.synchronizedMap(), Collections.synchronizedQueue()

    ----- Concurrent collections: -----
    Изначально созданы для работы с многопоточностью
*/
public class SynchronizedCollectionEx1 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            source.add(i);
        }

        // 1 - without synchronized
//        ArrayList<Integer> target = new ArrayList<>();
//        Runnable runnable = () -> target.addAll(source);
//
//        Thread thread1 = new Thread(runnable);
//        Thread thread2 = new Thread(runnable);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println(target); // >> [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]  // >> [0, 1, 2, 3, 4]

        /* ------- Synchronized collections ------- */

        // 2 - Collections.synchronizedList()
        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> synchList.addAll(source);

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchList); // >> [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]
    }
}
