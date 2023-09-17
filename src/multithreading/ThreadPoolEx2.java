package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 15. ThreadPool и ExecutorService. Часть 2 */
/**
    --------------------------
     ScheduledExecutorService
    --------------------------
    ScheduledExecutorService мы используем тогда, когда хотим установить расписание на запуск потоков из пула.

    Данный pool создаётся, используя factory метод класса Executors:
        Executors.newScheduledThreadPool(int count)

    Методы: schedule(), scheduleAtFixedRate(), scheduleWithFixedDelay().
    ------------------------
    Executors.newCachedThreadPool() – создаёт pool, в котором создаются потоки по надобности.
    Если какой-нибудь поток не используется 60 секунд после последнего использования, то он удаляется.

    Методы: execute(), shutdown(), awaitTermination().
*/
public class ThreadPoolEx2 {

    public static void main(String[] args) throws InterruptedException {
        // ----- newScheduledThreadPool() -----
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        // 1 - execute() - нет смысла использовать для ScheduledExecutorService
//        for (int i = 0; i < 10; i++) {
//            scheduledExecutorService.execute(new RunnableImpl200());
//        }
//        scheduledExecutorService.shutdown();

        // 2 - schedule()
//        scheduledExecutorService.schedule(new RunnableImpl200(), 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();

        // 3 - scheduleAtFixedRate()
//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl200(), 3, 1, TimeUnit.SECONDS);
//        Thread.sleep(20000);
//        scheduledExecutorService.shutdown();

        // 4 - scheduleWithFixedDelay()
//        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl200(), 3, 1, TimeUnit.SECONDS);
//        Thread.sleep(20000);
//        scheduledExecutorService.shutdown();

        // ----- newCachedThreadPool() -----
        int count = 10;
        int timeInMillis = 300;
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 5 - execute()
        System.out.println("----- The first influx of tasks -----");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                executorService.execute(new RunnableImpl200());
                Thread.sleep(timeInMillis);
            }
        }
        Thread.sleep(60000); // через 60 секунд удаляются неиспользуемые потоки
        System.out.println("");
        System.out.println("----- The second influx of tasks -----");
        for (int i = count - 1; i >= 0; i--) {
            for (int j = 0; j < count - i; j++) {
                executorService.execute(new RunnableImpl200());
                Thread.sleep(timeInMillis);
            }
        }
        executorService.shutdown();
    }
}

class RunnableImpl200 implements Runnable {
    // 1 // 2
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " begins work");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName() + " ends work");
//    }

    // 3.1
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + " begins work");
//        System.out.println(Thread.currentThread().getName() + " ends work");
//    }

    // 3.2 // 4 // 5
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
