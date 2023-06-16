package io_nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 16. Введение в метод walkFileTree */
/**
    --------------------
     Files.walkFileTree
    --------------------
    Метод Files.walkFileTree(Path start, FileVisitor visitor) используется для обхода дерева файлов.

    Логика обхода дерева файлов заключается в классе, имплементирующем интерфейс FileVisitor.

    preVisitDirectory - срабатывает перед обращением к элементам папки;
    visitFile - срабатывает при обращении к файлу;
    postVisitDirectory - срабатывает после обращения ко всем элементам папки;
    visitFileFailed - срабатывает когда файл по каким-то причинам недоступен.
*/
public class WalkFileTreeEx {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\X");
        Files.walkFileTree(path, new MyFileVisitor());
    }
}

class MyFileVisitor implements FileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to Directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File name: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error while visiting file: " + file.getFileName());
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from Directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    //    public enum FileVisitResult {
    //        CONTINUE,
    //        TERMINATE,
    //        SKIP_SUBTREE,
    //        SKIP_SIBLINGS;
    //    }
}
