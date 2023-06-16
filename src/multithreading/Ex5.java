package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 3. Thread name и Thread priority */
    // 1st class
/**
    ---------------
     Методы Thread
    ---------------
    Методы: setName(), getName(), setPriority(), getPriority(), sleep(), join().
*/
public class Ex5 {

    public static void main(String[] args) {
        // Priority: 1..10 (10 - the highest priority)

        // 1 - getName(), getPriority()
//        MyThread5 myThread5 = new MyThread5();
//        // >> Name of myThread5 = Thread-0, Priority of myThread5 = 5
//        System.out.println("Name of myThread5 = " + myThread5.getName() +
//                ", Priority of myThread5 = " + myThread5.getPriority());
//        MyThread5 myThread6 = new MyThread5();
//        // >> Name of myThread5 = Thread-0, Priority of myThread5 = 5
//        System.out.println("Name of myThread6 = " + myThread6.getName() +
//                ", Priority of myThread6 = " + myThread6.getPriority());

        // 2 - setName(), setPriority()
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("moy_potok");
        myThread5.setPriority(9);
//        myThread5.setPriority(Thread.MIN_PRIORITY); // = 1
//        myThread5.setPriority(Thread.NORM_PRIORITY); // = 5
//        myThread5.setPriority(Thread.MAX_PRIORITY); // = 10
        // >> Name of myThread5 = moy_potok, Priority of myThread5 = 9
        System.out.println("Name of myThread5 = " + myThread5.getName() +
                ", Priority of myThread5 = " + myThread5.getPriority());
    }
}

class MyThread5 extends Thread {
    public void run() {
        System.out.println("Privet!");
    }
}
