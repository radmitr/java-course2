package collection.queue_interface;

import java.util.PriorityQueue;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 24. PriorityQueue */
/**
    ---------------
     PriorityQueue
    ---------------
    PriorityQueue – это специальный вид очереди, в котором используется натуральная сортировка или та,
    которую мы описываем с помощью Comparable или Comparator. Таким образом используется тот элемент из очереди,
    приоритет которого выше.
*/
public class PriorityQueueEx1 {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(4);
        priorityQueue.add(1); // the highest priority
        priorityQueue.add(7);
        priorityQueue.add(10); // the lowest priority
        priorityQueue.add(8);
        // 1 4 7 8 10

        System.out.println(priorityQueue); // видим не тот порядок, хотя нормально отсортированы
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
    }
}
