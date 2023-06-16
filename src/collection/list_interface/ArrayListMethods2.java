package collection.list_interface;

import java.util.ArrayList;
import java.util.Objects;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 3. Методы ArrayList. Часть 1 */
    // 2nd class
/* 4. Методы ArrayList. Часть 2 */
    // 2nd class
/**
    ------------------
     Методы ArrayList
    ------------------
    add(DataType element)  boolean
    add(int index, DataType element)  boolean
    get(int index)  DataType
    set(int index, DataType element)  DataType
    remove(Object element)  boolean
    remove(int index)  DataType
    addAll(ArrayList aL)  boolean
    addAll(int index, ArrayList aL)  boolean
    clear()  void
    indexOf(Object element)  int
    lastIndexOf(Object element)  int
    size()  int
    isEmpty()  boolean
    contains(Object element)  boolean
    toString()  String
*/
public class ArrayListMethods2 {

    // remove(Object o), indexOf(Object o)
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        System.out.println(studentList);

        /* --- 3. Методы ArrayList. Часть 1 --- */
        // remove()
//        Student st6 = new Student("Mariya", 'f', 23, 3, 7.4);
//        studentList.remove(st6); // не удаляет // удаляет после overwrite equals()
////        studentList.remove(st5); // удаляет
//        System.out.println(studentList);
        /* ------------------------------------ */

        /* --- 4. Методы ArrayList. Часть 2 --- */
        // indexOf()
        Student st6 = new Student("Mariya", 'f', 23, 3, 7.4);
//        studentList.remove(st6); // не удаляет // удаляет после overwrite equals()
        int index = studentList.indexOf(st6);
        System.out.println(index);
        /* ------------------------------------ */
    }
}

class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    /* --- 3. Методы ArrayList. Часть 1 --- */
    /* --- 4. Методы ArrayList. Часть 2 --- */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex &&
                age == student.age &&
                course == student.course &&
                Double.compare(student.avgGrade, avgGrade) == 0 &&
                Objects.equals(name, student.name);
    }
    /* ------------------------------------ */
}
