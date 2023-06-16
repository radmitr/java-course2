package io_nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 9. Класс RandomAccessFile */
/**
    ------------------
     RandomAccessFile
    ------------------
    Класс RandomAccessFile позволяет читать информацию из любого места файла и записывать информацию
    в любое место файла.

    RandomAccessFile file = new RandomAccessFile(“test1.txt”, “rw”);
*/
public class RandomAccessFileEx {

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("test10.txt", "rw")) {
            // Had I the heavens' embroidered cloths,
            // Enwrought with golden and silver light,
            // The blue and the dim and the dark cloths
            // Of night and light and the half light,
            // I would spread the cloths under your feet:
            // But I, being poor, have only my dreams;
            // I have spread my dreams under your feet;
            // Tread softly because you tread on my dreams.

            // 1 - read(), readLine()
            int a = file.read(); // read one byte from the file (increment file-pointer: 0 + 1 = 1)
            System.out.println((char)a); // >> "H"
            // read the next line of the text from this file (update file-pointer: 1 + 39 = 40)
            String s1 = file.readLine();
            System.out.println(s1); // >> "ad I the heavens' embroidered cloths,"

            // 2 - seek()
            file.seek(101); // set the file-pointer offset (set file-pointer: 101)
            // read remaining characters of a line (add to current file-pointer: 101 + 22 = 123)
            String s2 = file.readLine();
            System.out.println(s2); // >> " and the dark cloths"

            // 3 - getFilePointer()
            long position = file.getFilePointer(); // get the file-pointer offset
            System.out.println(position); // >> "123"

            // 4 - writeBytes()
            // 4.1
//            file.seek(0); // set the file-pointer offset to the start (set file-pointer: 0)
//            file.writeBytes("hello"); // delete the beginning of the poem

            // 4.2
////            file.seek(file.length() - 1); // erase dot
//            file.seek(file.length()); // set the file-pointer offset to the end
//            System.out.println(file.getFilePointer());
//            file.writeBytes("\n\t\t\t\t\tWilliam Butler Yeats");

            // Had I the heavens' embroidered cloths,
            // Enwrought with golden and silver light,
            // The blue and the dim and the dark cloths
            // Of night and light and the half light,
            // I would spread the cloths under your feet:
            // But I, being poor, have only my dreams;
            // I have spread my dreams under your feet;
            // Tread softly because you tread on my dreams.
            //                        William Butler Yeats

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
