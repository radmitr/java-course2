package collection.queue_interface;

import java.util.ArrayDeque;
import java.util.Deque;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 25. Введение в Deque. ArrayDeque */
/**
    ----------------------
     Deque and ArrayDeque
    ----------------------
    Deque – double ended queue (двунаправленная очередь). В такой очереди элементы могут использоваться с
    обоих концов. Здесь работают оба правила – FIFO и LIFO.

    Интерфейс Deque реализуется классами LinkedList и ArrayDeque.

    Методы: addFirst(), addLast(), offerFirst(), offerLast(),
            removeFirst(), removeLast(), pollFirst(), pollLast(),
            getFirst(), getLast(), peekFirst(), peekLast().
*/
public class ArrayDequeEx {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // 1 - addFirst(), addLast(), offerFirst(), offerLast()
        deque.addFirst(3);
        deque.addFirst(5);
        deque.addLast(7);
        deque.offerFirst(1);
        deque.offerLast(8);
        System.out.println(deque); // >> [1, 5, 3, 7, 8]
        System.out.println("");

        // 2 - removeFirst(), removeLast(), pollFirst(), pollLast()
//        System.out.println(deque.removeFirst());
//        System.out.println(deque);
//        System.out.println(deque.removeLast());
//        System.out.println(deque);
//        System.out.println(deque.pollFirst());
//        System.out.println(deque);
//        System.out.println(deque.pollLast());
//        System.out.println(deque);
//        System.out.println("");

        // 3 - getFirst(), getLast(), peekFirst(), peekLast() [get - peek (element - peek)]
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque);
        System.out.println(deque.pollLast());
        System.out.println(deque);
    }
}
