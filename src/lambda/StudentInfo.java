package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/* --------------------------- 6. Lambda выражения ------------------------------- */
/* 1. Lambda выражения. Часть 1 */
    // 2nd class
/* 2. Lambda выражения. Часть 2 */
    // 2nd class
/* 3. Predicate */
    // 2nd class
/* 6. Function */
    // 2nd class
/**
    --------------------
     Lambda expressions
    --------------------
    Самый короткий вариант написания лямбда выражения:
    stud -> stud.avgGrade > 8.5

    Более полный вариант написания лямбда выражения:
    (Student stud) -> {return stud.avgGrade> 8.5;}

    В лямбда выражении оператор стрелка разделяет параметры метода и тело метода.

    В лямбда выражении справа от оператора стрелка находится тело метода, которое было бы
    у метода соответствующего класса, имплементировавшего наш интерфейс с единственным методом.

    -----

    Вы можете использовать смешанный вариант написания лямбда выражения: слева от оператора стрелка писать
    короткий вариант, справа – полный. Или наоборот.

    Если вы используете полный вариант написания для части лямбда выражения справа от стрелки,
    то вы должны использовать слово return и знак «;»

    Левая часть лямбда выражения может быть написана в краткой форме, если метод интерфейса принимает
    только 1 параметр. Даже если метод интерфейса принимает 1 параметр, но в лямбда выражении вы хотите
    писать данный параметр используя его тип данных, тогда уже вы должны писать левую часть лямбда выражения
    в скобках.

    Если в правой части лямбда выражения вы пишите более одного statement-а, то вы должны использовать его
    полный вариант написания.

    -----

    def( () -> 5 );
    def( (x) -> x.length() );
    def( (String x) -> x.length() );
    def( (x, y) -> x.length() );
    def( (String x, String y) -> x.length() );

    ___Compile time errors:___
    def( x -> {x.length();} );
    def( x -> {return x.length()} );
    def( x, y -> x.length() );

    -----

    Лямбда выражения работают с интерфейсом, в котором есть только 1 абстрактный метод.
    Такие интерфейсы называются функциональными интерфейсами, т.е. интерфейсами, пригодными
    для функционального программирования.

    --------------------------
     Пакет java.util.function
    --------------------------

    ---------------------------------------------------
    Predicate<T>                    boolean test(T t);
    Используется методом removeIf
    ---------------------------------------------------
    Supplier<T>                     T get();
    ---------------------------------------------------
    Consumer<T>                     void accept(T t);
    Используется методом forEach
    ---------------------------------------------------
    Function<T, R>                  R apply(T t);
    ---------------------------------------------------
*/
public class StudentInfo {

    // 1
//    void printStudentOverGrade(ArrayList<Student> al, double grade) {
//        for (Student st: al) {
//            if (st.avgGrade > grade) {
//                System.out.println(st);
//            }
//        }
//    }
//
//    void printStudentUnderAge(ArrayList<Student> al, int age) {
//        for (Student st: al) {
//            if (st.age < age) {
//                System.out.println(st);
//            }
//        }
//    }
//
//    void printStudentMixCondition(ArrayList<Student> al, int age, double grade, char sex) {
//        for (Student st: al) {
//            if (st.age > age && st.avgGrade < grade && st.sex == sex) {
//                System.out.println(st);
//            }
//        }
//    }

    // 2
//    void testStudents(ArrayList<Student> al, StudentChecks sc) {
//        for (Student st : al) {
//            if (sc.check(st) == true) {
//                System.out.println(st);
//            }
//        }
//    }

    /* ----- 3. Predicate ----- */
    void testStudents(ArrayList<Student> al, Predicate<Student> pr) {
        for (Student st : al) {
            if (pr.test(st) == true) {
                System.out.println(st);
            }
        }
    }
    /* ------------------------ */
}

class Test {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);
//        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        ArrayList<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();

        // 1
