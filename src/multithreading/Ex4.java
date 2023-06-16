package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 2. Варианты создания потоков */
    // 3rd class
/**
    ---------------------------------
     Варианты создания нового потока
    ---------------------------------
    // Создание
    class MyThread extends Thread{ public void run() { код } }
    // Запуск
    new MyThread().start();

    // Создание
    class MyRunnableImpl implements Runnable{ public void run() { код } }
    // Запуск
    new Thread( new MyRunnableImpl() ).start();

    Из за того, что в Java отсутствует множественное наследование, чаще используют 2-ой вариант.
*/
public class Ex4 {

    public static void main(String[] args) {
        // 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Privet");
            }
        }).start();

        // 2
        new Thread(() -> System.out.println("Privet")).start();
    }
}
