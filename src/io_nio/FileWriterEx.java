package io_nio;

import java.io.*;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 1. Введение в Стримы. FileWriter */
/* 3. Try with resources */
    // 1st class
/**
    ------------------------------------
     Character Streams and Byte Streams
    ------------------------------------
    Stream (поток) для работы с файлами – это упорядоченная последовательность данных

    Файлы разделяют на:
        • читабельные для человека – text files;
        • нечитабельные для человека – binary files.

    При работе с текстовыми и бинарными файлами нам необходимо использовать разные типы стримов.

    ------------------------
     FileReader & FileWriter
    ------------------------
    FileReader и FileWriter используются для работы с текстовыми файлами.

    FileWriter writer = new FileWriter(“file1.txt”);
    FileReader reader= new FileReader(“file1.txt”);

    Никогда не забывайте закрывать стримыпосле использования.

    --------------------
     Try with resources
    --------------------
    try(FileWriter writer = new FileWriter(“file1.txt”);
        FileReader reader = new FileReader(“file1.txt”);) {

        //SOME CODE…
    }
    Ресурс, который используется в Try with resources должен имплементировать интерфейс AutoCloseable
*/
public class FileWriterEx {

    public static void main(String[] args) throws IOException {
        // FileWriter extends OutputStreamWriter extends Writer implements Appendable, Closeable, Flushable;
        // Closeable extends AutoCloseable

        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего не известно! —\n" +
                "Вот последняя правда, открытая мной.\n" +
                "                              Омар Хайям";
        String s = "privet";

        // public FileWriter(String fileName)
        // public FileWriter(String fileName, boolean append)
        // public FileWriter(File file)

        // 1 - test1.txt
        FileWriter writer = null;
        try {
            writer = new FileWriter("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                    "\\java-course2\\test1.txt");
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

        // 2 - test2.txt
        // 2.1 - write(int c)
//        FileWriter writer2 = null;
//        try {
//            writer2 = new FileWriter("test2.txt");
//            for (int i = 0; i < rubai.length(); i++) {
//                writer2.write(rubai.charAt(i)); // auto cast to int
//            }
//            System.out.println("Done!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            writer2.close();
//        }
        // 2.2 - write(String str)
//        FileWriter writer2 = null;
//        try {
//            writer2 = new FileWriter("test2.txt");
//            writer2.write(rubai); // не смотря на String, всё равно посимвольно обращение к файлу
//            System.out.println("Done!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            writer2.close();
//        }
        // 2.3 - overwrite
//        FileWriter writer2 = null;
//        try {
//            writer2 = new FileWriter("test2.txt");
//            writer2.write(s);
//            System.out.println("Done!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            writer2.close();
//        }
        // 2.4 - append true
//        FileWriter writer2 = null;
//        try {
//            writer2 = new FileWriter("test2.txt", true);
//            writer2.write("\n" + s);
//            System.out.println("Done!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            writer2.close();
//        }

        // 3 - try with resources
        // FileWriter extends AutoCloseable
        try (FileWriter writer3 = new FileWriter("test2.txt", true)) {
            writer3.write(rubai);
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
