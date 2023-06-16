package generics.game;

/* ------------------------------- 3. Generics ----------------------------------- */
/* 7. Пример на generics */
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
public class Schoolchild extends Participant {

    public Schoolchild(String name, int age) {
        super(name, age);
    }
}
