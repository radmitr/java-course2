package io_nio;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 10. Класс File */
/**
    ------------
     Класс File
    ------------
    Класс File позволяет управлять информацией о файлах и директориях.
    File file = new File (“test1.txt”);

    Методы: getAbsolutePath(), isAbsolute(), isDirectory(), exists(), createNewFile(), mkdir(),
            length(), delete(), listFiles(), isHidden(), canRead(), canWrite(), canExecute().
*/
public class FileEx {

    public static void main(String[] args) throws IOException {
        File file = new File("test2.txt");
        File folder = new File("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\A");
        File file2 = new File("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\A\\test20.txt");
        File file3 = new File("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\A\\test2.txt");
        File folder2 = new File("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\B");

        // 1 - getAbsolutePath()
        System.out.println("file.getAbsolutePath() -> " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath() -> " + folder.getAbsolutePath());
        System.out.println("--------------------------------------------");

        // 2 - isAbsolute()
        System.out.println("file.isAbsolute() -> " + file.isAbsolute());
        System.out.println("folder.isAbsolute() -> " + folder.isAbsolute());
        System.out.println("--------------------------------------------");

        // 3 - isDirectory()
        System.out.println("file.isDirectory() -> " + file.isDirectory());
        System.out.println("folder.isDirectory() -> " + folder.isDirectory());
        System.out.println("--------------------------------------------");

        // 4 - exists()
        System.out.println("file.exists() -> " + file.exists());
        System.out.println("folder.exists() -> " + folder.exists());
        System.out.println("file2.exists() -> " + file2.exists());
        System.out.println("folder2.exists() -> " + folder2.exists());
        System.out.println("--------------------------------------------");

        // 5 - createNewFile(), mkdir()
        System.out.println("file2.createNewFile() -> " + file2.createNewFile());
        System.out.println("folder2.mkdir() -> " + folder2.mkdir());
        System.out.println("file.createNewFile() -> " + file.createNewFile());
        System.out.println("--------------------------------------------");

        // 6 - length()
        System.out.println("file2.length() -> " + file2.length()); // >> file2.length() -> 6
        System.out.println("folder2.length() -> " + folder2.length()); // >> folder2.length() -> 0 !!!!!!!!!!!!!!!!!!!!
        System.out.println("--------------------------------------------");

        // 7 - delete()
        System.out.println("folder.delete() -> " + folder.delete()); // A
        System.out.println("folder2.delete() -> " + folder2.delete()); // B
        System.out.println("file2.delete() -> " + file2.delete()); // A\test20.txt
        System.out.println("--------------------------------------------");

        // 8 - listFiles()
        File[] files = folder.listFiles();
        System.out.println(Arrays.toString(files));
        System.out.println("--------------------------------------------");

        // 9 - isHidden(), canRead(), canWrite(), canExecute()
        System.out.println("file3.isHidden() -> " + file3.isHidden());
        System.out.println("file3.canRead() -> " + file3.canRead());
        System.out.println("file3.canWrite() -> " + file3.canWrite());
        System.out.println("file3.canExecute() -> " + file3.canExecute());
        System.out.println("--------------------------------------------");
    }
}
