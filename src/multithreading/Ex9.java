package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 4. Методы sleep и join. Thread states */
    // 3rd class
/**
    ---------------
     Методы Thread
    ---------------
    Методы: setName(), getName(), setPriority(), getPriority(), sleep(), join().
*/
public class Ex9 {

    public static void main(String[] args) throws InterruptedException {
        // 1 - join()
//        System.out.println("Method main begins");
//        Thread thread = new Thread(new Worker());
//        thread.start();
//        thread.join();
//        System.out.println("Method main ends");

        // 2a - join(final long millis)
//        System.out.println("Method main begins");
//        Thread thread = new Thread(new Worker());
//        thread.start();
//        thread.join(1500);
//        System.out.println("Method main ends");

        // 2b - join(final long millis)
//        System.out.println("Method main begins");
//        Thread thread = new Thread(new Worker());
//        thread.start();
//        thread.join(4000);
//        System.out.println("Method main ends");

        // 3 - getState()
        //   A thread can be in one of the following states:
        //   * NEW
        //     A thread that has not yet started is in this state.
        //   * RUNNABLE (Ready -> Running)
        //     A thread executing in the Java virtual machine is in this state.
        //   * BLOCKED
        //     A thread that is blocked waiting for a monitor lock is in this state.
        //   * WAITING
        //     A thread that is waiting indefinitely for another thread to perform a particular action
        //     is in this state.
        //   * TIMED_WAITING
        //     A thread that is waiting for another thread to perform an action for up to a specified
        //     waiting time is in this state.
        //   * TERMINATED
        //     A thread that has exited is in this state.
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState()); // >> NEW
        thread.start();
        System.out.println(thread.getState()); // >> RUNNABLE
        thread.join();
        System.out.println(thread.getState()); // >> TERMINATED
        System.out.println("Method main ends");
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work ends");
    }
}
