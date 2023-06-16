package collection.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 25. ArrayBlockingQueue */
    // 2nd class
/**
    --------------------
     ArrayBlockingQueue
    --------------------
    ArrayBlockingQueue – потокобезопасная очередь с ограниченным размером (capacity restricted).

    Обычно один или несколько потоков добавляют элементы в конец очереди, а другой или другие потоки
    забирают элементы из начала очереди.

    Методы: put(), take().
*/
public class ArrayBlockingQueueEx2 {

    // put(), take()
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);

        // Producer
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Producer put " + i + " " + arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // Consumer
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer take " + j + " " + arrayBlockingQueue);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
