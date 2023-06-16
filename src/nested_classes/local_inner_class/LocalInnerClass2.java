package nested_classes.local_inner_class;

/* ---------------------------- 5. Nested классы --------------------------------- */
/* 4. Local Inner класс */
    // 2nd class
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
public class LocalInnerClass2 {

    public static void main(String[] args) {
        class Sum implements Math2 {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        }

        Sum s = new Sum();
        System.out.println(s.doOperation(5, 3));
    }
}

interface Math2 {
    int doOperation(int a, int b);
}
