package nested_classes.static_nested_classes;

/* ---------------------------- 5. Nested классы --------------------------------- */
/* 2. Static Nested класс */
/**
    ---------------------
     static nested класс
    ---------------------
    • static nested класс очень похож на обычный внешний, но находится внутри другого класса
    • Создавая объект static nested класса, нужно указывать и класс, содержащий его
    • static nested класс может содержать static и non-static элементы
    • static nested класс может обращаться даже к private элементам внешнего класса, но только к static
    • Внешний класс может обращаться даже к private элементам static nested класса
*/
public class Car {

    String color;
    int doorCount;
    Engine engine;
    private static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    void method() {
        System.out.println(Engine.countOfObjects); // static variable
        Engine e = new Engine(200);
//        Car.Engine e = new Car.Engine(200); // излишне
        System.out.println(e.horsePower); // private in variable
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    // 1 // 6 - public
    public static class Engine {
    // 2 - private
//    private static class Engine {
    // 3 - final
//    public final static class Engine {
    // 4 - abstract
//    public abstract static class Engine {
    // 5 - extends
//    public static class Engine extends Z {
        private int horsePower;
        static int countOfObjects;

        public Engine(int horsePower) {
            System.out.println(a); // private static variable
//            System.out.println(doorCount); // так нельзя, потому что doorCount не static
            this.horsePower = horsePower;
            countOfObjects++;
        }

        @Override
        public String toString() {
            return "My engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }

    interface I {
    }
}

class Test {
    public static void main(String[] args) {
//        Engine engine = new Car.Engine(256); // так нельзя, т.к. nested class
        Car.Engine engine = new Car.Engine(256);
        System.out.println(engine);

        Car car = new Car("red", 2, engine);
        System.out.println(car);

//        Car.Engine engine2 = new car.Engine(150); // так нельзя
        Car.Engine engine2 = new Car.Engine(150); // только так можно
    }
}

// 5
//----------
//class Z {
//
//}
//----------

// 6
//-------------------------------
class Z extends Car.Engine {
//    public Z(int horsePower) {
//        super(horsePower);
//    }
    Z() {
        super(200);
    }
}
//-------------------------------
