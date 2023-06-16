package multithreading;


import java.util.concurrent.atomic.AtomicInteger;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 21. Класс AtomicInteger */
/**
    ---------------
     AtomicInteger
    ---------------
    AtomicInteger – это класс, который предоставляет возможность работать с целочисленным
    значением int, используя атомарные операции.

    Методы: incrementAndGet(), getAndIncrement(), addAndGet(), getAndAdd(), decrementAndGet(), getAndDecrement().
*/
public class AtomicIntegerEx {


    // 1 - without synchronized
//    static int counter = 0;
//
//    public static void increment() {
//        counter++;
//    }

    // 2 - synchronized (синхронизация по классу для статического метода)
//    static int counter = 0;
//
//    public synchronized static void increment() {
//        counter++;
//    }

    /* ---------- AtomicInteger ---------- */

    // 3 - incrementAndGet()
    static AtomicInteger counter = new AtomicInteger(0);

    public static void increment() {
//        counter.incrementAndGet();
//        counter.addAndGet(5);
        counter.addAndGet(-5);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl118());
        Thread thread2 = new Thread(new MyRunnableImpl118());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter); // 1 >> 1767 >> 2000 >> 1938
                                     // 2 >> 2000 >> 2000 >> 2000
                                     // 3 >> 2000 >> 2000 // >> 10000 >> 10000 // >> -10000 >> -10000
    }
}

class MyRunnableImpl118 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            AtomicIntegerEx.increment();
        }
    }
}
