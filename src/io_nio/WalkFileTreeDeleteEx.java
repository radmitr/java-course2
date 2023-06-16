package io_nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 18. Метод walkFileTree. Удаление директории */
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
public class WalkFileTreeDeleteEx {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\CopyHere");

        Files.walkFileTree(path, new MyFileVisitor3());
        System.out.println("Done!");
    }
}

class MyFileVisitor3 extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Delete file: " + file.getFileName()); // java.nio.file.NoSuchFileException
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        Objects.requireNonNull(file);
        System.err.println("Error! Not delete: " + file.getFileName());
//        exc.printStackTrace(); // java.nio.file.NoSuchFileException
//        return FileVisitResult.TERMINATE;
        throw exc;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Delete directory: " + dir.getFileName()); // java.nio.file.NoSuchFileException
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}
