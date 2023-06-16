package io_nio;

import java.io.*;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 5. FileInputStream и FileOutputStream */
    // 2nd class
/**
    -----------------------------------
     FileInputStream& FileOutputStream
    -----------------------------------
    FileInputStream и FileOutputStream используются для работы с бинарными файлами.

    FileInputStream inputStream = new FileInputStream(“test2.bin”);
    FileOutputStream outputStream = new FileOutputStream(“test2.bin”);
*/
public class FileInputOutputStreamCopyEx {

    public static void main(String[] args) {
        // FileInputStream extends InputStream implements Closeable extends AutoCloseable
        // FileOutputStream extends OutputStream implements Closeable, Flushable; Closeable extends AutoCloseable

        try (FileInputStream inputStream = new FileInputStream("java_picture.jpg");
             FileOutputStream outputStream = new FileOutputStream("test/java_picture.jpg")) {

            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
