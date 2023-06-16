package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 2. Варианты создания потоков */
    // 2nd class
/**
    ---------------------------------
     Варианты создания нового потока
    ---------------------------------
    // Создание
    class MyThread extends Thread{ public void run() { код } }
    // Запуск
    new MyThread().start();

    // Создание
    class MyRunnableImpl implements Runnable{ public void run() { код } }
    // Запуск
    new Thread( new MyRunnableImpl() ).start();

    Из за того, что в Java отсутствует множественное наследование, чаще используют 2-ой вариант.
*/

// 1 ------------------------------------------------
//public class Ex3 {
//
//    public static void main(String[] args) {
//        Thread thread1 = new Thread(new MyThread3());
//        Thread thread2 = new Thread(new MyThread4());
//
//        thread1.start();
//        thread2.start();
//    }
//}

// 2 ------------------------------------------------
public class Ex3 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Ex3());
        thread1.start();

        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}

// 1 ------------------------------------------------
//class MyThread3 implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 1; i <= 1000; i++) {
//            System.out.println(i);
//        }
//    }
//}
//
//class MyThread4 implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 1000; i > 0; i--) {
//            System.out.println(i);
//        }
//    }
//}
