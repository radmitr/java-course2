package collection.list_interface;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* ------------------------------ 4. Коллекции ----------------------------------- */
/* 8. Интерфейс ListIterator */
/**
    --------------
     ListIterator
    --------------
       some code
         ………
    ListIterator<DataType> listIter = aL.listIterator();
    while (listIter.hasNext())
    {
        System.out.println(listIter.next());
    }
    while (listIter.hasPrevious())
    {
        System.out.println(listIter.previous());
    }
*/
public class ListIteratorEx {

    public static void main(String[] args) {
        // 1
//        String s = "madam";
        // 2
        String s = "madam2";

        List<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            list.add(ch);
        }
        System.out.println(list);

        // listIterator()
        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reverseIterator = list.listIterator(list.size());
        boolean isPalindrome = true;
        while (iterator.hasNext() && reverseIterator.hasPrevious()) {
            if (iterator.next() != reverseIterator.previous()) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }
    }
}
