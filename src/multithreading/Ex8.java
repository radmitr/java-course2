package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 4. Методы sleep и join. Thread states */
    // 2nd class
/* 5. Понятия concurrency и parallelism. Понятия synchronous и asynchronous */
/**
    ---------------
     Методы Thread
    ---------------
    Методы: setName(), getName(), setPriority(), getPriority(), sleep(), join().

    ----------------------------
     Concurrency / Parallelism
     Asynchronous / Synchronous
    ----------------------------
    Concurrency означает выполнение сразу нескольких задач. В зависимости от процессора компьютера concurrency
    может достигаться разными способами.

    Parallelism означает выполнение 2-х и более задач в одно и то же время, т.е. параллельно. В компьютерах с
    многоядерным процессором concurrency может достигаться за счёт parallelism.

    В синхронном программировании задачи выполняются последовательно друг за другом.

    В асинхронном программировании каждая следующая задача НЕ ждёт окончания выполнения предыдущей.
    Асинхронное программирование помогает достичь concurrency.
*/
public class Ex8 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                // 1 // 2
//                Thread.sleep(1000);
                // 3
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 1
//        Thread thread1 = new Thread(new MyRunnable1());
//        Ex8 thread2 = new Ex8();
//        thread1.start();
//        thread2.start();
//
//        System.out.println("Конец!");

        // 2 - join()
        Thread thread1 = new Thread(new MyRunnable1());
        Ex8 thread2 = new Ex8();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Конец!");
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                // 1 // 2
//                Thread.sleep(1000);
                // 3
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
