package generics;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 2. Parameterized class */
    // 1st class
/* 4. Type erasure */
    // 2nd class
/* 5. Subtyping */
    // 2nd class
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
public class ParameterizedClass {

    public static void main(String[] args) {
        /* ----- 2. Parameterized class ----- */
        // нельзя для /* 5. Subtyping */
//        Info<String> info1 = new Info<>("Hello");
//        System.out.println(info1);
//        String s = info1.getValue();

        Info<Integer> info2 = new Info<>(18);
        System.out.println(info2);
        Integer i = info2.getValue();
        /* ---------------------------------- */

        /* ----- 5. Subtyping ----- */
        Info<Double> info21 = new Info<>(3.14);
        System.out.println(info21);
        Double d = info21.getValue();

        // нельзя для /* 5. Subtyping */
//        Info<Bus> info3 = new Info<>(new Bus());
//        System.out.println(info3);
//        Bus b = info3.getValue();
        /* ------------------------ */
    }

    /* ----- 4. Type erasure ----- */
    // нельзя для /* 5. Subtyping */
//    public void abc(Info<String> info) {
//        String s = info.getValue();
//    }

    // так нельзя
//    public void abc(Info<Integer> info) { //
//        Integer i = info.getValue();
//    }

    /* Для JVM abc(Info<String> info) == abc(Info info), abc(Info<Integer> info) == abc(Info info),
       поэтому не можем создавать такие overload методы!!!!! */
    /* --------------------------- */
}

//class Info<T> {
//    // T - type (type placeholder - заполнитель типа)
//    // E - Element (example: List)
//    // K - Key, V - Value (example: Map)
//    private T value;
////    private static T value; // нельзя объвлять static T!!!!!
//
//    public Info(T value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "{[" + value + "]}";
//    }
//
//    public T getValue() {
//        return value;
//    }
//}

/* ----- 5. Subtyping ----- */
// 1 - extends class
class Info<T extends Number> {
// 2 - extends class & interfaces
//class Info<T extends I1&I2&Number> { // так нельзя, класс должен быть на первом месте
//class Info<T extends Number&I1&I2> {
    // T - type (type placeholder - заполнитель типа)
    // E - Element (example: List)
    // K - Key, V - Value (example: Map)
    private T value;
//    private static T value; // нельзя объвлять static T!!!!!

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}

interface I1 {
}
interface I2 {
}
/* ------------------------ */

/* ----- 4. Type erasure ----- */
// нельзя для /* 5. Subtyping */
//class Parent {
//    public void abc(Info<String> info) {
//        String s = info.getValue();
//    }
//}
    // так нельзя
//class Child extends Parent {
//    public void abc(Info<Integer> info) {
//        Integer s = info.getValue();
//    }
//}

/* Хотя для JVM abc(Info<String> info) == abc(Info info), abc(Info<Integer> info) == abc(Info info),
   компилятор понимает, что при casting в сабклассе будут проблемы,
   поэтому не можем создавать такие override методы!!!!! */
/* --------------------------- */

/* ----- 5. Subtyping ----- */
class Bus {
}
/* ------------------------ */
