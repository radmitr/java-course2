package comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* ------------------- 2. Интерфейсы Comparable и Comparator --------------------- */
/* 1. Интерфейс Comparable */
    // 1st class
/**
    -------------------------
     Comparable & Comparator
    -------------------------
    Интерфейс Comparable используется для сравнения объектов, используя естественный порядок
        int compareTo(Element e)

    Интерфейс Comparator используется для сравнения объектов, используя НЕ естественный порядок
        int compare(Element e1, Element e2)
*/
public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Zaur");
        list.add("Ivan");
        list.add("Mariya");
        list.add("Dmitriy");
        System.out.println("Before sorting");
        System.out.println(list);
        System.out.println("After sorting");
        Collections.sort(list);
        System.out.println(list);
    }
}
