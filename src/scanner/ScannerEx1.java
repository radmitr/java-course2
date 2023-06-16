package scanner;

import java.util.Scanner;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 3. Класс Scanner. Часть 1 */
/**
    ---------
     Scanner
    ---------
    Scanner sc = new Scanner(System.in); // работа с консолью

    nextByte()          next()          hasNext()
    nextShort()         nextLine()      hasNextLine()
    nextInt()                           hasNextInt()
    nextLong()                          …………
    nextFloat()                         …………
    nextDouble()                        …………
    nextBoolean()
*/
public class ScannerEx1 {

    // nextInt(), nextLine(), next(), nextDouble(), hasNextLine()
    public static void main(String[] args) {
        // 1 - Scanner(InputStream source)
        Scanner scanner = new Scanner(System.in);

        // 1.1.1 - nextInt()
//        System.out.println("Enter a number:");
//        int i = scanner.nextInt();
//        System.out.println("Entered number: " + i);

        // 1.1.2 - nextInt()
//        System.out.println("Enter two numbers:");
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        System.out.println("quotient = " + x / y);
//        System.out.println("remainder = " + x % y);

        // 1.2.1 - nextLine()
//        System.out.println("Type some words:");
//        String s = scanner.nextLine();
//        System.out.println("You typed: " + s);

        // 1.2.2 - nextLine()
//        System.out.println("Type two strings:");
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
//        System.out.println("You typed the first line: " + s1);
//        System.out.println("You typed the second line: " + s2);

        // 1.3 - next()
//        System.out.println("Type a string:");
//        String s = scanner.next();
//        System.out.println("You typed: " + s);

        // 1.4 - nextDouble()
//        System.out.println("Enter a fractional number:");
//        double i = scanner.nextDouble(); // java.util.InputMismatchException
//        System.out.println("Entered number: " + i);

        // 2 - Scanner(String source)
        // 2.1 - next()
//        scanner = new Scanner("Hello, my friends!");
//        String s = scanner.next();
//        System.out.println(s);

        // 2.2 - Scanner(String source)
        scanner = new Scanner("Hello, my friends!\nHow are you?\nWhat's good about you?");
        // 2.2.1 - nextLine()
//        String s1 = scanner.nextLine();
//        System.out.println(s1);
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine()); // java.util.NoSuchElementException
        // 2.2.2 - hasNextLine(), nextLine()
//        while (scanner.hasNextLine()) {
//            System.out.println(scanner.nextLine());
//        }
        // 2.2.3 - hasNextLine(), nextDouble()
//        while (scanner.hasNextLine()) {
//            System.out.println(scanner.nextDouble()); // java.util.InputMismatchException
//        }
        // 2.2.4
        System.out.println(scanner.next().charAt(4));

        scanner.close();
    }
}
