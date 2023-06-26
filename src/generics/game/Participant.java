package generics.game;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 7. Пример на generics */
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
public abstract class Participant {

    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
