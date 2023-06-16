package io_nio.programmer1;

import java.io.Serializable;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 7. Сериализация. Часть 1 */
    // 3rd class
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
public class Employee implements Serializable {

    // String implements java.io.Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc
    String name;
    String department;
    int age;
    double salary;
    Car car = null;

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, String department, int age, double salary, Car car) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        if (car == null) {
            return "Employees{" +
                    "name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        } else {
            return "Employees{" +
                    "name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", car=" + car +
                    '}';
        }
    }
}
