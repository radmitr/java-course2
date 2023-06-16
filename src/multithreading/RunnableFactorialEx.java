package multithreading;

import java.util.concurrent.*;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 16. Интерфейсы Callable и Future. Часть 1 */
    // 1st class
/* 17. Интерфейсы Callable и Future. Часть 2 */
    // 2nd class
/**
    ------------------------------
     Интерфейсы Callable и Future
    ------------------------------
    Callable, также как и Runnable, представляет собой определённое задание, которое выполняется потоком.
    В отличии от Runnable Callable:
    • имеет return type не void;
    • может выбрасывать Exception.

    Метод submit() передаёт наше задание (task) в thread pool, для выполнения его одним из потоков, и возвращает
    тип Future, в котором и хранится результат выполнения нашего задания.

    Метод get() позволяет получить результат выполнения нашего задания из объекта Future.

    Методы: submit(), get(), isDone().
*/
public class RunnableFactorialEx {

    static int factorialResult;

    // Runnable мы можем использовать как при отдельном создании Thread, так и с ExecutorService !!!
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1 - для "Урок 16. Интерфейсы Callable и Future. Часть 1" - execute()
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Factorial factorial = new Factorial(5);
//        executorService.execute(factorial); // Для Runnable используем метод execute()
//        executorService.shutdown();
//        executorService.awaitTermination(10, TimeUnit.SECONDS);
//        System.out.println(factorialResult);

        // 2 - для "Урок 17. Интерфейсы Callable и Future. Часть 2" - submit(), isDone()
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        // Для Runnable используем метод execute()
//        executorService.execute(factorial);
        // Для Runnable Можем использовать метод submit(). Future without generic
        Future future = executorService.submit(factorial);
        // Проверяем завершение задачи с помощью метода isDone()
        System.out.println("future.isDone() -> " + future.isDone());
        executorService.shutdown();
//        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(future.get()); // >> null
        System.out.println("future.isDone() -> " + future.isDone());
        System.out.println(factorialResult);
    }
}

class Factorial implements Runnable {
    int f;

    public Factorial(int f) {
        this.f = f;
    }

    // 1) Мы не можем возвращать значение в Runnable, т.к. public void run()
    // 2) Мы не можем выбрасывать exception в Runnable, т.к. public abstract void run()
    @Override
    public void run() {
        if (f <= 0) {
            System.out.println("Вы ввели неправильное число!");
            return;
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        RunnableFactorialEx.factorialResult = result;
    }
}
