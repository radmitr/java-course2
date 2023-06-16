package io_nio.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 7. Сериализация. Часть 1 */
    // 4th class
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
public class SerializationEx2 {

    public static void main(String[] args) {
        // 1
        Employee employee = new Employee("Mariya", "IT", 28, 500);
        // 2
        Car car = new Car("Toyota FJ Cruiser", "Quicksand");
        Employee employee2 = new Employee("Dmitriy", "IT", 38, 2000, car);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees2.bin"));
             ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream("employees3.bin"))) {
            // 1
            // java.io.NotSerializableException if Employee not implements Serializable
            outputStream.writeObject(employee);
            System.out.println("Done!");
            // 2
            // java.io.NotSerializableException if Car in Employee not implements Serializable
            outputStream2.writeObject(employee2);
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
