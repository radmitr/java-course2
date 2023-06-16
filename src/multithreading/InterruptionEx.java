package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 13. Прерывание потоков */
/**
    --------------------
     Прерывание потоков
    --------------------
    У нас есть возможность послать сигнал потоку, что мы хотим его прервать.
    У нас также есть возможность в самом потоке проверить, хотят ли его прервать. Что делать, если данная
    проверка показала, что поток хотят прервать, должен решать сам программист.

    Методы: interrupt(), isInterrupted().
*/
public class InterruptionEx {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);

        // I - stop() (old java)
//        thread.stop(); // deprecated (since="1.2")
        // II - interrupt() (new java)
        thread.interrupt();

        thread.join();
        System.out.println("Main ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;

    // 1
//    @Override
//    public void run() {
//        // more than 2000 ms (~7000 ms)
//        for (int i = 1; i <= 1_000_000_000; i++) {
//            sqrtSum += Math.sqrt(i);
//        }
//        System.out.println(sqrtSum);
//    }

    // 2 - isInterrupted()
//    @Override
//    public void run() {
//        for (int i = 1; i <= 1_000_000_000; i++) {
//            // more than 2000 ms (~7000 ms)
//            if (isInterrupted()) {
//                System.out.println("We want to interrupt thread");
//                System.out.println("We made sure the condition of all objects is normal and decided to stop thread");
//                System.out.println(sqrtSum);
//                return;
//            }
//            sqrtSum += Math.sqrt(i);
//        }
//        System.out.println(sqrtSum);
//    }

    // 3 - catch InterruptedException
    @Override
    public void run() {
        for (int i = 1; i <= 1_000_000_000; i++) {
            // more than 2000 ms (~7000 ms)
            if (isInterrupted()) {
                System.out.println("We want to interrupt thread");
                System.out.println("We made sure the condition of all objects is normal and decided to stop thread");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
//                Thread.sleep(1000);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("We want to interrupt thread during sleep. Let's stop thread");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}
