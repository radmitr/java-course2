package collection.thread_safe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 24. CopyOnWriteArrayList */
/**
    ---------------------
     CopyOnWriteArrayList
    ---------------------
    CopyOnWriteArrayList имплементирует интерфейс List.

    CopyOnWriteArrayList следует использовать тогда, когда вам нужно добиться потокобезопасности,
    у вас небольшое количество операций по изменению элементов и большое количество по их чтению.

    В CopyOnWriteArrayList при каждой операции по изменению элементов создаётся копия этого листа.
*/
public class CopyOnWriteArrayListEx {

    public static void main(String[] args) throws InterruptedException {
        // 1 - exception
//        ArrayList<String> list = new ArrayList<>();
        // 2 - no exception
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("Dmitriy");
        list.add("Oleg");
        list.add("Sergey");
        list.add("Ivan");
        list.add("Igor");
        System.out.println(list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next()); // java.util.ConcurrentModificationException
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.remove(4); // java.util.ConcurrentModificationException
            list.add("Elena");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }
}
