package nested_classes.local_inner_class;

/* ---------------------------- 5. Nested классы --------------------------------- */
/* 4. Local Inner класс */
    // 1st class
/**
    -------------------
     Local inner класс
    -------------------
    • Local inner класс располагается в блоках кода таких, как, например, метод или конструктор
    • Local inner класс не может быть static
    • Область видимости local inner класса – это блок, в котором он находится
    • Local inner класс может обращаться даже к private элементам внешнего класса
    • Local inner класс может обращаться к элементам блока, в котором он написан при условии,
      что они final или effectively final
*/
public class LocalInnerClass1 {

    public static void main(String[] args) {
        Math math = new Math();

        // 1 // 2
//        math.getResult();

        // 3
        math.getResult(21, 4);

//        Division division; // так нельзя
    }
}

// 1
//-----------------------------------------------------------------------------
//class Math {
////    Division division; // так нельзя
//    private int a = 10; // private элемент внешнего класса
//
//    public void getResult() {
//        class Division {
////        static class Division { // ак нельзя, static class локальным быть не может
//            private int divisible;
//            private int divider;
//
//
//            public int getDivisible() {
//                return divisible;
//            }
//
//            public void setDivisible(int divisible) {
//                this.divisible = divisible;
//            }
//
//            public int getDivider() {
//                return divider;
//            }
//
//            public void setDivider(int divider) {
//                this.divider = divider;
//            }
//
//            public int getQuotient() {
//                return divisible / divider;
//            }
//
//            public int getRemnant() {
//                System.out.println(a);
//                return divisible % divider;
//            }
//        }
//
//        Division division = new Division(); // класс виден только внутри метода
//        division.setDivisible(21);
//        division.setDivider(4);
//        System.out.println("Divisible = " + division.getDivisible());
//        System.out.println("Divider = " + division.getDivider());
//        System.out.println("Quotient = " + division.getQuotient());
//        System.out.println("Remnant = " + division.getRemnant());
//    }
//}
//-----------------------------------------------------------------------------

// 2 - Local inner класс может обращаться к элементам блока, в котором он написан при условии,
//     что они final или effectively final
//-----------------------------------------------------------------------------
//class Math {
//    private int a = 10; // private элемент внешнего класса
//
//    public void getResult() {
////        final int divisible = 21;
//        int divisible = 21; // effectively final
////        int divisible = 20; // ошибка при компиляции
//
//        class Division {
////            void abc() {
////                divisible = 20; // ошибка при компиляции
////            }
//
////            private int divisible;
//            private int divider;
//
////            public int getDivisible() {
////                return divisible;
////            }
////
////            public void setDivisible(int divisible) {
////                this.divisible = divisible;
////            }
//
//            public int getDivider() {
//                return divider;
//            }
//
//            public void setDivider(int divider) {
//                this.divider = divider;
//            }
//
//            public int getQuotient() {
//                return divisible / divider;
//            }
//
//            public int getRemnant() {
//                System.out.println(a);
//                return divisible % divider;
//            }
//        }
//
//        Division division = new Division(); // класс виден только внутри метода
//        division.setDivider(4);
//        System.out.println("Divisible = " + divisible);
//        System.out.println("Divider = " + division.getDivider());
//        System.out.println("Quotient = " + division.getQuotient());
//        System.out.println("Remnant = " + division.getRemnant());
//    }
//}
//-----------------------------------------------------------------------------

// 3
//-----------------------------------------------------------------------------
class Math {
    private int a = 10; // private элемент внешнего класса

//    public void getResult(int divisible, int divider) {
    public void getResult(final int divisible, final int divider) {
//        divisible = 22; // // ошибка при компиляции, менять нельзя
//        divider = 5; // // ошибка при компиляции, менять нельзя
        class Division {
            public int getQuotient() {
                return divisible / divider;
            }

            public int getRemnant() {
                System.out.println(a);
                return divisible % divider;
            }
        }

        Division division = new Division(); // класс виден только внутри метода
        System.out.println("Divisible = " + divisible);
        System.out.println("Divider = " + divider);
        System.out.println("Quotient = " + division.getQuotient());
        System.out.println("Remnant = " + division.getRemnant());
    }
}
//-----------------------------------------------------------------------------
