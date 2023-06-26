package generics;

import java.util.ArrayList;
import java.util.List;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 6. Wildcards */
/**
    ----------
     Generics
    ----------
              Type Safe & Reusable Code
    Parameterized Class         Parameterized Method

    <?> - любой класс
    <? extends X> - класс X или любой его сабкласс
    <? super Y> - класс Y или любой его суперкласс
    --------------------------------------------------------------------
    The most commonly used type parameter names are:
        E - Element (used extensively by the Java Collections Framework)
        K - Key
        N - Number
        T - Type
        V - Value
        S, U, V etc. - 2nd, 3rd, 4th types
*/
public class Test3 {

    public static void main(String[] args) {
        // 1 - так нельзя
//        List<Number> list = new ArrayList<Integer>(); // так нельзя
//        List<Object> list = new ArrayList<Integer>(); // так нельзя

        // 2 - <?> - любой класс
//        List<?> list = new ArrayList<Integer>(); // так можно
        List<?> list = new ArrayList<String>(); // так можно
//        list.add("hello"); // нельзя, компилятор не разрешает так, потому что не знает какой тип у list, не
                             // разрешает изменять объект, add() изменяет объект

        // 4 - bounded wildcards
        List<? extends Number> list30 = new ArrayList<Integer>(); // так можно, Integer extends Number
//        List<? extends Number> list30 = new ArrayList<String>(); // так нельзя, String не extends Number
        List<? super Number> list31 = new ArrayList<Object>(); // так можно, Object является super для Number

        // 3
        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        showListInfo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Ok");
        list2.add("Hello");
        list2.add("Bye");
        showListInfo(list2);

        // 5
        ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.14);
        ald.add(3.15);
        ald.add(3.16);
        System.out.println(summ(ald));

        ArrayList<Integer> ali = new ArrayList<>();
        ali.add(3);
        ali.add(35);
        ali.add(30);
        System.out.println(summ(ali));

        ArrayList<String> als = new ArrayList<>();
//        System.out.println(summ(als)); // ошибка
    }

    // 3
    static void showListInfo(List<?> list) {
        System.out.println("My list includes the following elements: " + list);
//        list.add(3.17); // так нельзя
//        list.add("Good"); // так нельзя
    }

    // 3.1
//    static <T> void showListInfo(List<T> list) {
//        System.out.println("My list includes the following elements: " + list);
////        list.add(3.17); // так нельзя
////        list.add("Good"); // так нельзя
//    }

    // 5
    public static double summ(ArrayList<? extends Number> al) {
        double summ = 0;
        for (Number n : al) {
//            summ += n.doubleValue();
            summ += n.doubleValue();
        }
        return summ;
    }
}
