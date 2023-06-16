package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* ------------------------------- 7. Streams ------------------------------------ */
/* 12. Метод collect grouping и partitioning */
/**
    ---------------
     Методы Stream
    ---------------
    Методы: concat(), distinct() 'i', count() 't', peek() 'i', flatMap() 'i', collect() 't'.
                                                                              /     \
                                                                    groupingBy()   partitioningBy()
*/
public class Test8 {

    // collect(), groupingBy(), partitioningBy()
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

        // 1 - groupingBy()
        Map<Integer, List<Student>> map = students.stream()
                .map(e -> {
                    e.setName(e.getName().toUpperCase());
                    return e;
                })
                .collect(Collectors.groupingBy(e -> e.getCourse()));
        for (Map.Entry<Integer, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        System.out.println("--------------------------");

        // 2 - partitioningBy()
        Map<Boolean, List<Student>> map2 = students.stream()
                .collect(Collectors.partitioningBy(e -> e.getAvgGrade() > 7));
        for (Map.Entry<Boolean, List<Student>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        System.out.println("--------------------------");
    }
}
