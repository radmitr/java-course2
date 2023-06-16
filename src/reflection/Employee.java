package reflection;

/* ------------------------- 11. Другие важные темы ------------------------------ */
/* 5. Reflection. Часть 1 */
    // 1st class
/* 6. Reflection. Часть 2 */
    // 1st class
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
*/
public class Employee {

    public int id;
    public String name;
    public String department;
//    private double salary;
    private double salary = 1000;

    public Employee() {
    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void changeDepartment(String newDepartment) {
        department = newDepartment;
        System.out.println("New department is: " + department);
    }

    public void increaseSalary() {
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
