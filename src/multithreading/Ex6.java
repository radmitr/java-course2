package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 3. Thread name и Thread priority */
    // 2nd class
/**
    ---------------
     Методы Thread
    ---------------
    Методы: setName(), getName(), setPriority(), getPriority(), sleep(), join().
*/
public class Ex6 implements Runnable {

    // currentThread()
    @Override
    public void run() {
        System.out.println("Method run. Thread name = " +
                Thread.currentThread().getName());
    }

    // 1 - start()
//    public static void main(String[] args) {
//        Thread thread = new Thread(new Ex6());
//        thread.start(); // >> Method run. Thread name = Thread-0
//        System.out.println("Method main. Thread name = " +
//                Thread.currentThread().getName()); // >> Method main. Thread name = main
//    }

    // 2 - run() - does not start the thread !!!!!
    public static void main(String[] args) {
        Thread thread = new Thread(new Ex6());
        thread.run(); // >> Method run. Thread name = main
        System.out.println("Method main. Thread name = " +
                Thread.currentThread().getName()); // >> Method main. Thread name = main
    }
}
