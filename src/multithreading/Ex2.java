package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 2. Варианты создания потоков */
    // 1st class
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
//public class Ex2 {
//
//    public static void main(String[] args) {
//        // 1a // 1b
////        MyThread1 myThread1 = new MyThread1(); // MyThread1
////        MyThread2 myThread2 = new MyThread2(); // MyThread2
//        // 1c
//        MyThread1 myThread1 = new MyThread1(); // MyThread1
//        MyThread1 myThread2 = new MyThread1(); // MyThread1
//
//        myThread1.start();
//        myThread2.start();
//    }
//}

// 2 ------------------------------------------------
public class Ex2 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Ex2 thread1 = new Ex2();
        thread1.start();

        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}

// 1a ------------------------------------------------
//class MyThread1 extends Thread {
//    @Override
//    public void run() {
//        for (int i = 1; i <= 1000; i++) {
//            System.out.println(i);
//        }
//    }
//}
//
//class MyThread2 extends Thread {
//    @Override
//    public void run() {
//        for (int i = 1000; i > 0; i--) {
//            System.out.println(i);
//        }
//    }
//}

// 1b -----------------------------------------------
//class MyThread1 extends Thread {
////    @Override
////    public void run() {
////        for (int i = 1; i <= 1000; i++) {
////            System.out.println(i);
////        }
////    }
//}
//
//class MyThread2 extends Thread {
////    @Override
////    public void run() {
////        for (int i = 1000; i > 0; i--) {
////            System.out.println(i);
////        }
////    }
//}

// 1c -----------------------------------------------
//class MyThread1 extends Thread {
//    @Override
//    public void run() {
//        for (int i = 1; i <= 1000; i++) {
//            System.out.println(i);
//        }
//    }
//}
//
////class MyThread2 extends Thread {
////    @Override
////    public void run() {
////        for (int i = 1000; i > 0; i--) {
////            System.out.println(i);
////        }
////    }
////}
