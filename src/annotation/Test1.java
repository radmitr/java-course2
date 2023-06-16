package annotation;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 7. Аннотации */
    // 1st class
/**
    ------------
     Annotation
    ------------
    Аннотации – это специальные комментарии/метки/метаданные, которые нужны для передачи определённой информации.

    @Target показывает область кода, к которой Аннотация может быть применима. Самые распространённые области кода:
    • TYPE – class, interface, enum;
    • FIELD – поле класса;
    • METHOD – метод класса;
    • PARAMETER – параметры метода или конструктора
    @Retention описывает жизненный цикл Аннотации
    • SOURCE – Аннотация видна в source коде, отбрасывается компилятором и уже в byte коде не видна;
    • CLASS – Аннотация видна в byte коде, отбрасывается JVM во время выполнения программы;
    • RUNTIME – Аннотация видна во время выполнения программы
*/
public class Test1 {

    // @Override, @Deprecated
    public static void main(String[] args) {
        Parent p = new Child("Dmitriy");
        p.showInfo();
    }
}

class Parent {
    String name;

    public Parent(String name) {
        this.name = name;
    }

    // 1 // 2 // 3 // 4
//    void showInfo() {
//        System.out.println("It's Parent class. Name = " + name);
//    }

    // 5 (выбрать // 1 или // 2 класса Child)
//    void showInfo2() {
//        System.out.println("It's Parent class. Name = " + name);
//    }

    // 6 - use annotation @Deprecated
    @Deprecated
    void showInfo() {
        System.out.println("It's Parent class. Name = " + name);
    }
}

class Child extends Parent {
    public Child(String name) {
        super(name);
    }

    // 1 - override method of super class
//    void showInfo() {
//        System.out.println("It's Child class. Name = " + name);
//    }

    // 2 - override method of super class, use annotation @Override
    @Override
    void showInfo() {
        System.out.println("It's Child class. Name = " + name);
    }

    // 3 - not override super method, creates other method
////    @Override // Method does not override method from its superclass
//    void showinfo() {
//        System.out.println("It's Child class. Name = " + name);
//    }

    // 4 - not override super method, overload super method
////    @Override // Method does not override method from its superclass
//    void showInfo(String name) {
//        System.out.println("It's Child class. Name = " + name);
//    }
}
