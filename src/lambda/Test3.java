package lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* --------------------------- 6. Lambda выражения ------------------------------- */
/* 4. Supplier */
/* 5. Consumer */
    // 1st class
/**
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
public class Test3 {

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> al = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            al.add(carSupplier.get());
        }
        return al;
    }

    /* ----- 5. Consumer ----- */
    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }
    /* ----------------------- */

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() ->
                new Car("Nissan Tiida", "Silver Metallic", 1.6));
        System.out.println("Our cars: " + ourCars);

        /* ----- 5. Consumer ----- */
        changeCar(ourCars.get(0), (car) -> {
                car.color = "red";
                car.engine = 2.4;
                System.out.println("upgraded car: " + car);
        });
        System.out.println("Our cars: " + ourCars);
        /* ----------------------- */
    }
}

class Car {
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
