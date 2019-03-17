package Java1;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        // Задание 1
        int[] array1 = {0, 1, 0, 0, 1, 1, 1, 0, 0, 0};
        for (int i = 0; i < array1.length; i++) {
            array1[i] = 1 - array1[i];
        }
        System.out.println(Arrays.toString(array1));

        //Задание 2
        int[] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i * 3;
        }
        System.out.println(Arrays.toString(array2));

        //Задание 3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array3));

        //Задание 4
        int dimension = 8;
        int[][] array4 = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            array4[i][i] = 1;
            array4[i][dimension - i - 1] = 1;
        }
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(array4[i][j] + " ");
            }
            System.out.println();
        }

        //Задание 5
        int[] array5 = {10, 0, -5, 12, -36, 128, 0};
        int min = array5[0];
        int max = array5[0];
        for (int i = 1; i < array5.length; i++) {
            if (array5[i] > max) {
                max = array5[i];
            }
            if (array5[i] < min) {
                min = array5[i];
            }
        }
        System.out.println("Min = " + min + ", max = " + max);

        //Задание 6
        int[] array61 = {1, 2, 3, 4, 1};
        System.out.println(checkBallance(array61));
        int[] array62 = {1, 2, 5, 3, 5};
        System.out.println(checkBallance(array62));

        //Задание 7
        int[] array7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        array7 = shiftArray(array7, -5);
        System.out.println(Arrays.toString(array7));
    }

    public static boolean checkBallance(int[] array) {
        int sumOfArray = 0; //сумма всех элементов массива
        boolean ballanceIsFound = false;
        for (int i = 0; i < array.length; i++) {
            sumOfArray += array[i];
        }

        if (sumOfArray % 2 != 0) {
            return false; //eсли сумма элементов нечетная, то задача поиска точки балланса не имеет решения
        }

        int sumTemporary = 0; //временная переменная для нахождения точки балланса
        for (int i = 0; sumTemporary < sumOfArray / 2; i++) { //суммируем до тех пор, пока не "насобираем" половину от суммы всех элементов
            sumTemporary += array[i];
        }
        return (sumTemporary == sumOfArray / 2); //сумма элементов слева равна половине суммы всех эелементов?
    }

    public static int[] shiftArray(int[] array, int n) {
        int temp;
        int length = array.length;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                temp = array[length - 1];
                for (int j = length - 2; j >= 0; j--) {
                    array[j + 1] = array[j];
                }
                array[0] = temp;
            }
        }
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                temp = array[0];
                for (int j = 1; j < length; j++) {
                    array[j - 1] = array[j];
                }
                array[length - 1] = temp;
            }
        }
        return array;
    }
}
