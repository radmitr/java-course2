package nested_classes.anonymous_class;

/* ---------------------------- 5. Nested классы --------------------------------- */
/* 5. Anonymous класс */
/**
    -----------------------
     Anonymous inner класс
    -----------------------
    • Anonymous класс не имеет имени
    • Anonymous класс – это «объявление» класса и одновременное создание объекта
    • В анонимных классах невозможно написать конструктор
    • Анонимный класс может обращаться даже к private элементам внешнего класса
    • Lambda expressions – это краткая форма для написания анонимных классов
*/
public class AnonymousClass {

    // 3.1
//    private int x = 5;
    // 3.2
    private static int x = 5;

    public static void main(String[] args) {
        Math m = new Math() {
            int c = 10;

            void abc() {
            }

            // 1 // 2
//            @Override
//            public int doOperation(int a, int b) {
//                return a + b;
//            }

            // 3
            @Override
            public int doOperation(int a, int b) {
                // 3.1
//                AnonymousClass ac = new AnonymousClass();
//                return a + b + ac.x;
                // 3.2
                return a + b + x;
            }
        };

        Math m2 = new Math() {
            int c = 10;

            void abc() {
            }

            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }
        };

        System.out.println(m.doOperation(3, 6));
        System.out.println(m2.doOperation(3, 6));
    }
}

// 1 - interface
//-----------------------------------
//interface Math {
//    int doOperation(int a, int b);
//}
//-----------------------------------

// 2 - class
//-----------------------------------
class Math {
    int doOperation(int a, int b) {
        return a / b;
    }
}
//-----------------------------------
