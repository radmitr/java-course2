package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 5. Reflection. Часть 1 */
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
public class Ex1 {

    // - getField(), getType(), getFields(), getName(), getDeclaredFields(),
    // - getMethod(), getReturnType(), getParameterTypes(), getMethods(), getDeclaredMethods()
        // Modifier.isPublic(), getModifiers()
    // - getConstructor(), getParameterCount(), getParameterTypes(), getConstructors(), getDeclaredConstructors()
        // Modifier.isPublic(), getModifiers()
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchFieldException, NoSuchMethodException {
        // First variant
        Class employeeClass = Class.forName("reflection.Employee");
        // Second variant
        Class employeeClass2 = Employee.class;
        // Third variant
        Employee emp = new Employee();
        Class employeeClass3 = emp.getClass();

        // -------------------- Fields --------------------

        // 1 - getField(), getType()
        Field someField = employeeClass.getField("id");
        System.out.println("Type of \"id\" field: " + someField.getType());
        System.out.println("*****");

        // 2 - getFields(), getName()
        Field[] fields = employeeClass.getFields();
        for (Field field : fields) {
            System.out.println("Type of \"" + field.getName() + "\" = " + field.getType());
        }
        System.out.println("*****");

        // 3 - getDeclaredFields()
        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println("Type of \"" + field.getName() + "\" = " + field.getType());
        }
        System.out.println("----------------------------------------------");

        // -------------------- Methods --------------------

        // 4 - getMethod(), getReturnType(), getParameterTypes()
        // 4.1
        Method someMethod1 = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method \"increaseSalary\" = " + someMethod1.getReturnType() +
                ", parameter types = " + Arrays.toString(someMethod1.getParameterTypes()));
        System.out.println("*****");
        // 4.2
        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method \"setSalary\" = " + someMethod2.getReturnType() +
                ", parameter types = " + Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("*****");

        // 5 - getMethods()
        Method[] methods = employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println("Name of method = " + method.getName() +
                    ", return type = " + method.getReturnType() +
                    ", parameter types = " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("*****");

        // 6 - getDeclaredMethods()
        // 6.1
        Method[] allMethods = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println("Name of method = " + method.getName() +
                    ", return type = " + method.getReturnType() +
                    ", parameter types = " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("*****");
        // 6.2 - Modifier.isPublic(), getModifiers()
        Method[] allMethods2 = employeeClass.getDeclaredMethods();
        for (Method method : allMethods2) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println("Name of method = " + method.getName() +
                        ", return type = " + method.getReturnType() +
                        ", parameter types = " + Arrays.toString(method.getParameterTypes()));
            }
        }
        System.out.println("----------------------------------------------");

        // -------------------- Constructors --------------------

        // 7 - getConstructor(), getParameterCount(), getParameterTypes()
        // 7.1
        Constructor constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor has " + constructor1.getParameterCount() + " parameters, " +
                "their types are: " + Arrays.toString(constructor1.getParameterTypes()));
        System.out.println("*****");
        // 7.2 - getConstructor(Class<?>... parameterTypes)
        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("Constructor has " + constructor2.getParameterCount() + " parameters, " +
                "their types are: " + Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("*****");

        // 8 - getConstructors()
        Constructor[] constructors = employeeClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor " + constructor.getName() +
                    " has " + constructor.getParameterCount() + " parameters, " +
                    "their types are: " + Arrays.toString(constructor.getParameterTypes()));
        }
        System.out.println("*****");

        // 9 - getDeclaredConstructors()
        Constructor[] constructors2 = employeeClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (Modifier.isPublic(constructor.getModifiers())) {
                System.out.println("Constructor " + constructor.getName() +
                        " has " + constructor.getParameterCount() + " parameters, " +
                        "their types are: " + Arrays.toString(constructor.getParameterTypes()));
            }
        }
    }
}
