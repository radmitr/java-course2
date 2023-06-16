package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* ------------------------ 10. Регулярные выражения ----------------------------- */
/* 1. RegEx. Часть 1 */
    // 1st class
/* 2. RegEx. Часть 2 */
/* 3. RegEx. Часть 3 */
    // 2nd class
/**
    ---------------------
     REGular EXpressions
    ---------------------
    Регулярные выражения необходимы для создания шаблонов, с помощью которых
    производят такие операции, как поиск, сравнение, замена.

    Регулярные выражения - это совокупность символов, некоторые из которых являются
    специальными - метасимволами, т.е. обладают каким-то функционалом.

    ------------------------------------
     Часто используемые символы в REGEX
    ------------------------------------
    abc – Соответствует последовательно идущим abc
    [abc] – Соответствуетили a, или b, или c
    [d-j] – Соответствует одной из букв из диапазона d-j
    [3-8] – Соответствует одной из цифр из диапазона 3-8
    [B-Fd-j3-8] – Соответствуетодной из букв из обоих диапазонов или одной из цифр из диапазона 3-8
    a|b – Соответствуетлибо букве a, либо букве b
    [^d-j] – Данный символ, стоящий в начале этих скобок, означает отрицание. Соответствует одной
             из букв НЕ из диапазона d-j
    . – Соответствует одному любому символу. Исключение: символ новой строки
    ^выражение – Соответствует выражению в начале строки
    выражение$ – Соответствуетвыражению в конце строки

    ----------------------------------------
     Часто используемые МЕТАсимволы в REGEX
    ----------------------------------------
    \d – Соответствуетодной цифре
    \D – Соответствуетодной НЕ цифре
    \w – Соответствуетодной букве, цифре или «_»
    \W – Соответствуетодному символу, который НЕ буква, НЕ цифра и НЕ «_»
    \s – Соответствует пробельному символу
    \S – Соответствует НЕ пробельному символу
    \A – Соответствует выражению в начале String-а
    \Z – Соответствует выражению в конце String-а
    \b – Соответствует границе слова или числа
    \B – Соответствует границе НЕ слова и НЕ числа

    ------------------------------------------------------------------------
     Часто используемые символы в REGEX, обозначающие количество повторений
    ------------------------------------------------------------------------
    выражение? – Соответствует 0 или 1 повторению
    выражение* – Соответствует 0 или большему количеству повторений
    выражение+ – Соответствует 1 или большему количеству повторений
    выражение{n} – Соответствует количеству повторений «n»
    выражение{m, n} – Соответствует количеству повторений от «m» до «n»
    выражение{n,} – Соответствует n или большему количеству повторений

    --------------------------
     Классы Pattern и Matcher
    --------------------------
    Pattern myPattern = Pattern.compile(«REGEX");
    Matcher myMatcher = myPattern.matcher(myString);

    Пакет: java.util.regex
*/
public class Regex2 {

