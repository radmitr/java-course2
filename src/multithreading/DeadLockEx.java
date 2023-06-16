package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 10. Понятия Deadlock, Livelock, Lock Starvation */
/**
    -----------------------------------------------------
     Возможные ситуации в многопоточном программировании
    -----------------------------------------------------
    Deadlock – ситуация, когда 2 или более потоков залочены навсегда, ожидают друг друга и ничего не делают.

    Livelock – ситуация, когда 2 или более потоков залочены навсегда, ожидают друг друга, проделывают какую-то
               работу, но без какого-либо прогресса.

    Lock starvation – ситуация, когда менее приоритетные потоки ждут долгое время или всё время для того,
                      чтобы могли запуститься.
*/
public class DeadLockEx {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

// 1 - Deadlock - разный порядок locks
// ---------------------------------------------------------------------------------------------
//class Thread10 extends Thread {
//    @Override
//    public void run() {
//        System.out.println("Thread10: Попытка захватить монитор объекта lock1");
//        synchronized (DeadLockEx.lock1) {
//            System.out.println("Thread10: Монитор объекта lock1 захвачен");
//            System.out.println("Thread10: Попытка захватить монитор объекта lock2");
//            synchronized (DeadLockEx.lock2) {
//                System.out.println("Thread10: Мониторы объектов lock1 и lock2 захвачены");
//            }
//            System.out.println("Thread10: Монитор объектов lock2 отпущен, отпускаем lock1" + "\n" +
//                    "------------------------------------------------------------");
//        }
//    }
//}
//
//class Thread20 extends Thread {
//    @Override
//    public void run() {
//        System.out.println("Thread20: Попытка захватить монитор объекта lock2");
//        synchronized (DeadLockEx.lock2) {
//            System.out.println("Thread20: Монитор объекта lock2 захвачен");
//            System.out.println("Thread20: Попытка захватить монитор объекта lock1");
//            synchronized (DeadLockEx.lock1) {
//                System.out.println("Thread20: Мониторы объектов lock1 и lock2 захвачены");
//            }
//            System.out.println("Thread20: Монитор объектов lock1 отпущен, отпускаем lock2" + "\n" +
//                    "------------------------------------------------------------");
//        }
//    }
//}
// ---------------------------------------------------------------------------------------------

// 2 - No Deadlock - одинаковый порядок locks
// ---------------------------------------------------------------------------------------------
class Thread10 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread10: Попытка захватить монитор объекта lock1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread10: Монитор объекта lock1 захвачен");
            System.out.println("Thread10: Попытка захватить монитор объекта lock2");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread10: Мониторы объектов lock1 и lock2 захвачены");
            }
            System.out.println("Thread10: Монитор объектов lock2 отпущен, отпускаем lock1" + "\n" +
                    "------------------------------------------------------------");
        }
    }
}

class Thread20 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread20: Попытка захватить монитор объекта lock1");
        synchronized (DeadLockEx.lock1) {
            System.out.println("Thread20: Монитор объекта lock1 захвачен");
            System.out.println("Thread20: Попытка захватить монитор объекта lock2");
            synchronized (DeadLockEx.lock2) {
                System.out.println("Thread20: Мониторы объектов lock1 и lock2 захвачены");
            }
            System.out.println("Thread20: Монитор объектов lock2 отпущен, отпускаем lock1" + "\n" +
                    "------------------------------------------------------------");
        }
    }
}
// ---------------------------------------------------------------------------------------------