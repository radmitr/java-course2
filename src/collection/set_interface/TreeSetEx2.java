package collection.set_interface;

import java.util.Objects;
import java.util.TreeSet;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 21. TreeSet */
    // 2nd class
/**
    ---------
     TreeSet
    ---------
    TreeSet хранит элементы в отсортированном по возрастанию порядке.
    В основе TreeSet лежит TreeMap. У элементов данного TreeMap: ключи - это элементы TreeSet,
    значения – это константа-заглушка.

    Методы: first(), last(), headSet(), tailSet(), subSet().
*/
public class TreeSetEx2 {

    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();

        Student st1 = new Student("Dmitriy", 5);
        Student st2 = new Student("Misha", 1);
        Student st3 = new Student("Igor", 2);
        Student st4 = new Student("Marina", 3);
        Student st5 = new Student("Olya", 4);

        treeSet.add(st1); // java.lang.ClassCastException // work after implements Comparable
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);

        System.out.println(treeSet);

        // 1 - first()
        System.out.println(treeSet.first());
        // 2 - last()
        System.out.println(treeSet.last());
        // 3 - headSet()
        Student st6 = new Student("Oleg", 3);
        System.out.println(treeSet.headSet(st6)); // 1, 2
        // 4 - tailSet()
        System.out.println(treeSet.tailSet(st6)); // 3, 4, 5
        // 5 - subSet()
        Student st7 = new Student("Oleg", 2);
        Student st8 = new Student("Ivan", 4);
        System.out.println(treeSet.subSet(st7, st8)); // 2, 3

        // 6 - Должны соблюдать правило: если equal() -> true, то compareTo() = 0
        System.out.println(st3.equals(st7));
        System.out.println(st3.hashCode() == st7.hashCode());
        System.out.println(st3.compareTo(st7));
    }
}

//class Student {
class Student implements Comparable<Student> {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        return this.course - other.course;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return course == student.course && Objects.equals(name, student.name);
        // 6
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
//        return Objects.hash(name, course);
        // 6
        return Objects.hash(course);
    }
}
