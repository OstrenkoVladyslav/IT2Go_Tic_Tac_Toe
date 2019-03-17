package Java1.Lesson6;

/**
 * Created by vladyslav on 17.07.17.
 */
public class Animal {
    protected double maxRunDistance, maxJumpDistance, maxSwimDistance;
    protected String name;

    public Animal() {
    }

    public void run(String animalName, double distance) {
        System.out.println(animalName + " " + name + " is running for " + (Math.min(distance, maxRunDistance)) + " meters.");
    }

    public void jump(String animalName, double distance) {
        System.out.println(animalName + " " + name + " is jumping for " + Math.min(distance, maxJumpDistance) + " meters.");
    }

    public void swim(String animalName, double distance) {
        System.out.println(animalName + " " + name + " is swiming for " + Math.min(distance, maxSwimDistance) + " meters.");
    }
}
