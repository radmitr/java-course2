package io_nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 17. Метод walkFileTree. Копирование директории */
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
public class WalkFileTreeCopyEx {

    public static void main(String[] args) throws IOException {
        Path source = Paths.get("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\X");
        Path destination = Paths.get("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\CopyHere");

        Files.walkFileTree(source, new MyFileVisitor2(source, destination));
        System.out.println("Done!");
    }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
    Path source;
    Path destination;

    public MyFileVisitor2(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(dir));

//        Files.copy(dir, newDestination); // java.nio.file.FileAlreadyExistsException
//        Files.copy(dir, newDestination,
//                StandardCopyOption.REPLACE_EXISTING); // java.nio.file.DirectoryNotEmptyException
        if (!Files.exists(newDestination)) {
            Files.copy(dir, newDestination);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(file));
//        Files.copy(file, newDestination); // java.nio.file.FileAlreadyExistsException
        Files.copy(file, newDestination, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}
