package enums;

import java.util.Arrays;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 1. Enum. Часть 1 */
    // 2nd class
/* 2. Enum. Часть 2 */
/**
    ------
     enum
    ------
    enum – это способ ограничения определённого рода информации конкретным списком возможных вариантов.
    Конструктор в enum имеет access modifier private и не нуждается во внешнем вызове.
    enum является дочерним классом для java.lang.Enum
    Часто используемые методы: valueOf, values.
*/
public class EnumEx1 {

    // valueOf(), values()
    public static void main(String[] args) {
//        Today today = new Today(WeekDays.MONDAY);
//        Today today = new Today(WeekDays.FRIDAY);
        Today today = new Today(WeekDays.SUNDAY);
        today.daysInfo();

        /* ----- 2. Enum. Часть 2 ----- */
        System.out.println(today.weekDay); // >> MONDAY // >> FRIDAY // >> SUNDAY

        WeekDays w1 = WeekDays.FRIDAY;
        WeekDays w2 = WeekDays.FRIDAY;
        WeekDays w3 = WeekDays.MONDAY;

        System.out.println(w1 == w2); // >> true
        System.out.println(w1 == w3); // >> false
        System.out.println(WeekDays.FRIDAY == WeekDays.FRIDAY); // >> true
        System.out.println(WeekDays.FRIDAY == WeekDays.MONDAY); // >> false

//        System.out.println(WeekDays.FRIDAY == WeekDays2.FRIDAY); // нельзя, т.к. разные enum
        System.out.println(WeekDays.FRIDAY.equals(WeekDays2.FRIDAY)); // >> false (т.к разные типы)

        // 1 - valueOf()
        WeekDays w15 = WeekDays.valueOf("MONDAY");
//        WeekDays w15 = WeekDays.MONDAY;
//        WeekDays w15 = WeekDays.valueOf("MONDAy"); // java.lang.IllegalArgumentException
        System.out.println(w15); // >> MONDAY

        // 2 - values()
        WeekDays[] array = WeekDays.values();
        System.out.println(Arrays.toString(array));
        /* ---------------------------- */
    }
}

/* ----- 1. Enum. Часть 1 ----- */
//enum WeekDays {
//    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
//}
/* ---------------------------- */

/* ----- 2. Enum. Часть 2 ----- */
enum WeekDays {
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY("good"),
    SATURDAY("great"),
    SUNDAY("good");

    private String mood;

    private WeekDays(String mood) {
        this.mood = mood;
    }

//    private WeekDays() {
//    }

    String getMood() {
        return mood;
    }
}

enum WeekDays2 {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}
/* ---------------------------- */

class Today {
    WeekDays weekDay;

    public Today(WeekDays weekDay) {
        this.weekDay = weekDay;
    }

    void daysInfo() {
        switch (weekDay) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Go to work!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("You can relax");
                break;
        }
        /* ----- 2. Enum. Часть 2 ----- */
        System.out.println("The mood on this day is " + weekDay.getMood());
        /* ---------------------------- */
    }
}
