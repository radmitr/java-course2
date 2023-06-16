package collection.queue_interface;

import java.util.Objects;
import java.util.PriorityQueue;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 23. Введение в Queue. LinkedList */
    // 2nd class
/**
    ---------------
     PriorityQueue
    ---------------
    PriorityQueue – это специальный вид очереди, в котором используется натуральная сортировка или та,
    которую мы описываем с помощью Comparable или Comparator. Таким образом используется тот элемент из очереди,
    приоритет которого выше.
*/
public class PriorityQueueEx2 {

    public static void main(String[] args) {
        Student st1 = new Student("Dmitriy", 5);
        Student st2 = new Student("Misha", 1);
        Student st3 = new Student("Igor", 2);
        Student st4 = new Student("Marina", 3);
        Student st5 = new Student("Olya", 4);

        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

        // 1 - add()
        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);
        priorityQueue.add(st5);
        System.out.println(priorityQueue); // видим не тот порядок, хотя нормально отсортированы

        // 2 - poll()
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
