package Java1.Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public String toString() {
        return "plate: " + food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void increaseFood(int n) {
        food += n;
    }
}