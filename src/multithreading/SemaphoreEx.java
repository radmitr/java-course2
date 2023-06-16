package multithreading;

import java.util.concurrent.Semaphore;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 18. Синхронизатор Semaphore */
/**
    -----------
     Semaphore
    -----------
    Semaphore - это синхронизатор, позволяющий ограничить доступ к какому-то ресурсу.
    В конструктор Semaphore нужно передавать количество потоков, которым Semaphore
    будет разрешать одновременно использовать этот ресурс.

    Методы: acquire(), release().
*/
public class SemaphoreEx {

    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("Dmitriy", callBox);
        new Person("Oleg", callBox);
        new Person("Elena", callBox);
        new Person("Victor", callBox);
        new Person("Marina", callBox);
    }
}

class Person extends Thread {
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ждёт...");
            callBox.acquire();
            System.out.println(name + " пользуется телефоном");
            Thread.sleep(2000);
            System.out.println(name + " завершил(а) звонок");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            callBox.release();
        }
    }
}