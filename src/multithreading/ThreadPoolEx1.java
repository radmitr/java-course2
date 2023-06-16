package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 14. ThreadPool и ExecutorService. Часть 1 */
/**
    -------------------------------
     Thread pool и ExecutorService
    -------------------------------
    Thread pool – это множество потоков, каждый из которых предназначен для выполнения той или иной задачи.

    В Java с thread pool-ами удобнее всего работать посредством ExecutorService.

    Thread pool удобнее всего создавать, используя factory методы класса Executors:
        Executors.newFixedThreadPool(int count) – создаст pool с 5-ю потоками;
        Executors.newSingleThreadExecutor() – создаст pool с одним потоком.

    -----

    Метод execute() передаёт наше задание (task) в thread pool, где оно выполняется одним из потоков.

    После выполнения метода shutdown() ExecutorService понимает, что новых заданий больше не будет и, выполнив
    поступившие до этого задания, прекращает работу.

    Метод awaitTermination() принуждает поток в котором он вызвался подождать до тех пор, пока не выполнится одно
    из двух событий: либо ExecutorService прекратит свою работу, либо пройдёт время, указанное в параметре
    метода awaitTermination().

    Методы: execute(), shutdown(), awaitTermination().
*/
public class ThreadPoolEx1 {

    public static void main(String[] args) throws InterruptedException {
        // 1 // 2 - newFixedThreadPool()
        // на прямую лучше не создавать
//        ExecutorService executorService = new ThreadPoolExecutor();
        // возвращает new ThreadPoolExecutor(...)
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl100());
        }

        executorService.shutdown(); // больше задачи не принимаются
        executorService.awaitTermination(5, TimeUnit.SECONDS); // ждём 5 секунд или решения задач
        System.out.println("Main ends");

        // 3 - newSingleThreadExecutor()
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(new RunnableImpl100());
//        }
//        executorService.shutdown(); // больше задачи не принимаются
    }
}

class RunnableImpl100 implements Runnable {
    // 1
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 2
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " begins work");
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName() + " ends work");
//    }

    // 3
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " begins work");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName() + " ends work");
//    }
}
