package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 12. Daemon потоки */
/**
    ---------------
     Daemon потоки
    ---------------
    Daemon потоки предназначены для выполнения фоновых задач и оказания различных сервисов User потокам.

    При завершении работы последнего User потока программа завершает своё выполнение, не дожидаясь окончания
    работы Daemon потоков.

    Методы: setDaemon(), isDaemon().
*/
public class DaemonThreadEx {

    public static void main(String[] args) {
        System.out.println("Main thread starts");
        UserThread userThread = new UserThread();
        userThread.setName("user_thread");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("daemon_thread");
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
//        daemonThread.setDaemon(true); // java.lang.IllegalThreadStateException
        System.out.println("Main thread ends");
    }
}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                Thread.sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for (int i = 1; i < 1000; i++) {
            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
