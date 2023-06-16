package io_nio;

import java.io.*;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 2. FileReader */
/* 3. Try with resources */
    // 2nd class
/**
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
public class FileReaderEx {

    public static void main(String[] args) throws IOException {
        // FileReader extends InputStreamReader extends Reader implements Readable, Closeable;
        // Closeable extends AutoCloseable

        // 1 - try-catch-finally with close()
        FileReader reader = null;
        try {
            reader = new FileReader("test2.txt");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char)character);
            }
            System.out.println("");
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        // 2 - try with resources
        // FileReader extends AutoCloseable
        // 2.1 - try-catch
//        try (FileReader reader2 = new FileReader("test2.txt");
//             FileWriter writer = new FileWriter("test2.txt", true)) {
//            int character;
//            while ((character = reader2.read()) != -1) {
//                System.out.print((char)character);
//            }
//            System.out.println("");
//            System.out.println("Done!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 2.2 - only try
        try (FileReader reader2 = new FileReader("test2.txt");
             FileWriter writer = new FileWriter("test2.txt", true)) {
            int character;
            while ((character = reader2.read()) != -1) {
                System.out.print((char)character);
            }
            System.out.println("");
            System.out.println("Done!");
        }
        // 2.3 - maybe so: try-catch-finally
//        try (FileReader reader2 = new FileReader("test2.txt");
//             FileWriter writer = new FileWriter("test2.txt", true)) {
//            int character;
//            while ((character = reader2.read()) != -1) {
//                System.out.print((char)character);
//            }
//            System.out.println("");
//            System.out.println("Done!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("");
//        }
    }
}
