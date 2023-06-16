package collection.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 14. Методы equals и hashCode */
/* 15. HashMap в деталях. Часть 1 */
/* 16. HashMap в деталях. Часть 2 */
/* 17. TreeMap */
/**
    --------------------------
     Методы equals и hashcode
    --------------------------
    Если Вы переопределили equals, то переопределите и hashcode.

    Результат нескольких выполнений метода hashcode для одного и того же объекта должен быть одинаковым.

    Если, согласно методу equals, два объекта равны, то и hashcode данных объектов обязательно
    должен быть одинаковым.

    Если, согласно методу equals, два объекта НЕ равны, то hashcode данных объектов НЕ обязательно
    должен быть разным.

    Ситуация, когда результат метода hashcode для разных объектов одинаков, называется коллизией.
    Чем её меньше, тем лучше.

    ---------
     HashMap
    ---------
    В основе HashMap лежит массив. Элементами данного массива являются LinkedList. Данные структуры LinkedList и
    заполняются элементами, которые мы добавляем в HashMap.

    При создании HashMap мы можем задать 2 параметра, которые очень влияют на производительность:
    - Initial capacity — начальный размер массива;
    - Load factor — коэффициент того, на сколько массив должен быть заполнен, после чего его размер должен быть
      увеличен вдвое.
*/
public class HashCodeEx {

    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();

        Student st1 = new Student("Dmitriy", "Radionov", 3);
        Student st2 = new Student("Mariya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 9.2);
        System.out.println(map);

        Student st4 = new Student("Dmitriy", "Radionov", 3);
        // 1 // 2.1
//        boolean result = map.containsKey(st4);
//        System.out.println("result = " + result); // >> result = false // >> result = true
////        System.out.println(st1.equals(st4));

        // 2.2
//        System.out.println(st1.hashCode());
//        System.out.println(st2.hashCode());
//        System.out.println(st3.hashCode());
//        System.out.println(st4.hashCode());

        // 3
        Student st5 = new Student("Igor", "Sidorenkov", 4);
        // 3.1 - нет коллизии (hashcode разный)
//        System.out.println(st1.hashCode()); // >> 18
//        System.out.println(st2.hashCode()); // >> 14
        // 3.2 - коллизия (hashcode одинаковый)
        // 3.3 - нет коллизии (hashcode разный)
//        System.out.println(st1.hashCode()); // >> 18 // >> 296
//        System.out.println(st5.hashCode()); // >> 18 // >> 350
        // 3.4 - hashcode одинаковые
        // 1 - hashcode разные (по умолчанию используются hashcode на основе адреса объекта)
//        System.out.println(st1.hashCode()); // >> 1502603286 // >> 250421012
//        System.out.println(st4.hashCode()); // >> 1502603286 // >> 1791741888
//        map.put(st4, 7.5);
//        map.put(st5, 7.5);
//        System.out.println(map);

        /* ----- 15. HashMap в деталях. Часть 1 ----- */
//        for (Map.Entry<Student, Double> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        /* ------------------------------------------ */

        /* ----- 16. HashMap в деталях. Часть 2 ----- */
        // 1
        // Initial capacity, Load factor
        Map<Integer, String> map2 = new HashMap<>(16, 0.75f); // default 16 and 0.75 (16 * 0.75 = 12)
        // If added 12 elements (16 * 0.75 = 12) -> rehashing to table capacity 32 (16 * 2 = 32)
        // LinkedList O(n) -> Сбалансированные деревья O(log(n))

        // 2 - key must be immutable
        System.out.println(map.containsKey(st1));
        System.out.println(st1.hashCode());
        st1.course = 4;
        System.out.println(map.containsKey(st1));
        System.out.println(st1.hashCode());
        /* ------------------------------------------ */
    }
}

//class Student {
/* ----- 17. TreeMap ----- */
class Student implements Comparable<Student> {
/* ----------------------- */
    String name;
    String surname;
    int course;
/* ----- 16. HashMap в деталях. Часть 2 ----- */
//final class Student {
//    final String name;
//    final String surname;
//    final int course;
/* ------------------------------------------ */

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    ////////////////// java.utils.Objects.equals and hashCode (java 7+) //////////////////
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course
                && Objects.equals(name, student.name)
                && Objects.equals(surname, student.surname);
    }

    // 2
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, course);
//    }

    // 3
    @Override
    public int hashCode() {
        // 3.1 // 3.2
//        return name.length() + surname.length() + course;
        // 3.3
//        return name.length() * 7 + surname.length() * 11 + course * 53;
        // 3.4
        return Objects.hash(name, surname, course);
        /* ----- 16. HashMap в деталях. Часть 2 ----- */
//        return 3;
        /* ------------------------------------------ */
    }
    //////////////////////////////////////////////////////////////////////////////////////

    ////////////////// IntelliJ Default //////////////////
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Student student = (Student) o;
//
//        if (course != student.course) return false;
//        if (name != null ? !name.equals(student.name) : student.name != null) return false;
//        return surname != null ? surname.equals(student.surname) : student.surname == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (surname != null ? surname.hashCode() : 0);
//        result = 31 * result + course;
//        return result;
//    }
    //////////////////////////////////////////////////////

    /* ----- 17. TreeMap ----- */
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
    /* ----------------------- */
}


