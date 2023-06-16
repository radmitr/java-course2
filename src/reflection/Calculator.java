package reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 6. Reflection. Часть 2 */
    // 4th class
/**
    ------------
     Reflection
    ------------
    Рефлексия - это механизм исследования данных о программе во время её выполнения.
    Рефлексия позволяет исследовать информацию о полях, методах, конструкторах и других составляющих классов.

    Class clazz = Class.forName(“package_name.Class_name”);

    Class clazz = Class_name.class;

    Class_name c = new Class_name();
    Class clazz = c.getClass();

    --------------------
     Reflection methods
    --------------------
    Методы: getField(), getType(), getFields(), getName(), getDeclaredFields(),
            getMethod(), getReturnType(), getParameterTypes(), getMethods(), getDeclaredMethods(),
            isPublic(), getModifiers(),
            getConstructor(), getParameterCount(), getConstructors(),
            newInstance(), invoke(), setAccessible(), get(), set()
*/
public class Calculator {

    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Sum of " + a + " and " + b + " = " + result);
    }

    void subtraction(int a, int b) {
        int result = a - b;
        System.out.println("Subtraction " + a + " and " + b + " = " + result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("Multiplication " + a + " and " + b + " = " + result);
    }

    void division(int a, int b) {
        int result = a / b;
        System.out.println("Division " + a + " and " + b + " = " + result);
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("test100.txt"))) {
            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;

            Method[] methods = cl.getDeclaredMethods(); // "Declared" чтобы не получить все унаследованные методы
            for (Method myMethod : methods) {
                if (myMethod.getName().equals(methodName)) {
                    method = myMethod;
                    break;
                }
            }

            method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
