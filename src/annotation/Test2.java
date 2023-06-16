package annotation;

import java.lang.annotation.*;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 7. Аннотации */
    // 3rd class
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
public class Test2 {

    // getAnnotation()
    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("annotation.Xiaomi");
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1;
        System.out.println("Annotation info from Xiaomi class: " + sm1.OS() + ", " + sm1.yearOfCompanyCreation());

        Class iphoneClass = Class.forName("annotation.Iphone");
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm2 = (SmartPhone) annotation2;
        System.out.println("Annotation info from Iphone class: " + sm2.OS() + ", " + sm2.yearOfCompanyCreation());
    }
}

    // 1 - annotation without default field values
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//@interface SmartPhone {
//    String OS(); // field
//    int yearOfCompanyCreation(); // field
//}

    // 2 - annotation with default field values
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Retention(RetentionPolicy.SOURCE) // java.lang.NullPointerException
//@Retention(RetentionPolicy.CLASS) // java.lang.NullPointerException
@interface SmartPhone {
    String OS() default "Android";
    int yearOfCompanyCreation() default 2010;
}

    // 1 - set field values
//@SmartPhone(OS = "Android", yearOfCompanyCreation = 2010)
//class Xiaomi {
//    String model;
//    double price;
//}

    // 2 - annotation with default field values
@SmartPhone()
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(OS = "iOS", yearOfCompanyCreation = 1976)
class Iphone {
    String model;
    double price;
}
