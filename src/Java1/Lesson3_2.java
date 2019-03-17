package Java1;

import java.util.Random;
import java.util.Scanner;

public class Lesson3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        String myWord = words[random.nextInt(words.length)];
        String userWord;
        System.out.println("I made a word. Try to guess it.");
        boolean flag;
        do {
            userWord = scanner.next();
            flag = guessWord(myWord, userWord);
        } while (flag == false);
    }

    public static boolean guessWord(String myWord, String userWord) {
        if (myWord.equals(userWord)) {
            System.out.println("Correct!");
            return true;
        }
        for (int i = 0; i < 15; i++) {
            if (i < myWord.length() && i < userWord.length() && myWord.charAt(i) == userWord.charAt(i)) {
                System.out.print(myWord.charAt(i));
            } else System.out.print("#");
        }
        System.out.println();
        return false;
    }
}
