package comparation;

import java.util.*;

/* ------------------- 2. Интерфейсы Comparable и Comparator --------------------- */
/* 1. Интерфейс Comparable */
    // 2nd class
/* 2. Интерфейс Comparator */
/**
    -------------------------
     Comparable & Comparator
    -------------------------
    Интерфейс Comparable используется для сравнения объектов, используя естественный порядок
        int compareTo(Element e)

    Интерфейс Comparator используется для сравнения объектов, используя НЕ естественный порядок
        int compare(Element e1, Element e2)
*/
public class Test2 {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        Employee employee4 = new Employee(123, "Zaur", "Tregulov", 100000);
        Employee employee2 = new Employee(15, "Ivan", "Petrov", 6542);
        Employee employee3 = new Employee(123, "Ivan", "Sidorov", 8542);
        Employee employee1 = new Employee(100, "Dmitriy", "Radionov", 12345);

//        Arrays.sort(new Employee[] {employee1, employee2, employee3}); // java.lang.ClassCastException

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        System.out.println("Before sorting \n" + list);

        /* --- 1. Интерфейс Comparable --- */
//        Collections.sort(list); // не пропустит на уровне компиляции

        /* --- 2. Интерфейс Comparator --- */
        // 1 - сортировка по id
//        Collections.sort(list, new IdComparator());
        // 2 - сортировка по name
//        Collections.sort(list, new NameComparator());
        // 3 - сортировка по salary
//        Collections.sort(list, new SalaryComparator());
        // 4 - естественная сортировка (по id)
        Collections.sort(list);

        System.out.println("After sorting \n" + list);
    }
}

/* --- 1. Интерфейс Comparable --- */
//------------------------------------------------------------------------
//class Employee
//        implements Comparable<Employee>
//{
//    // 1 // 2 // 4 // 5
//    int id;
//    // 3
////    Integer id;
//    String name;
//    String surname;
//    int salary;
//
//    public Employee(int id, String name, String surname, int salary) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.salary = salary;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
//
//    @Override
//    public int compareTo(Employee anotherEmployee) {
//        // 1 - сортировка по id (int)
////        if (this.id == anotherEmployee.id) {
////            return 0;
////        } else if (this.id < anotherEmployee.id) {
////            return -1;
////        } else {
////            return 1;
////        }
//        // 2 - сортировка по id (int)
////        return this.id - anotherEmployee.id; // most popular
//        // 3 - сортировка по id (Integer)
////        return this.id.compareTo(anotherEmployee.id); // for Integer
//        // 4 - сортировка по name (String)
////        return this.name.compareTo(anotherEmployee.name); // for String
//        // 5 - сортировка по name и surname (String)
//        int result = this.name.compareTo(anotherEmployee.name);
//        if (result == 0) {
//            result = this.surname.compareTo(anotherEmployee.surname);
//        }
//        return result;
//    }
//}
//------------------------------------------------------------------------

/* --- 2. Интерфейс Comparator --- */
//------------------------------------------------------------------------
class Employee
        implements Comparable<Employee>
{
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
    @Override
    public int compareTo(Employee anotherEmployee) {
        if (this.id == anotherEmployee.id) {
            return 0;
        } else if (this.id < anotherEmployee.id) {
            return -1;
        } else {
            return 1;
        }
    }
}

class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        if (employee1.id == employee2.id) {
            return 0;
        } else if (employee1.id < employee2.id) {
            return -1;
        } else {
            return 1;
        }
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.name.compareTo(employee2.name);
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.salary - employee2.salary;
    }
}
//------------------------------------------------------------------------
