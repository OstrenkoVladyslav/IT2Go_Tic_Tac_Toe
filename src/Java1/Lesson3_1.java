package Java1;

import java.util.Random;
import java.util.Scanner;

public class Lesson3_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userNumber;
        boolean flag;
        do {
            int tryCounter = 0;
            int myNumber = random.nextInt(10);
            System.out.println("I made a random number 0 to 9");
            do {
                System.out.print("Try to guess my number: ");
                userNumber = scanner.nextInt();
                flag = guessNumber(myNumber, userNumber);
            } while (flag == false && tryCounter++ < 2);
            System.out.println("One more game? 0/1 ");
        } while (scanner.nextInt() == 1);
        System.out.println("Exiting...");
    }

    public static boolean guessNumber(int myNumber, int userNumber) {
        if (myNumber == userNumber) {
            System.out.println("You guessed!");
            return true;
        } else if (myNumber < userNumber) {
            System.out.println("Number is too big.");
        } else {
            System.out.println("Number is too small.");
        }
        return false;
    }
}
