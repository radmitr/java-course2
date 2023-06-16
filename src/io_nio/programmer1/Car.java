package io_nio.programmer1;

import java.io.Serializable;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 7. Сериализация. Часть 1 */
    // 6th class
/* 8. Сериализация. Часть 2 */
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
public class Car implements Serializable {

    String model;
    String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
