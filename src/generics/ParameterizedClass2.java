package generics;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 2. Parameterized class */
    // 2nd class
/* 3. Parameterized method */
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
public class ParameterizedClass2 {

    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Hello", 20);
        System.out.println("Value of pair: value1 = " + pair1.getFirstValue1() +
                ", value2 = " + pair1.getSecondValue2());

        Pair<Integer, Double> pair2 = new Pair<>(156, 3.14);
        System.out.println("Value of pair: value1 = " + pair2.getFirstValue1() +
                ", value2 = " + pair2.getSecondValue2());

        OtherPair<String> otherPair = new OtherPair<>("Ok", "Bye");
        System.out.println("Value of other pair: value1 = " + otherPair.getFirstValue1() +
                ", value2 = " + otherPair.getSecondValue2());
    }
}

class Pair<V1, V2> {
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getFirstValue1() {
        return value1;
    }

    public V2 getSecondValue2() {
        return value2;
    }
}

class OtherPair<V> {
    private V value1;
    private V value2;

    /* ----- 3. Parameterized method ----- */
    // 1
//    public <V> V abc(V val) { // <V> можно не писать
//        return val;
//    }
    // 2
    public V abc(V val) {
        return val;
    }
    /* ----------------------------------- */

    public OtherPair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getFirstValue1() {
        return value1;
    }

    public V getSecondValue2() {
        return value2;
    }
}
