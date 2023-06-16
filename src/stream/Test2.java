package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 2. Метод filter */
/* 3. Метод forEach */
    // 2nd class
/* 5. Метод sorted */
    // 2nd class
/* 6. Method chaining */
    // 2nd class
/* 13. Метод findFirst */
/**
    ---------------
     Методы Stream
    ---------------
    Методы Stream не меняют саму коллекцию или массив, от которой был создан stream.

    Методы: map() ~i~, filter() ~i~, forEach() ~t~, reduce() ~t~, sorted() ~i~.

    --------------------------------
     Работа метод chaining в stream
    --------------------------------
              Source                 Terminal method
   (Напр.: коллекции, массив)            (eager)
                       \                 /
                       Intermediate methods
                              (lazy)

    ---------------
     Методы Stream
    ---------------
    Методы: findFirst() 't', min() 't', max() 't', limit() 'i', skip() 'i', mapToInt() 'i'.
                                                                              |
                                                                             sum()
                                                                             average()
                                                                             min()
                                                                             max()
*/
public class Test2 {

    // filter(),Stream.of(), sorted(), findFirst()
    public static void main(String[] args) {
        System.out.println("-------------------------");
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        List<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        System.out.println(students);

        students = students.stream().filter(element -> element.getAge() > 22 && element.getAvgGrade() < 7.2)
                .collect(Collectors.toList());
        System.out.println(students);
        System.out.println("-------------------------");

        /* ----- 3. Метод forEach ----- */
        Stream<Student> myStream = Stream.of(st1, st2, st3, st4, st5);

        students = myStream.filter(element -> element.getAge() > 22 && element.getAvgGrade() < 7.2)
                .collect(Collectors.toList());
        System.out.println(students);
        System.out.println("-------------------------");
        /* ---------------------------- */

        /* ----- 5. Метод sorted ----- */
        students = Stream.of(st1, st2, st3, st4, st5).collect(Collectors.toList());

        // 1
        // java.lang.ClassCastException : class stream.Student cannot be cast to class java.lang.Comparable
//        students = students.stream().sorted().collect(Collectors.toList());
        // 2
        students = students.stream().sorted((x, y) -> x.getName().compareTo(y.getName())).collect(Collectors.toList());
        // 3
//        students = students.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());

        System.out.println(students);
        System.out.println("-------------------------");
        /* --------------------------- */

        /* ----- 6. Method chaining ----- */
        students = Stream.of(st1, st2, st3, st4, st5).collect(Collectors.toList());

        students.stream()
                .map(element -> {
                    element.setName(element.getName().toUpperCase());
                    return element;
                })
                .filter(element -> element.getSex() == 'f')
                .sorted((x, y) -> x.getAge() - y.getAge())
                .forEach(element -> System.out.println(element));
        System.out.println("-------------------------");
        /* ------------------------------ */

        /* ----- 13. Метод findFirst ----- */
        students = Stream.of(st1, st2, st3, st4, st5).collect(Collectors.toList());

        Student first = students.stream()
                .map(element -> {
                    element.setName(element.getName().toUpperCase());
                    return element;
                })
                .filter(element -> element.getSex() == 'f')
                .sorted((x, y) -> x.getAge() - y.getAge())
                .findFirst().get();
        System.out.println(first);
        System.out.println("-------------------------");
        /* ------------------------------- */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