    public static void main(String[] args) {

        /* ----- 1. RegEx. Часть 1 ----- */

        // 1 - abc
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("ABCD");

        // 2 - abc
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("ABC");

        // 3 - [d-j]
//        String s1 = "OPABMNCD";
//        Pattern pattern1 = Pattern.compile("[ABC]");

        // 4 - [d-j]
        // 4.1
//        String s1 = "ABDOP";
        // 4.2
//        String s1 = "ABCOPABDOP";
//        Pattern pattern1 = Pattern.compile("AB[C-F]OP");

        // 5 - [B-Fd-j3-8]
//        String s1 = "abcd abce abc5abcg6abch";
//        // 5.1
////        Pattern pattern1 = Pattern.compile("abc[e-g4-7]");
//        // 5.2 - [^d-j]
//        Pattern pattern1 = Pattern.compile("abc[^e-g4-7]");

        /* ----- 2. RegEx. Часть 2 ----- */

        // 6 - a|b
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc(e|5)");

        // 7 - .
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc.");

        // 8 - ^выражение
//        String s1 = "abcd abce abc5abcg6abch";
//        // 8.1
//        Pattern pattern1 = Pattern.compile("^abc");
//        // 8.2
////        Pattern pattern1 = Pattern.compile("^5abc"); // нет соответствия

        // 9 - выражение$
//        String s1 = "abcd abce abc5abcg6abch";
//        // 9.1
////        Pattern pattern1 = Pattern.compile("abc5abcg6abch$");
//        // 9.2
//        Pattern pattern1 = Pattern.compile("ch$");
//        // 9.3
////        Pattern pattern1 = Pattern.compile("abc$"); // нет соответствия

        // 10 - \d
//        String s1 = "abcd abce abc5abcg6abch";
//        // 10.0
////        Pattern pattern1 = Pattern.compile("[0-9]");
//        // 10.1
//        Pattern pattern1 = Pattern.compile("\\d");

        // 11 - \D
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\D");

        // 12 - \w
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w"); // \w = [A-Za-z0-9_]

        // 13 - выражение+
//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w+");

        // 14 - \W
//        String s1 = "abcd!?abce====abc ++5abcg6abch";
//        // 14.1
////        Pattern pattern1 = Pattern.compile("\\W"); // \W = [^A-Za-z0-9_]
//        // 14.2
//        Pattern pattern1 = Pattern.compile("\\W+");

        // 15 - выражение{n}
//        // 15.1
////        String s1 = "poka abc Dmitriy dom kino";
//        // 15.2
//        String s1 = "poka abc Dmitriy dom kino abstractionism";
//        Pattern pattern1 = Pattern.compile("\\w{4}");

        /* ----- 3. RegEx. Часть 3 ----- */

        // 16 - \s
//        String s1 = "poka     abc   Dmitriy      dom     kino abstractionism";
//        Pattern pattern1 = Pattern.compile("\\w\\s+\\w"); // \s = [\t\n\r\f]

        // 17 - \D, выражение{m, n}, выражение{n,}
//        // 17.1
////        String s1 = "abcd abce3 abcfa78abcg6abch";
//        // 17.2
////        String s1 = "abcd abce3 abcfa78abcg6a";
//        // 17.3
//        String s1 = "abcd abce3 abcfa78abcg6a!!!!!!!!!!!!!!!";
//
////        Pattern pattern1 = Pattern.compile("\\D{2,6}");
//        Pattern pattern1 = Pattern.compile("\\D{2,}");

        // 18 - выражение{m, n}
//        String s1 = "ABCABABDA";
//        // 18.1
////        Pattern pattern1 = Pattern.compile("AB{2,3}");
//        // 18.2
//        Pattern pattern1 = Pattern.compile("(AB){2,3}");

        // 19 - выражение?
//        String s1 = "DABCDABABDA";
//        Pattern pattern1 = Pattern.compile("D(AB)?");

        // 20 - выражение*
//        String s1 = "DABCDABABDA";
//        Pattern pattern1 = Pattern.compile("D(AB)*");

        // 21 - \A
//        String s1 = "abcd abce abceabcgabch";
//        // 21.1
////        Pattern pattern1 = Pattern.compile("\\Aabcd");
//        // 21.2
//        Pattern pattern1 = Pattern.compile("\\Aa");
//        // 21.3
////        Pattern pattern1 = Pattern.compile("\\Aabce"); // нет соответствия

        // 22 - \Z
//        String s1 = "abcd abce abceabcgabch";
//        // 22.1
//        Pattern pattern1 = Pattern.compile("bch\\Z");
//        // 22.2
////        Pattern pattern1 = Pattern.compile("bch!\\Z"); // нет соответствия

        // 23 - [B-Fd-j3-8][B-Fd-j3-8]
        String s1 = "abcd abcd4 afc4ced7";
        Pattern pattern1 = Pattern.compile("[abcd][efgh3-8]");

        Matcher matcher = pattern1.matcher(s1);
        while (matcher.find()) {
            System.out.println("Position: " + matcher.start() + " -> " + matcher.group());
        }
    }
}
