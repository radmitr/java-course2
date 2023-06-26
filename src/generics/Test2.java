package generics;

import java.util.ArrayList;
import java.util.List;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 5. Subtyping */
    // 1st class
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
public class Test2 {

    public static void main(String[] args) {
        X x = new Y();
        // 1
        List<X> list1 = new ArrayList<>(); // подразумевается: List<X> list1 = new ArrayList<X>();
        // 2 - так нельзя
//        List<X> list1 = new ArrayList<Y>(); // так нельзя
        /* Не работает, потому что совокупность ArrayList<Y> не является подтипом List<X>,
           хотя ArrayList является подтипом List и Y является подтипом X!!!!! */
        // 3 - так нельзя
//        List<Number> list = new ArrayList<Integer>(); // так нельзя
//        list.add(18); // так нельзя
//        list.add(3.14); // так нельзя
        /* Если бы так можно было, тогда бы в runtime всё рухнуло: типом списка list является List<Number>,
           но его динамическим типом является ArrayList<Integer>, а Integer не может содержать Double. Поэтому
           компилятор так не разрешает!!!!! */
    }
}

class X {
}

class Y extends X {
}
