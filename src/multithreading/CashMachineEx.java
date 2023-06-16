package multithreading;

import java.security.PrivateKey;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 11. Lock и ReentrantLock */
    // 2nd class
/**
    ----------------------
     Lock и ReentrantLock
    ----------------------
    Lock – интерфейс, который имплементируется классом ReentrantLock.

    Также как ключевое слово synchronized, Lock нужен для достижения синхронизации между потоками.

    Методы: lock(), unlock(), tryLock().
*/
public class CashMachineEx {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        // 1 - lock()
//        new Employee("Dmitriy", lock);
//        new Employee("Oleg", lock);
//        new Employee("Elena", lock);
//        new Employee("Victor", lock);
//        new Employee("Marina", lock);

        // 2 - tryLock()
        new Employee("Dmitriy", lock);
        new Employee("Oleg", lock);
        new Employee("Elena", lock);
        Thread.sleep(5000);
        new Employee("Victor", lock);
        new Employee("Marina", lock);
    }
}

class Employee extends Thread {
   String name;
   private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    // 1 - lock()
//    @Override
//    public void run() {
//        try {
//            System.out.println(name + " ждёт...");
//            lock.lock();
//            System.out.println(name + " пользуется банкоматом");
//            Thread.sleep(2000);
//            System.out.println(name + " завершил(а) свои дела");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//        }
//    }

    // 2 - tryLock()
    @Override
    public void run() {
        if (lock.tryLock()) {
            try {
//            System.out.println(name + " ждёт...");
//            lock.lock();
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " завершил(а) свои дела");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " не хочет ждать в очереди");
        }
    }
}
