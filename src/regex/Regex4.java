package regex;

/* ------------------------ 10. Регулярные выражения ----------------------------- */
/* 5. Методы replaceAll и group */
    // 1st class
public class Regex4 {

    // replace(), replaceAll(), replaceFirst()
    public static void main(String[] args) {
        String s1 = "Hello,     my    friend!    How is learning  Java     going     ?";
        System.out.println(s1);

        // 1 - replace()
//        s1 = s1.replace("Java", "SQL");

        // 2 - replaceAll()
        // 2.1
//        s1 = s1.replaceAll(" {2,}", " ");
        // 2.2
//        s1 = s1.replaceAll("\\bH\\w+", "4444");

        // 3 - replaceFirst()
        s1 = s1.replaceFirst("\\bH\\w+", "4444");

        System.out.println(s1);

    }
}
