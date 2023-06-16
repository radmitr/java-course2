package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 8. Понятие «монитор». Synchronized blocks */
    // 1st class (from multithreading.Ex10)
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
public class SynchronisedBlockEx1 {

    public static void main(String[] args) {
        // Синхронизация по объекту 'runnable'
        MyRunnableImpl2 runnable = new MyRunnableImpl2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter2 {
    static int count = 0;
}

class MyRunnableImpl2 implements Runnable {
    private void doWork2() {
//        System.out.println("Ura!!!");
        System.out.println("Ura!!!" + " " + Thread.currentThread().getName());
    }

    private void doWork1() {
        doWork2();
        // Синхронизация по объекту this
        synchronized(this) {
            Counter2.count++;
//            System.out.println(Counter2.count);
            System.out.println(Counter2.count + " " + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}
