package io_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 15. Интерфейс Path и класс Files. Часть 2 */
    // 1st class
/**
    ------------------------------
     Interface Path & class Files
    ------------------------------
    Объект типа Path представляет собой путь к файлу или директории.

    Path path = Paths.get(“text1.txt”);

    Методы: path.getFileName(), path.getParent(), path.getRoot(),  path.isAbsolute(),
            path.toAbsolutePath(), path1.resolve(path2), path1.relativize(path2);

            Files.exists(path), Files.createFile(path), Files.createDirectory(path),
            Files.isReadable(), Files.isWritable(), Files.isExecutable(),
            Files.isSameFile(path1, path2), Files.size(), Files.getAttribute(path, attribute_name),
            Files.readAttributes(path, attributes);

            Files.copy(path1, path2, copy_options), Files.move(path1, path2, copy_options),
            Files.delete(path), Files.write(path, byte_array), Files.readAllLines(path).
*/
public class PathAndFilesEx2 {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("D:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\M");

        // 1 - copy()
//        // 1.1 - copy the file to the directory
////        Files.copy(filePath, directoryPath.resolve(filePath));
////        Files.copy(filePath, directoryPath.resolve(filePath)); // java.nio.file.FileAlreadyExistsException
//        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
////        Files.copy(filePath, directoryPath.resolve("test16.txt"));
//        System.out.println("Copy the file to the directory: " + "Done!");
        // 1.2 - copy the folder to the directory
//        Path directoryPath2 = Paths.get("d:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
//                "\\java-course2\\test\\B");
//        Files.copy(directoryPath2, directoryPath.resolve("B"));
////        Files.copy(directoryPath2, directoryPath.resolve(directoryPath2.getFileName()));
//        System.out.println("Copy the folder to the directory: " + "Done!");

        // 2 - move()
////        Files.move(filePath, directoryPath.resolve("test15_new.txt"));
//        Files.move(filePath, directoryPath.resolve("test15_new.txt")); // java.nio.file.NoSuchFileException
//        // Класс Files не имеет метода rename(), необходимо использовать move()

        // 3 -delete()
//        Files.delete(Paths.get("test5.txt"));
        Files.delete(directoryPath); // java.nio.file.DirectoryNotEmptyException
    }
}
