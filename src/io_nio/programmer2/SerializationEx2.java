package io_nio.programmer2;

import io_nio.programmer1.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 7. Сериализация. Часть 1 */
    // 5th class
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
        Employee bestEmployee;
        // 2
        Employee newBestEmployee;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees2.bin"));
             ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream("employees3.bin"))) {
            // 1
            bestEmployee = (Employee) inputStream.readObject();
            System.out.println(bestEmployee);
            // 2
            newBestEmployee = (Employee) inputStream2.readObject();
            System.out.println(newBestEmployee);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
