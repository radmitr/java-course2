package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 6. Reflection. Часть 2 */
    // 2nd class
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
public class Ex2 {

    // newInstance(), getConstructor(), invoke()
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class employeeClass = Class.forName("reflection.Employee");

        // 1 - newInstance() on class [deprecated since java 9]
        // 1.1
        Object obj = employeeClass.newInstance();
        System.out.println(obj);
        // 1.2
        Employee emp = (Employee)employeeClass.newInstance();
        System.out.println(emp);

        // 2 - newInstance() on constructor, getConstructor()
        // 2.1 - Constructor
        Constructor constructor0 = employeeClass.getConstructor();
        Object obj1 = constructor0.newInstance();
        // 2.2 - Constructor<T>
        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Employee emp1 = constructor1.newInstance();
        // 2.3 - getConstructor(Class<?>... parameterTypes)
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        Object obj2 = constructor2.newInstance(5, "Dmitriy", "IT");
        System.out.println(obj2);

        // 3 - invoke()
        Method method = employeeClass.getMethod("setSalary", double.class);
        method.invoke(obj2, 800.88);
        System.out.println(obj2);
    }
}
