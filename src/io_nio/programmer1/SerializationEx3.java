package io_nio.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 8. Сериализация. Часть 2 */
    // 1st class
public class SerializationEx3 {

    public static void main(String[] args) {
        // 1 - old variant
        // --------------------------------------------------------------
//        // 1
//        Employee2 employee = new Employee2("Mariya",
////                "Ivanova",
//                "IT",
//                28,
//                500);
//        // 2
//        Car car = new Car("Toyota FJ Cruiser", "Quicksand");
//        Employee2 employee2 = new Employee2("Dmitriy",
////                "Radionov",
//                "IT",
//                38,
//                2000,
//                car);
//
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees4.bin"));
//             ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream("employees5.bin"))) {
//            // 1
//            // java.io.NotSerializableException if Employee not implements Serializable
//            outputStream.writeObject(employee);
//            System.out.println("Done!");
//            // 2
//            // java.io.NotSerializableException if Car in Employee not implements Serializable
//            outputStream2.writeObject(employee2);
//            System.out.println("Done!");
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        // --------------------------------------------------------------

        // 2 - new variant
        // --------------------------------------------------------------
        // 1
        Employee2 employee = new Employee2("Mariya",
                "Ivanova",
                "IT",
//                28,
                500);
        // 2
        Car car = new Car("Toyota FJ Cruiser", "Quicksand");
        Employee2 employee2 = new Employee2("Dmitriy",
                "Radionov",
                "IT",
//                38,
                2000,
                car);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees4.bin"));
             ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream("employees5.bin"))) {
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
        // --------------------------------------------------------------
    } // End main()
}
