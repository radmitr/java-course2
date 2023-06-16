package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/* ---------------------------- 8. Многопоточность ------------------------------- */
/* 17. Интерфейсы Callable и Future. Часть 2 */
    // 3rd class
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
public class SumNumbersEx {

    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResults = new ArrayList<>();
        long valueDividedBy10 = value / 10;

        for (int i = 0; i < 10; i++) {
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);

            Future<Long> futurePartSum = executorService.submit(task);
            futureResults.add(futurePartSum);
        }
        for (Future<Long> result : futureResults) {
            sum += result.get();
        }
        executorService.shutdown();
        System.out.println("Total sum = " + sum); // >> Total sum = 500000000500000000
    }
}

class PartialSum implements Callable<Long> {
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
}
