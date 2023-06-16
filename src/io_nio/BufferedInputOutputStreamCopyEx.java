package io_nio;

import java.io.*;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 5. FileInputStream и FileOutputStream (continue) */
    // 3rd class
/**
    -----------------------------------
     FileInputStream& FileOutputStream
    -----------------------------------
    FileInputStream и FileOutputStream используются для работы с бинарными файлами.

    FileInputStream inputStream = new FileInputStream(“test2.bin”);
    FileOutputStream outputStream = new FileOutputStream(“test2.bin”);
*/
public class BufferedInputOutputStreamCopyEx {

    public static void main(String[] args) {
        // BufferedInputStream extends FilterInputStream extends InputStream implements Closeable extends AutoCloseable
        // BufferedOutputStream extends FilterOutputStream extends OutputStream implements Closeable, Flushable;
        // Closeable extends AutoCloseable

        try (var inputStream = new BufferedInputStream(new FileInputStream("java_picture.jpg"));
             var outputStream = new BufferedOutputStream(new FileOutputStream("test/java_picture_new.jpg"))) {

            byte[] array = new byte[100];
            int n;
            while ((n = inputStream.read(array)) != -1) {
                outputStream.write(array, 0, n);
            }
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
