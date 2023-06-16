package collection.list_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 9. Binary search */
public class BinarySearch {

    public static void main(String[] args) {
        // 1 - Collections.binarySearch()
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(-3);
//        arrayList.add(8);
//        arrayList.add(12);
//        arrayList.add(-8);
//        arrayList.add(0);
//        arrayList.add(5);
//        arrayList.add(10);
//        arrayList.add(1);
//        arrayList.add(150);
//        arrayList.add(-30);
//        arrayList.add(19);
//
//        // 1.1
//        int index = Collections.binarySearch(arrayList, 12);
//        System.out.println(index); // >> -9 (не найден)
//        // 1.2
//        Collections.sort(arrayList);
//        index = Collections.binarySearch(arrayList, 12);
//        System.out.println(index); // >> 8
//        // 1.3
//        index = Collections.binarySearch(arrayList, 100);
//        System.out.println(index); // >> -11 (не найден)

        // 2 - Collections.binarySearch()
//        Employee emp1 = new Employee(100, "Dmitriy", 12345);
//        Employee emp2 = new Employee(15, "Ivan", 6542);
//        Employee emp3 = new Employee(123, "Petr", 8542);
//        Employee emp4 = new Employee(15, "Mariya", 5678);
//        Employee emp5 = new Employee(182, "Kolya", 125);
//        Employee emp6 = new Employee(15, "Sasha", 9874);
//        Employee emp7 = new Employee(250, "Elena", 1579);
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(emp1);
//        employeeList.add(emp2);
//        employeeList.add(emp3);
//        employeeList.add(emp4);
//        employeeList.add(emp5);
//        employeeList.add(emp6);
//        employeeList.add(emp7);
//        System.out.println(employeeList);
//
//        Collections.sort(employeeList);
//        System.out.println(employeeList);
//
//        int index2 = Collections.binarySearch(employeeList, new Employee(182, "Kolya", 125));
//        System.out.println(index2);

        // 3 - Arrays.binarySearch()
//        int[] array = {-3, 8, 12, -8, 0, 5, 10, 1, 150, -30, 19};
//        System.out.println(Arrays.toString(array));
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        int index3 = Arrays.binarySearch(array, 150);
//        System.out.println(index3);

        // 4
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-3);
        arrayList.add(8);
        arrayList.add(12);
        arrayList.add(-8);
        arrayList.add(0);
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(150);
        arrayList.add(-30);
        arrayList.add(19);
        // 4.1 - sort()
        Collections.sort(arrayList);
        System.out.println(arrayList);
        // 4.2 - reverse()
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        // 4.3 - shuffle()
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }
}

// 2
//---------------------------------------------------------------
class Employee implements Comparable<Employee> {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        int result = this.id - anotherEmp.id;

        if (result == 0) {
            result = this.name.compareTo(anotherEmp.name);
        }
        return result;
    }
}
//---------------------------------------------------------------
