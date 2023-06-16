package multithreading;

import java.util.concurrent.*;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 16. Интерфейсы Callable и Future. Часть 1 */
    // 2nd class
/* 17. Интерфейсы Callable и Future. Часть 2 */
    // 1st class
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
public class CallableFactorialEx {

    static int factorialResult;

    // Callable мы можем использовать только с ExecutorService !!!
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(6);
//        Thread thread = new Thread(factorial2); // Cannot resolve constructor 'Thread(Factorial2)'
        // Для Callable мы не можем использовать метод execute(), т.к. он принимает только Runnable
        // Используем метод submit()
        // Получаем Future с помощью мтода get()
        // Проверяем завершение задачи с помощью метода isDone()
        Future<Integer> future = executorService.submit(factorial2); // Future with generic
        try {
            System.out.println("future.isDone() -> " + future.isDone());
            System.out.println("Мы хотим получить результат");
            factorialResult = future.get(); // метод get() блокирует поток, не нужно вызывать метод awaitTermination()
            System.out.println("Мы получили результат");
            System.out.println("future.isDone() -> " + future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.err.println(e.getCause());
        } finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class Factorial2 implements Callable<Integer> {
    int f;

    public Factorial2(int f) {
        this.f = f;
    }

    // 1) Мы можем возвращать значение в Callable, т.к. V call() throws Exception
    // 2) Мы можем выбрасывать exception в Callable, т.к. V call() throws Exception
    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Вы ввели неверное число!");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}
