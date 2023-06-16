package multithreading;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 1. Ввведение в многопоточность */
/**
    ----------------
     Multithreading
    ----------------
    Многопоточность – это принцип построения программы, при котором несколько блоков кода
    могут выполняться одновременно.

    Основные цели: 1) Производительность, 2) Concurrency.
*/
public class Ex1 {

    public static void main(String[] args) {
        // For single-core processor - context switch
        // For multicore processor - some or all core or one core with context switch
        // (1) performance, (2) concurrency
        System.out.println("Privet!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("Poka.");
    }
}
