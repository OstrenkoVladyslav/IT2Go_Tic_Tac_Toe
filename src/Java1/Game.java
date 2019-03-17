package Java1;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.min;

public class Game {
    public static final int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static char[][] map = new char[SIZE][SIZE];
    public static char X_DOT = 'X';
    public static char O_DOT = 'O';
    public static char EMPTY_DOT = '*';
    public static Scanner scanner = new Scanner((System.in));
    public static int turnCounter = 0;
    public static Random random = new Random();
    public static int x, y; //Сюда записывается последний ход

    public static void main(String[] args) {
        initializeMap();
        printMap(map);
        do {
            humanMove();
            if (gameIsOver()) {
                printMap(map);
                break;
            }
            aiMove();
            if (gameIsOver()) {
                printMap(map);
                break;
            }
            printMap(map);
            System.out.println();
        } while (true);
        System.out.println("Game is over.");
    }

    public static void initializeMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printMap(char[][] array) {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanMove() {
        do {
            System.out.println("Make your turn in format X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!checkTurn(y, x));
        map[y][x] = X_DOT;
        turnCounter++;
    }

    public static void dumbMove() {
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!checkTurn(y, x));
        System.out.println("Dumb move X = " + (x + 1) + ", Y = " + (y + 1));
        map[y][x] = O_DOT;
    }

    public static void aiMove() {
        //Создаем временный массив и инициализируем его копией игрового поля
        char[][] testMap = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            testMap[i] = map[i].clone();
        }

        char ch;
        boolean aiMadeMove = false;

        for (int i = 0; i < SIZE && !aiMadeMove; i++) {
            for (int j = 0; j < SIZE && !aiMadeMove; j++) {
                if (testMap[i][j] == EMPTY_DOT) {
                    testMap[i][j] = O_DOT;
                    y = i;
                    x = j;
                    if (checkWin(testMap, y, x, O_DOT)) {
                        System.out.println("Win move X = " + (j + 1) + ", Y = " + (i + 1));
                        map[i][j] = O_DOT;
                        aiMadeMove = true;
                    }
                    testMap[i][j] = EMPTY_DOT;
                }
            }
        }

        for (int i = 0; i < SIZE && !aiMadeMove; i++) {
            for (int j = 0; j < SIZE && !aiMadeMove; j++) {
                if (testMap[i][j] == EMPTY_DOT) {
                    testMap[i][j] = X_DOT;
                    y = i;
                    x = j;
                    if (checkWin(testMap, y, x, X_DOT)) {
                        System.out.println("Blocking move X = " + (j + 1) + ", Y = " + (i + 1));
                        map[i][j] = O_DOT;
                        aiMadeMove = true;
                    }
                    testMap[i][j] = EMPTY_DOT;
                }
            }
        }

        if (!aiMadeMove) {
            dumbMove();
        }

        turnCounter++;
    }

    public static boolean checkTurn(int a, int b) {
        if (a < 0 || a >= SIZE) {
            return false;
        }
        if (map[a][b] != EMPTY_DOT) {
            return false;
        }
        return true;
    }

    public static boolean gameIsOver() {
        if (checkWin(map, x, y, X_DOT)) {
            System.out.println("X wins");
            return true;
        }
        if (checkWin(map, x, y, O_DOT)) {
            System.out.println("O wins");
            return true;
        }
        if (turnCounter >= SIZE * SIZE) {
            System.out.println("Playfield is fool.");
            return true;
        }
        return false;
    }

    public static boolean checkWin(char[][] array, int x, int y, char symbol) {
        /*
        Проверяем только один ряд, один столбец и две диагонали, которые проходят через точку с последним ходом
        */
        int counter = 0;
        for (int i = 0; i < SIZE; i++) { //Проверяем один столбец
            if (array[i][x] == symbol) {
                counter++;
                if (counter >= DOTS_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }

        counter = 0;
        for (int j = 0; j < SIZE; j++) { //Проверяем один ряд
            if (array[y][j] == symbol) {
                counter++;
                if (counter >= DOTS_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }

        //Находим начало диагонали №1
        int i_start = x - min(x, y);
        int j_start = y - min(x, y);

        //Размер диагонали
        int len = min(SIZE - i_start, SIZE - j_start);

        //Проверяем диагональ
        counter = 0;
        for (int l = 0; l < len; l++) {
            if (array[i_start + l][j_start + l] == symbol) {
                counter++;
                if (counter >= DOTS_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }

        }

        //Находим начало диагонали №2
        i_start = x + min(SIZE - x - 1, y);
        j_start = y - min(x, y);

        //Размер диагонали
        len = min(i_start + 1, SIZE - j_start);

        counter = 0;
        for (int l = 0; l < len; l++) {
            if (array[i_start - l][j_start + l] == symbol) {
                counter++;
                if (counter >= DOTS_TO_WIN) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }

        return false;
    }
}
