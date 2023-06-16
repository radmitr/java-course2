package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 4. Методы sleep и join. Thread states */
    // 1st class
/**
    ---------------
     Методы Thread
    ---------------
    Методы: setName(), getName(), setPriority(), getPriority(), sleep(), join().
*/
public class Ex7 {

    // sleep()
    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Поехали!!!");
    }
}
