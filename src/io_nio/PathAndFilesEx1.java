package io_nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 14. Интерфейс Path и класс Files. Часть 1 */
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
public class PathAndFilesEx1 {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("D:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\M");

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("--------------------------------- Path --------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");

        // 1 - getFileName()
        System.out.println("filePath.getFileName() -> " + filePath.getFileName());
        System.out.println("directoryPath.getFileName() -> " + directoryPath.getFileName());
        System.out.println("--------------------------------------------");

        // 2 - getParent()
        System.out.println("filePath.getParent() -> " + filePath.getParent());
        System.out.println("directoryPath.getParent() -> " + directoryPath.getParent());
        System.out.println("--------------------------------------------");

        // 3 - getRoot()
        System.out.println("filePath.getRoot() -> " + filePath.getRoot());
        System.out.println("directoryPath.getRoot() -> " + directoryPath.getRoot());
        System.out.println("--------------------------------------------");

        // 4 - isAbsolute()
        System.out.println("filePath.isAbsolute() -> " + filePath.isAbsolute());
        System.out.println("directoryPath.isAbsolute() -> " + directoryPath.isAbsolute());
        System.out.println("--------------------------------------------");

        // 5 - toAbsolutePath()
        System.out.println("filePath.toAbsolutePath() -> " + filePath.toAbsolutePath());
        System.out.println("directoryPath.toAbsolutePath() -> " + directoryPath.toAbsolutePath());
        System.out.println("--------------------------------------------");

        // 6 - toAbsolutePath().getParent(), toAbsolutePath().getRoot()
        System.out.println("filePath.toAbsolutePath().getParent() -> " + filePath.toAbsolutePath().getParent());
        System.out.println("filePath.toAbsolutePath().getRoot() -> " + filePath.toAbsolutePath().getRoot());
        System.out.println("--------------------------------------------");

        // 7 - resolve()
        System.out.println("directoryPath.resolve(filePath) -> " + directoryPath.resolve(filePath));
        System.out.println("--------------------------------------------");

        // 8 - relativize()
        Path anotherPath = Paths.get("D:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test\\M\\N\\Z\\test20.txt");
        System.out.println("directoryPath.relativize(anotherPath) -> " + directoryPath.relativize(anotherPath));

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("--------------------------------- Files -------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");

        // 1 create
        // 1.1 - createFile()
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
            System.out.println("Files.createFile(filePath) -> " + "Done!");
        }
        else {
            System.out.println("Files.createFile(filePath) -> " + "File already exists!");
        }
        // 1.2 - createDirectory
        if (!Files.exists(directoryPath)) {
            Files.createDirectory(directoryPath);
            System.out.println("Files.createDirectory(directoryPath) -> " + "Done!");
        } else {
            System.out.println("Files.createDirectory(directoryPath) -> " + "Directory already exists!");
        }
        System.out.println("--------------------------------------------");

        // 2 - isReadable(), isWritable(), isExecutable()
        System.out.println("Files.isReadable(filePath) -> " + Files.isReadable(filePath));
        System.out.println("Files.isWritable(filePath) -> " + Files.isWritable(filePath));
        System.out.println("Files.isExecutable(filePath) -> " + Files.isExecutable(filePath));
        System.out.println("--------------------------------------------");

        // 3 - isSameFile()
        Path filePath2 = Paths.get("D:\\Code\\JAVA_PRJ\\radmitr\\zaur_tregulov_courses" +
                "\\java-course2\\test15.txt");
        System.out.println("Files.isSameFile(filePath, filePath2) -> " + Files.isSameFile(filePath, filePath2));
        System.out.println("--------------------------------------------");

        // 4 - size()
        System.out.println("Files.size(filePath) -> " + Files.size(filePath));
        System.out.println("--------------------------------------------");

        // 5 - getAttribute()
        System.out.println("Files.getAttribute(filePath, \"creationTime\") -> " +
                Files.getAttribute(filePath, "creationTime"));
        System.out.println("Files.getAttribute(filePath, \"size\") -> "
                + Files.getAttribute(filePath, "size"));
        System.out.println("--------------------------------------------");

        // 6 - readAttributes()
        Map<String, Object> attributes = Files.readAttributes(filePath, "*");
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("--------------------------------------------");
    }
}
