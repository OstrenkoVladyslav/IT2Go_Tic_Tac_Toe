package Java1.Lesson6;

/**
 * Created by vladyslav on 17.07.17.
 */
public class Cat extends Animal {
    public Cat(String name){
        this.name = name;
        maxRunDistance = 150.0 + Math.random()*100;
        maxJumpDistance = 3.0 + Math.random()*6;
        maxSwimDistance = 0.0;

    }

    public void run(int distance) {
        super.run("Cat "+ name, distance);
    }

    public void jump(int distance){
        super.jump("Cat " + name, distance);
    }

    public void swim(int distance) {
        System.out.println("Cats does not swim");
    }
}
