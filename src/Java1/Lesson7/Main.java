package Java1.Lesson7;

public class Main {
    public static void main(String[] args) {
        Cat[] cat = {new Cat("Barsik", 5), new Cat("Murzik", 7), new Cat("Pushok", 15), new Cat("Red devil", 25), new Cat("Snow white", 3)};
        Plate plate = new Plate(0);
        plate.increaseFood(50);
        System.out.println(plate);
        for (int i = 0; i < cat.length; i++){
            cat[i].eat(plate);
            System.out.println(cat[i]);
        }
        System.out.println(plate);
    }
}