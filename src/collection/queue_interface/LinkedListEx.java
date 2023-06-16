package collection.queue_interface;

import java.util.LinkedList;
import java.util.Queue;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 23. Введение в Queue. LinkedList */
    // 1st class
/**
    ----------------------
     Queue and LinkedList
    ----------------------
    Queue – это коллекция, хранящая последовательность элементов. Добавляется элемент в конец очереди,
    используется из начала очереди – правило FIFO.

    Класс LinkedList имплементирует не только интерфейс List, но и интерфейс Deque.

    Методы: add(), offer(), remove(), poll(), element(), peek().
*/
public class LinkedListEx {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // 1 - add()
//        queue.add("Dmitriy");
//        queue.add("Oleg");
//        queue.add("Ivan");
//        queue.add("Mariya");
//        queue.add("Aleksandr");
//        System.out.println(queue);

        // 2 - offer()
        queue.offer("Dmitriy");
        queue.offer("Oleg");
        queue.offer("Ivan");
        queue.offer("Mariya");
        queue.offer("Aleksandr");
        System.out.println(queue);

        // 3 - remove()
        // 3.1
//        System.out.println(queue.remove());
//        System.out.println(queue);
        // 3.2
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove()); // java.util.NoSuchElementException

        // 4 - poll()
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll()); // >> null (no exception)

        // 5 - element()
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue.element()); // java.util.NoSuchElementException

        // 6 - peek()
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek()); // >> null (no exception)

        // 7 - remove(Object o)
        queue.remove("Ivan");
        System.out.println(queue);
    }
}
