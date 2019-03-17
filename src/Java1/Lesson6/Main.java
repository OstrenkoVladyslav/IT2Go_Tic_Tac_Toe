package Java1.Lesson6;

/**
 * Created by vladyslav on 17.07.17.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Red devil");
        cat1.run(500);

        Cat cat2 = new Cat("Snow white");
        cat2.swim(25);

        Dog dog1 = new Dog("Barbos");
        dog1.jump(50);

        Dog dog2 = new Dog("Strelka");
        dog2.swim(10);
    }
}
