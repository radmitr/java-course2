package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 8. Понятие «монитор». Synchronized blocks */
    // 2nd class (from multithreading.Ex11)
/**
    ----------------------------------------
     Понятие «монитор» и synchronized блоки
    ----------------------------------------
    Монитор – это сущность/механизм, благодаря которому достигается корректная работа при синхронизации.
    В Java у каждого класса и объекта есть привязанный к нему монитор.

    Пример блока:
        static final Object lock = new Object();
        public void abc() {
            method body
            synchronized(lock) {
                block body
            }
            method body
        }
*/
public class SynchronizedBlockEx2 {

    static int counter = 0;

    // 1 - synchronized method (синхронизация по классу 'SynchronizedBlockEx2')
//    public static synchronized void increment() {
//            counter++;
//    }
    // 2 - synchronized block (синхронизация по классу 'SynchronizedBlockEx2')
    public static void increment() {
        synchronized (SynchronizedBlockEx2.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R2());
        Thread thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class R2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynchronizedBlockEx2.increment();
        }
    }
}
