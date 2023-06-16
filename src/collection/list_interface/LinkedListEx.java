package collection.list_interface;

import java.util.LinkedList;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 7. LinkedList */
/**
    ------------
     LinkedList
    ------------
    Элементы LinkedList – это звенья одной цепочки. Эти элементы хранят определённые данные,
                          а также ссылки на предыдущий и следующий элементы.
    Как правило, LinkedList следует использовать когда:
    1) Невелико количество операций получения элементов;
    2) Велико количество операций добавления и удаления элементов. Особенно если речь
       идёт о элементах в начале коллекции.
*/
public class LinkedListEx {

    public static void main(String[] args) {
        Student2 st1 = new Student2("Ivan", 3);
        Student2 st2 = new Student2("Nikolay", 2);
        Student2 st3 = new Student2("Elena", 1);
        Student2 st4 = new Student2("Petr", 4);
        Student2 st5 = new Student2("Mariya", 3);
        LinkedList<Student2> student2LinkedList = new LinkedList<>();

        // add()
        student2LinkedList.add(st1);
        student2LinkedList.add(st2);
        student2LinkedList.add(st3);
        student2LinkedList.add(st4);
        student2LinkedList.add(st5);
        System.out.println("LinkedList = " + student2LinkedList);
        System.out.println(student2LinkedList.get(2));
        Student2 st6 = new Student2("Dmitriy", 3);
        Student2 st7 = new Student2("Igor", 4);
        student2LinkedList.add(st6);
        System.out.println("LinkedList = " + student2LinkedList);
        student2LinkedList.add(1, st7);
        System.out.println("LinkedList = " + student2LinkedList);

        // remove()
        student2LinkedList.remove(3);
        System.out.println("LinkedList = " + student2LinkedList);
    }
}

class Student2 {
    String name;
    int course;

    public Student2(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