//        info.printStudentOverGrade(students, 8);
//        System.out.println("------------------");
//        info.printStudentUnderAge(students, 30);
//        System.out.println("------------------");
////        info.printStudentMixCondition(students, 20, 9, 'f');
//        info.printStudentMixCondition(students, 20, 9.5, 'f');

        // 2.1 - class CheckOverGrade implements StudentChecks
//        info.testStudents(students, new CheckOverGrade());
//        System.out.println("------------------");
        // 2.2 - anonymous class implements StudentChecks
//        info.testStudents(students, new StudentChecks() {
//            @Override
//            public boolean check(Student st) {
//                return st.age < 30;
//            }
//        });
//        System.out.println("------------------");
        // 2.3 - lambda (java 8+)
        info.testStudents(students, (Student st) -> {
            return st.avgGrade > 8;
        });
        System.out.println("------------------");
            /* ----- 2. Lambda выражения. Часть 2 ----- */
            // 0
////            int st = 3; // variable 'st' is already defined in the scope
//            info.testStudents(students, st -> st.avgGrade > 8);
//            info.testStudents(students, st -> {return st.avgGrade > 8;}); // смешанный вариант
//            info.testStudents(students, st -> { // несколько statement-ов
//                System.out.println("Hello");
//                return st.avgGrade > 8;
//            });
//
//            StudentChecks sc = (Student st) -> { return st.avgGrade > 8;};
//            info.testStudents(students, sc);
            /* ---------------------------------------- */
        info.testStudents(students, (Student st) -> {
            return st.age < 30;
        });
        System.out.println("------------------");
        info.testStudents(students, (Student st) -> {
            return st.age > 20 && st.avgGrade < 9.5 && st.sex == 'f';
        });
        System.out.println("------------------");

        /* ----- 2. Lambda выражения. Часть 2 ----- */
//        // 1
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student st1, Student st2) {
//                return st1.course - st2.course;
//            }
//        });
//        System.out.println(students);
//        System.out.println("------------------");
//        // 2
//        Collections.sort(students, (stud1, stud2) -> stud1.course - stud2.course);
//        System.out.println(students);
//        System.out.println("------------------");
//        // 3
//        Collections.sort(students, Comparator.comparingInt(st -> st.course));
//        System.out.println(students);
//        System.out.println("------------------");
        /* ---------------------------------------- */

        /* ----- 3. Predicate ----- */
        Predicate<Student> p1 = student -> student.avgGrade > 8;
        Predicate<Student> p2 = student -> student.sex == 'm';
        info.testStudents(students, p1);
        System.out.println("------------------");
        info.testStudents(students, p2);
        System.out.println("------------------");
        info.testStudents(students, p1.and(p2));
        System.out.println("------------------");
        info.testStudents(students, p1.or(p2));
        System.out.println("------------------");
        info.testStudents(students, p1.negate());
        System.out.println("------------------");
        /* ------------------------ */

        /* ----- 6. Function ----- */
        // lambda example
        Function<Student, Double> f1 = student -> student.avgGrade;
        double result = averageOfSomething(students, f1);
        System.out.println(result);
        System.out.println("------------------");
        result = averageOfSomething(students, stud -> stud.avgGrade);
        System.out.println(result);
        System.out.println("------------------");
        result = averageOfSomething(students, stud -> (double)stud.course);
        System.out.println(result);
        System.out.println("------------------");
        result = averageOfSomething(students, stud -> (double)stud.age);
        System.out.println(result);
        System.out.println("------------------");
        /* ----------------------- */
    }

    /* ----- 6. Function ----- */
    private static double averageOfSomething(List<Student> list, Function<Student, Double> f) {
        double result = 0;

        for (Student st : list) {
            result += f.apply(st);
        }
        result = result / list.size();
        return result;
    }
    /* ----------------------- */
}

//interface StudentChecks { // функциональный интерфейс (содержит всего один абстрактный метод)
//    boolean check(Student st);
////    boolean check2(Student st); // тогда ошибка lambda
////    boolean check2(double st); // тогда ошибка lambda
//}
//
//class CheckOverGrade implements StudentChecks {
//
//    @Override
//    public boolean check(Student st) {
//        return st.avgGrade > 8;
//    }
//}
