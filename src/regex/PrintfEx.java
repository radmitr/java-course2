package regex;

/* ------------------------ 10. Регулярные выражения ----------------------------- */
/* 7. Методы printf и format */
/**
    ------------------------
     Методы printf и format
    ------------------------

    %[flags][width][.precision]datatype_specifier

                flags                    |        DT specifiers
    «-» выравнивание по левому краю      |  «b» boolean
    «0» добавление нулей перед числом    |  «c» character
    «,» разделитель разрядов в числах    |  «s» String
                                         |  «d» целое число
                                         |  «f» десятичное число
*/
public class PrintfEx {

    // printf()
    static void employeeInfo(Employee emp) {
        // 1
//        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n", emp.id, emp.name, emp.surname,
//                emp.salary * (1 + emp.bonusPct));
        // 2
//        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n", emp.id, emp.name, emp.surname,
//                emp.name); // java.util.IllegalFormatConversionException
        // 3
        System.out.printf("%03d \t Hello %-12s \t %-12s \t %,.1f \n", emp.id, emp.name, emp.surname,
                emp.salary * (1 + emp.bonusPct));
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Dmitriy", "Radionov", 12345, 0.15);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542, 0.08);
        Employee emp3 = new Employee(123, "Mariya", "Sidorova", 8542, 0.12);

        // 1 - printf()
        employeeInfo(emp1);
        employeeInfo(emp2);
        employeeInfo(emp3);
        System.out.println("-----------------------------------------------------------");

        // 2 - format()
        String newString = String.format("%03d \t Hello %-12s \t %-12s \t %,.1f", emp1.id, emp1.name, emp1.surname,
                emp1.salary * (1 + emp1.bonusPct));
        System.out.println(newString);
    }
}

class Employee {
    int id;
    String name;
    String surname;
    int salary;
    double bonusPct;

    public Employee(int id, String name, String surname, int salary, double bonusPct) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonusPct = bonusPct;
    }
}
