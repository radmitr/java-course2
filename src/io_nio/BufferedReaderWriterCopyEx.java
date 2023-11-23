package io_nio;

import java.io.*;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 4. BufferedWriter и BufferedReader */
/* 5. FileInputStream и FileOutputStream (error) */
    // 1st class
/**
    ---------------------------------
     BufferedReader & BufferedWriter
    ---------------------------------
    Использование буферизации в стримах позволяет достичь большей эффективности при чтении файла или записи в него.

    BufferedWriter writer = new BufferedWriter(new FileWriter(“file1.txt”));
    BufferedReader reader = new BufferedReader(new FileReader(“file1.txt”));

    -----------------------------------
     FileInputStream & FileOutputStream
    -----------------------------------
    FileInputStream и FileOutputStream используются для работы с бинарными файлами.

    FileInputStream inputStream = new FileInputStream(“test2.bin”);
    FileOutputStream outputStream = new FileOutputStream(“test2.bin”);
*/
public class BufferedReaderWriterCopyEx {

    public static void main(String[] args) {
        // BufferedReader extends Reader implements Readable, Closeable; Closeable extends AutoCloseable
        // FileReader extends InputStreamReader extends Reader implements Readable, Closeable

        // BufferedWriter extends Writer implements Appendable, Closeable, Flushable; Closeable extends AutoCloseable
        // FileWriter extends OutputStreamWriter extends Writer implements Appendable, Closeable, Flushable

        // 1 - Ok for text files
        try (BufferedReader reader = new BufferedReader(new FileReader("test2.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("test3.txt"))) {
            // 1 - read(), write(int c)
//            int character;
//            while ((character = reader.read()) != -1) {
//                writer.write(character);
//            }
//            System.out.println("Done!");
            // 2 - readLine(), write(String str)
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
//                writer.write("\n");
                writer.newLine();
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 2 - Error for binary files with stream fot text (Reader and Writer)
//        try (BufferedReader reader = new BufferedReader(new FileReader("java_picture.jpg"));
//             BufferedWriter writer = new BufferedWriter(new FileWriter("test/java_picture_error.jpg"))) {
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.newLine();
//            }
//            System.out.println("Done!");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
