package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 9. Методы wait и notify */
/**
    ----------------------
     Методы wait и notify
    ----------------------
    Для извещения потоком других потоков о своих действиях часто используются следующие методы:
        wait - освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой
               поток не вызовет метод notify();
        notify – НЕ освобождает монитор и будит поток, у которого ранее был вызван метод wait();
        notifyAll – НЕ освобождает монитор и будит все потоки, у которых ранее был вызван метод wait();
*/
public class WaitNotifyEx {

    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

// 1 - with synchronized method, синхронизация на this
// -------------------------------------------------------------------------------
class Market {
    private int breadCount = 0;

    public synchronized void getBread() {
        // в редких случаях поток может проснуться без notify(), поэтому используем while(){}, а не if(){}
        while (breadCount < 1) {
            try {
                wait(); // this.wait() == wait() // освобождаем монитор
//                wait(1000); // this.wait() == wait() // освобождаем монитор
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Количесвто хлеба в магазине = " + breadCount);
        notify(); // this.notify() == notify() // иногда notify() вызывается вхолостую
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
//        while (breadCount >= 1) { // тогда будет по очереди putBread() и getBread()
            try {
                wait(); // this.wait() == wait() // освобождаем монитор
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Количесвто хлеба в магазине = " + breadCount);
        notify(); // this.notify() == notify() // иногда notify() вызывается вхолостую
    }
}
// -------------------------------------------------------------------------------

// 2 - with synchronized block, синхронизация на lock
// -------------------------------------------------------------------------------
//class Market {
//    private int breadCount = 0;
//    Object lock = new Object();
//
//    public void getBread() {
//        synchronized (lock) {
//            while (breadCount < 1) {
//                try {
//                    lock.wait(); // освобождаем монитор
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            breadCount--;
//            System.out.println("Потребитель купил 1 хлеб");
//            System.out.println("Количесвто хлеба в магазине = " + breadCount);
//            lock.notify(); // иногда notify() вызывается вхолостую
//        }
//    }
//
//    public void putBread() {
//        synchronized (lock) {
//            while (breadCount >= 5) {
//                try {
//                    lock.wait(); // освобождаем монитор
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            breadCount++;
//            System.out.println("Производитель добавил на витрину 1 хлеб");
//            System.out.println("Количесвто хлеба в магазине = " + breadCount);
//            lock.notify(); // иногда notify() вызывается вхолостую
//        }
//    }
//}
// -------------------------------------------------------------------------------

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}
