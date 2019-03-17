package Java1.Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean full = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        if (appetite < plate.getFood()) {
            plate.decreaseFood(appetite);
            full = true;
        }
    }

    @Override
    public String toString() {
        return "Cat " + name + ((full)? " ":" not ") + "full";
    }
}
