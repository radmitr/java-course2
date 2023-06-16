package collection.list_interface;

import java.util.Vector;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 11. Vector */
/**
    --------
     Vector
    --------
    Vector – устаревший synchronized класс. В своей основе содержит массив элементов Object.
    Не рекомендован для использования.

    Методы: add(), get(), remove(), firstElement(), lastElement.
*/
public class VectorEx {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();

        // add()
        vector.add("Dmitriy");
        vector.add("Misha");
        vector.add("Oleg");
        vector.add("Katya");

        System.out.println(vector);

        // firstElement(), lastElement()
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());

        // remove()
        vector.remove(2);

        System.out.println(vector);

        // get()
        System.out.println(vector.get(1));
    }
}
