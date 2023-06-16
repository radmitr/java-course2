package generics;

import java.util.ArrayList;
import java.util.List;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 1. Введение в generics */
/**
    ----------
     Generics
    ----------
              Type Safe & Reusable Code
    Parameterized Class         Parameterized Method

    <?> - любой класс
    <? extends X> - класс X или любой его сабкласс
    <? super Y> - класс Y или любой его суперкласс
*/
public class Test1 {

    public static void main(String[] args) {
//        List list = new ArrayList();
//        List<String> list = new ArrayList<String>();
        List<String> list = new ArrayList<>(); // <> - diamond

        // 1
//        list.add(5);
//        list.add("OK");
//        list.add(new StringBuilder("qwertyuiop"));
//        list.add(new Car());

        // 2
        list.add("Hello");
        list.add("Bye");
        list.add("Ok");
        list.add("kljdfglsdfl");
//        list.add(new Car()); // java.lang.ClassCastException

        for (Object o : list) {
            System.out.println(o + " length " + ((String)o).length());
        }
    }
}

class Car {
}
