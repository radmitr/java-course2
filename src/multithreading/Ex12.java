package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 8. Понятие «монитор». Synchronized blocks */
    // 3rd class
/**
    ---------------------------------------
     Понятие «монитор» и synchronized блоки
    ---------------------------------------
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
public class Ex12 {

    // 1 - без синхронизации
//    void mobileCall() {
//        System.out.println("Mobile call starts");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Mobile call ends");
//    }
//
//    void viberCall() {
//        System.out.println("Viber call starts");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Viber call ends");
//    }
//
//    void telegramCall() {
//        System.out.println("Telegram call starts");
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Telegram call ends");
//    }

    // 2 - синхронизация не происходит, т.к. три разных объекта
//    synchronized void mobileCall() {
//        System.out.println(this);
//        System.out.println("Mobile call starts");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Mobile call ends");
//    }
//
//    synchronized void viberCall() {
//        System.out.println(this);
//        System.out.println("Viber call starts");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Viber call ends");
//    }
//
//    synchronized void telegramCall() {
//        System.out.println(this);
//        System.out.println("Telegram call starts");
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Telegram call ends");
//    }

    // 3 - синхронизация для нескольих методов по одному объекту (с выдуманным классом)
//    static final Car car = new Car(); // не стоит использовать выдуманный класс !!!
//
//    void mobileCall() {
//        synchronized (car) {
//            System.out.println("Mobile call starts");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Mobile call ends");
//        }
//    }
//
//    void viberCall() {
//        synchronized (car) {
//            System.out.println("Viber call starts");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Viber call ends");
//        }
//    }
//
//    void telegramCall() {
//        synchronized (car) {
//            System.out.println("Telegram call starts");
//            try {
//                Thread.sleep(7000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Telegram call ends");
//        }
//    }
//
//    public static void main(String[] args) {
//
//        Thread thread1 = new Thread(new RunnableImplMobile());
//        Thread thread2 = new Thread(new RunnableImplViber());
//        Thread thread3 = new Thread(new RunnableImplTelegram());
//        thread1.start();
//        thread2.start();
//        thread3.start();
//    }
//}

    // 4 - синхронизация для нескольих методов по одному объекту (с объектом lock класса Object)
    static final Object lock = new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call ends");
        }
    }

    void viberCall() {
        synchronized (lock) {
            System.out.println("Viber call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Viber call ends");
        }
    }

    void telegramCall() {
        synchronized (lock) {
            System.out.println("Telegram call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Telegram call ends");
        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplViber());
        Thread thread3 = new Thread(new RunnableImplTelegram());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImplMobile implements Runnable {
    @Override
    public void run() {
        new Ex12().mobileCall();
    }
}

class RunnableImplViber implements Runnable {
    @Override
    public void run() {
        new Ex12().viberCall();
    }
}

class RunnableImplTelegram implements Runnable {
    @Override
    public void run() {
        new Ex12().telegramCall();
    }
}

// Не стоит выдумывать класс !!!
//class Car {
//}
