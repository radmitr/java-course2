package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 14. Методы min и max */
/* 15. Метод limit */
/* 16. Метод skip */
/* 17. Метод mapToInt */
/**
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
public class Test9 {

    // min(), max(), limit(), skip(), mapToInt()
    public static void main(String[] args) {
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

        /* ----- 14. Методы min и max ----- */
        // 1 - min()
        Student min = students.stream().min((x, y) -> x.getAge() - y.getAge()).get();
        System.out.println(min);
        System.out.println("--------------------------");
        // 2 - max()
        Student max = students.stream().max((x, y) -> x.getAge() - y.getAge()).get();
        System.out.println(max);
        System.out.println("--------------------------");
        /* -------------------------------- */

        /* ----- 15. Метод limit ----- */
        /* ----- 16. Метод skip ----- */
        // 0
        students.stream().filter(e -> e.getAge() > 20).forEach(System.out::println);
        System.out.println("--------------------------");
        // 1 - limit()
        students.stream().filter(e -> e.getAge() > 20).limit(2).forEach(System.out::println);
        System.out.println("--------------------------");
        // 2 - skip()
//        students.stream().filter(e -> e.getAge() > 20).skip(2).forEach(System.out::println);
        students.stream().filter(e -> e.getAge() > 20).skip(3).forEach(System.out::println);
        System.out.println("--------------------------");
        /* --------------------------- */

        /* ----- 17. Метод mapToInt ----- */
        // 1 - mapToInt(), boxed()
        List<Integer> courses = students.stream()
                .mapToInt(e -> e.getCourse())
                .boxed()
                .collect(Collectors.toList());
        System.out.println(courses);
        System.out.println("--------------------------");

        // 2 - mapToDouble(), boxed()
        List<Double> avgGrades = students.stream()
                .mapToDouble(e -> e.getAvgGrade())
                .boxed()
                .collect(Collectors.toList());
        System.out.println(avgGrades);
        System.out.println("--------------------------");

        // 3 - mapToInt().sum()
        int sum = students.stream().mapToInt(e -> e.getCourse()).sum();
        System.out.println(sum);
        System.out.println("--------------------------");

        // 4 - mapToInt().average()
        double average = students.stream().mapToInt(e -> e.getCourse()).average().getAsDouble();
        System.out.println(average);
        System.out.println("--------------------------");

        // 5 - mapToInt().min()
        int min2 = students.stream().mapToInt(e -> e.getCourse()).min().getAsInt();
        System.out.println(min2);
        System.out.println("--------------------------");

        // 6 - mapToInt().max()
        int max2 = students.stream().mapToInt(e -> e.getCourse()).max().getAsInt();
        System.out.println(max2);
        System.out.println("--------------------------");
        /* ------------------------------ */
    }
}
