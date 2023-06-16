package io_nio.programmer2;

import io_nio.programmer1.Employee2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/* ------------------------ 9. Работа с файлами IO и NIO ------------------------- */
/* 8. Сериализация. Часть 2 */
    // 2nd class
public class SerializationEx3 {

    public static void main(String[] args) {
        // 1
        Employee2 bestEmployee;
        // 2
        Employee2 newBestEmployee;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees4.bin"));
             ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream("employees5.bin"))) {
            // 1
            bestEmployee = (Employee2) inputStream.readObject(); // java.io.InvalidClassException
            System.out.println(bestEmployee);
            // 2
            newBestEmployee = (Employee2) inputStream2.readObject(); // java.io.InvalidClassException
            System.out.println(newBestEmployee);
            // stream classdesc serialVersionUID = 5891128687900215584,
            // local class serialVersionUID = -7181475595044888436;
            // stream classdesc serialVersionUID = 2,
            // local class serialVersionUID = 1;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
