package io_nio.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 7. Сериализация. Часть 1 */
    // 1st class
/**
    ---------------
     Serialization
    ---------------
    Сериализация-это процесс преобразования объекта в последовательность байт.
    Десериализация-это процесс восстановления объекта, из этих байт.

    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(“test2.bin”));
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(“test2.bin”));

    Для того, чтобы объект класса можно было сериализировать, класс должен имплементировать интерфейс Serializable.
    Поля класса, помеченные ключевым словом transient, не записываются в файл при сериализации.
    В сериализируемом классе необходимо использовать serialVersionUID для обозначения версии класса.
*/
public class SerializationEx1 {

    public static void main(String[] args) {
        // ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants;
        // ObjectOutput extends DataOutput, AutoCloseable
        // ArrayList implements Serializable

        List<String> employee = new ArrayList<>();
        employee.add("Vladimir");
        employee.add("Natalya");
        employee.add("Dmitriy");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees1.bin"))) {
            outputStream.writeObject(employee);
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
