package collection.list_interface;

import java.util.Stack;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 12. Stack */
    // 2nd class
/**
    -------
     Stack
    -------
    Stack – устаревший synchronized класс. Использует принцип LIFO.
    Не рекомендован для использования.

    Методы:push(), pop(), peek(), isEmpty().
*/
public class StackEx2 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // 0 - push()
        stack.push("Dmitriy");
        stack.push("Misha");
        stack.push("Oleg");
        stack.push("Katya");

        // 1 - pop()
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop()); // java.util.EmptyStackException

        // 2 - isEmpty()
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//            System.out.println(stack);
//        }

        // 3 - peek()
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
