package reflection;

import java.lang.reflect.Field;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 6. Reflection. Часть 2 */
    // 3rd class
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
public class Ex3 {

    // getDeclaredField(), setAccessible(), get(), set()
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10, "Dmitriy", "IT");
        Class employeeClass = employee.getClass();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //    For this lesson, you need to comment out the methods in class reflection_examples.Employee:    //
        //      //public Employee(int id, String name, String department, double salary)                     //
        //      //getSalary()                                                                                //
        //      //setSalary(double salary)                                                                   //
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // 0 - getDeclaredField()
        Field field = employeeClass.getDeclaredField("salary");

        // 1 - setAccessible(), get()
        field.setAccessible(true);
        double salaryValue = (double) field.get(employee); // java.lang.IllegalAccessException
        System.out.println(salaryValue);

        // 2 - set()
        field.set(employee, 1500);
        System.out.println(employee);
    }
}
