package collection.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 25. ArrayBlockingQueue */
    // 1st class
/**
    --------------------
     ArrayBlockingQueue
    --------------------
    ArrayBlockingQueue – потокобезопасная очередь с ограниченным размером (capacity restricted).

    Обычно один или несколько потоков добавляют элементы в конец очереди, а другой или другие потоки
    забирают элементы из начала очереди.

    Методы: put(), take().
*/
public class ArrayBlockingQueueEx1 {

    // add(), offer()
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
//        queue.add(5); // java.lang.IllegalStateException
        queue.offer(5);
        System.out.println(queue);
    }
}
