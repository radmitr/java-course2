package regex;

import java.util.Arrays;

/* ------------------------ 10. Регулярные выражения ----------------------------- */
/* 4. Методы класса String mathes и split */
/**
    ------------------------
     Методы matches и split
    ------------------------
    public boolean matches(String regex)
    public String[] split(String regex)
*/
public class Regex3 {

    // matches(), split()
    public static void main(String[] args) {
        String s = "Ivanov Vasiliy, Russia, Moscow, Lenin Street, 51, Flat 48, " +
                "email: vivanov@mail.ru, Postcode: AA99, Phone Number: +123456789;"
                + "Petrova Mariya, Ukraine, Kiyev, Lomonosov street, 33, flat 18," +
                "email: masha@yandex.ru, Postcode: UKR54, Phone Number: +987654321;"
                + "Chuck Norris, USA, Hollywood, All stars street, 87, flat 21," +
                "email: chuck@gmail.com, Postcode: USA23, Phone Number: +136478952.";

        // 1 - matches()
        // 1.1
        String s2 = "chuck@gmail.com";
        // 1.2
//        String s2 = "chuck@gmail.com masha@yandex.ru"; // нет соответствия

        boolean result = s2.matches("\\w+@\\w+\\.(com|ru)");
        System.out.println(result);

        // 2 - split()
        String[] array = s.split(" ");
        System.out.println(Arrays.toString(array));
    }
}
