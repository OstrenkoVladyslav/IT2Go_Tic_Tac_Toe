package Java1.Lesson6;

/**
 * Created by vladyslav on 17.07.17.
 */
public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
        maxRunDistance = 400.0 + Math.random()*200;
        maxJumpDistance = 0.25 + Math.random()*0.5;
        maxSwimDistance = 5.0 + Math.random()*10;
    }

    public void run(int distance) {
        super.run("Dog " + name, distance);
    }

    public void jump(int distance){
        super.jump("Dog " + name, distance);
    }

    public void swim(int distance) {
        super.swim("Dog " + name, distance);
    }
}
