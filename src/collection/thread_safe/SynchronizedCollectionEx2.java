package collection.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 22. Синхронизированные коллекции */
    // 2nd class
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
public class SynchronizedCollectionEx2 {

    public static void main(String[] args) throws InterruptedException {
        // 1 - without synchronized
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            arrayList.add(i);
//        }
//        Runnable runnable1 = () -> {
//            Iterator<Integer> iterator = arrayList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next()); // java.util.ConcurrentModificationException
//            }
//        };
//        Runnable runnable2 = () -> arrayList.remove(10); // java.util.ConcurrentModificationException
//
//        Thread thread1 = new Thread(runnable1);
//        Thread thread2 = new Thread(runnable2);
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println(arrayList);

        /* ------- Synchronized collections ------- */

        // 2 - Collections.synchronizedList()
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        List<Integer> synchList = Collections.synchronizedList(arrayList);

        // 2.1 - there is still an exception
//        Runnable runnable1 = () -> {
//            Iterator<Integer> iterator = synchList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next()); // java.util.ConcurrentModificationException
//            }
//        };
//        Runnable runnable2 = () -> synchList.remove(10); // java.util.ConcurrentModificationException

        // 2.2 - there is no exception (работу итератора надо заключать в synchronized block)
        Runnable runnable1 = () -> {
            synchronized (synchList) {
                Iterator<Integer> iterator = synchList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };
        Runnable runnable2 = () -> synchList.remove(10);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchList);
    }
}
