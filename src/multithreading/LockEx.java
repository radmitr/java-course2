package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 11. Lock и ReentrantLock */
    // 1st class
/**
    ----------------------
     Lock и ReentrantLock
    ----------------------
    Lock – интерфейс, который имплементируется классом ReentrantLock.

    Также как ключевое слово synchronized, Lock нужен для достижения синхронизации между потоками.

    Методы: lock(), unlock(), tryLock().
*/
public class LockEx {

    // In class multithreading/Ex12 - synchronize block
    // In class multithreading/LockEx - class Lock
    public static void main(String[] args) {
        Call call = new Call();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.viberCall();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.telegramCall();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Call {
    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(); // Обязательно !!!
        }
    }

    void viberCall() {
        lock.lock();
        try {
            System.out.println("Viber call starts");
            Thread.sleep(5000);
            System.out.println("Viber call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(); // Обязательно !!!
        }
    }

    void telegramCall() {
        lock.lock();
        try {
            System.out.println("Telegram call starts");
            Thread.sleep(7000);
            System.out.println("Telegram call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(); // Обязательно !!!
        }
    }
}
