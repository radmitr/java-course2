package io_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 15. Интерфейс Path и класс Files. Часть 2 */
    // 2nd class
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
public class PathAndFilesEx3 {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test10_new.txt");

        // 1 - write()
//        Files.createFile(filePath);
//        String dialog = "-Privet\n-Privet\n-Kak dela?\n-Horosho! Kak u tebya?\n-Toje horosho!";
//        Files.write(filePath, dialog.getBytes());

        // 2 - readAllLines()
        List<String> list =  Files.readAllLines(filePath);
        for (String str: list) {
            System.out.println(str);
        }
    }
}
