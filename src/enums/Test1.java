package enums;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 1. Enum. Часть 1 */
    // 1st class
/**
    ------
     enum
    ------
    enum – это способ ограничения определённого рода информации конкретным списком возможных вариантов.
    Конструктор в enum имеет access modifier private и не нуждается во внешнем вызове.
    enum является дочерним классом для java.lang.Enum
    Часто используемые методы: valueOf, values.
*/
public class Test1 {

    void method(String dayOfWeek) {
        System.out.println("Today is " + dayOfWeek);
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.method("Monday");
        t.method("hello");
    }
}
