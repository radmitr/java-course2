package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* ------------------------ 10. Регулярные выражения ----------------------------- */
/* 5. Методы replaceAll и group */
    // 2nd class
public class Regex5 {

    // replaceAll()
    public static void main(String[] args) {
        String myString = "12345678912345670325987;" +
                "98765432165498750921654;" +
                "85274196345612381122333";
        // 12345678912345670325987 => 1234 5678 9123 4567 03/25 (987) =>  03/25 1234 5678 9123 4567 (987)
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(myString);

        // 1
        String newMyString = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
        System.out.println(newMyString);

        // 2
        matcher.reset();
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // 3
        matcher.reset();
        while (matcher.find()) {
            System.out.println(matcher.group(7));
        }
    }
}
