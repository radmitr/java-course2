package nested_classes.inner_class;

/* ---------------------------- 5. Nested классы --------------------------------- */
/* 3. Inner класс */
/**
    -------------
     Inner класс
    -------------
    • Каждый объект inner класса всегда ассоциируется с объектом внешнего класса
    • Создавая объект inner класса, нужно перед этим создать объект его внешнего класса
    • Inner класс может содержать только non-static элементы // ?????????????????????????????????????????????????
    • Inner класс может обращаться даже к private элементам внешнего класса
    • Внешний класс может обращаться даже к private элементам inner класса, прежде создав его объект
*/
public class Car {

    String color;
    int doorCount;
//    static int doorCount; // со static variable inner class работает
//    private int doorCount; // с private variable inner class работает
    Engine engine;

    // 1
//    public Car(String color, int doorCount, int horsePower) {
//        this.color = color;
//        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower);
//    }
    // 2
    public Car(String color, int doorCount) {
//        System.out.println(horsePower); // так нельзя, можно только после создания переменной
        Engine e = new Engine(200);
        System.out.println(e.horsePower); // так можно
        this.color = color;
        this.doorCount = doorCount;
    }

    // 2
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println(this.engine.horsePower); // non-static inner variable
//        System.out.println(Engine.a); // static inner variable // ?????????????????????????????????????????????????
//        System.out.println(Engine.A); // static final inner variable
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    // 1 // 2 // 3 // 4
    public class Engine {
    // 5 - класс не виден снаружи
//    private class Engine {
    // 6 - со static тоже работает !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    public static class Engine {
        private int horsePower;
        public static int a = 5; // почему нет ошибки ?????????????????????????????????????????????????
//        public int a = 5; // почему есть ошибка ?????????????????????????????????????????????????
        public final static int A = 10; // можно c final

        public Engine(int horsePower) {
            System.out.println(doorCount);
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            a = 100;
            return "My engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        // 1
////        Car.Engine engine = new Car.Engine(256); // так создавать нельзя для inner class
//        Car car = new Car("black", 4, 300);
        // 2
        Car car = new Car("black", 4);
        System.out.println(car); // >> My car: {color='black', doorCount=4, engine=null}
        Car.Engine engine = car.new Engine(150);
        System.out.println(engine); // >> My engine: {horsePower=150}
        System.out.println(car); // >> My car: {color='black', doorCount=4, engine=null}
        car.setEngine(engine);
        System.out.println(car); // >> My car: {color='black', doorCount=4, engine=My engine: {horsePower=150}}
        // 3 - так нельзя
//        Car.Engine engine2 = new car.Engine(150); // так нельзя, потому что new должно относиться только к Engine
//        Car.Engine engine3 = new Сar.Engine(150); // так нельзя, потому что не static nested class
        // 4 - потеря ссылки
        Car.Engine engine4 = new Car("yellow", 4).new Engine(200); // теряем ссылку на car
        System.out.println(engine4);
    }
}
