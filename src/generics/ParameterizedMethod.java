package generics;

import java.util.ArrayList;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 3. Parameterized method */
    // 1st class
/* 4. Type erasure */
    // 1st class
/* 5. Subtyping */
    // 3rd class
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
public class ParameterizedMethod {

    public static void main(String[] args) {
        /* ----- 3. Parameterized method ----- */
        // 1
        ArrayList<Integer> al1 = new ArrayList<>(); // generics появились в java 5

        /* ----- 4. Type erasure ----- */
        // Когда пишем: ArrayList<Integer> al1 = new ArrayList<>();
        // JVM видит это после компиляции как: ArrayList al1 = new ArrayList()
        // ArrayList al1 = new ArrayList(); // Type erasure был создан для совместимости с версиями младше java 5

        int i = al1.get(0);
        // Когда пишем: int i = al1.get(0);
        // JVM видит это после компиляции как: int i = (Integer)al1.get(0);
        // int i = (Integer)al1.get(0);
        /* --------------------------- */

        al1.add(10);
        al1.add(20);
        al1.add(5);

        int a = GenericMethod.getSecondElement(al1);
        System.out.println(a);

        // 2
        ArrayList<String> al2 = new ArrayList<>();
        al2.add("abc");
        al2.add("def");
        al2.add("ghi");

        // нельзя для /* 5. Subtyping */
//        String s = GenericMethod.getSecondElement(al2);
//        System.out.println(s);
        /* ----------------------------------- */
    }
}

/* ----- 3. Parameterized method ----- */
//class GenericMethod {
//    public static <T> T getSecondElement(ArrayList<T> al) {
//        return al.get(1);
//    }
//}
/* ----------------------------------- */

/* ----- 5. Subtyping ----- */
class GenericMethod {
    // так нельзя
//    public static <T> T getSecondElement(ArrayList<T extends Number> al) { // так нельзя
    // так можно
    public static <T extends Number> T getSecondElement(ArrayList<T> al) { // так можно
        return al.get(1);
    }
}
/* ------------------------ */
