package lambda;

/* --------------------------- 6. Lambda выражения ------------------------------- */
/* 1. Lambda выражения. Часть 1 */
    // 3rd class
/* 2. Lambda выражения. Часть 2 */
    // 3rd class
/**
    --------------------
     Lambda expressions
    --------------------
    Самый короткий вариант написания лямбда выражения:
    stud -> stud.avgGrade > 8.5

    Более полный вариант написания лямбда выражения:
    (Student stud) -> {return stud.avgGrade> 8.5;}

    В лямбда выражении оператор стрелка разделяет параметры метода и тело метода.

    В лямбда выражении справа от оператора стрелка находится тело метода, которое было бы
    у метода соответствующего класса, имплементировавшего наш интерфейс с единственным методом.

    -----

    Вы можете использовать смешанный вариант написания лямбда выражения: слева от оператора стрелка писать
    короткий вариант, справа – полный. Или наоборот.

    Если вы используете полный вариант написания для части лямбда выражения справа от стрелки,
    то вы должны использовать слово return и знак «;»

    Левая часть лямбда выражения может быть написана в краткой форме, если метод интерфейса принимает
    только 1 параметр. Даже если метод интерфейса принимает 1 параметр, но в лямбда выражении вы хотите
    писать данный параметр используя его тип данных, тогда уже вы должны писать левую часть лямбда выражения
    в скобках.

    Если в правой части лямбда выражения вы пишите более одного statement-а, то вы должны использовать его
    полный вариант написания.

    -----

    def( () -> 5 );
    def( (x) -> x.length() );
    def( (String x) -> x.length() );
    def( (x, y) -> x.length() );
    def( (String x, String y) -> x.length() );

    ___Compile time errors:___
    def( x -> {x.length();} );
    def( x -> {return x.length()} );
    def( x, y -> x.length() );

    -----

    Лямбда выражения работают с интерфейсом, в котором есть только 1 абстрактный метод.
    Такие интерфейсы называются функциональными интерфейсами, т.е. интерфейсами, пригодными
    для функционального программирования.
*/
public class Test2 {

    /* ----- 1. Lambda выражения. Часть 1 ----- */
//    static void def(I i) {
//        System.out.println(i.abc("Hello"));
//    }
//
//    public static void main(String[] args) {
////        def((String str) -> {return str.length();});
//        def((String str) -> str.length());
//    }
    /* ---------------------------------------- */

    /* ----- 2. Lambda выражения. Часть 2 ----- */
    // 1
//    static void def(I i) {
//        System.out.println(i.abc());
//    }
//
//    public static void main(String[] args) {
////        def(() -> {return 18;});
//        def(() -> 18);
//    }
    // 2
    static void def(I i) {
        System.out.println(i.abc("Hello"));
    }

    public static void main(String[] args) {
        // 2
//        def((String str) -> {return str.length();}); // >> 5
        // 3.1
//        int i = 10;
//        def((String str) -> {return str.length() + i;}); // >> 15
        // 3.2
        int i = 10; // effectively final
//        final int i = 10;
//        i = 15; // variable used in lambda expression should be final or effectively final
        def((String str) -> {
            int a = 5;
            System.out.println(i);
            return str.length();
        });
//        i = 15; // variable used in lambda expression should be final or effectively final

//        System.out.println(a); // // cannot resolve symbol 'a'
//        System.out.println(s); // cannot resolve symbol 's'
    }
    /* ---------------------------------------- */
}

/* ----- 1. Lambda выражения. Часть 1 ----- */
//interface I {
//    int abc(String s);
//}
/* ---------------------------------------- */

/* ----- 2. Lambda выражения. Часть 2 ----- */
    // 1
//interface I {
//    int abc();
//}
    // 2
interface I {
    int abc(String s);
}
/* ---------------------------------------- */
