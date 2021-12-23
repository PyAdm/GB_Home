package lesson;

public class Lesson3 {
    public static void main(String[] args) {

        System.out.println("***************");
        invertArray();
        System.out.println("***************");
        oneHundred();
        System.out.println("***************");
        multiTwo();
        System.out.println("***************");
        diagDoubleArray();
        System.out.println("***************");
        createArray(10, 7);
        System.out.println("***************");
        int[] checkArray = {10, 20, 30, 80, 70, 50, 45};
        minMax(checkArray);
        System.out.println("***************");
    }

    // !1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
    // ![ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия
    // !заменить 0 на 1, 1 на 0;
    public static void invertArray() {
        int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == 0) {
                firstArray[i] = 1;
            } else {
                firstArray[i] = 0;
            }
        }
        for (int i = 0; i < firstArray.length; i++) {
            System.out.println("Index [" + i + "] after invert = " + firstArray[i]);
        }
    }

    // !2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить
    // !его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void oneHundred() {
        int[] secondArray = new int[100];
        secondArray[0] = 1;
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = i + 1;
        }
        for (int i = 0; i < secondArray.length; i++) {
            System.out.print("Index [" + i + "] = " + secondArray[i] + ", ");
        }
    }

    // !3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему
    // !циклом, и числа меньшие 6 умножить на 2;
    public static void multiTwo() {
        int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < thirdArray.length; i++) {
            if (thirdArray[i] < 6)
                thirdArray[i] = thirdArray[i] * 2;
        }
        for (int i = 0; i < thirdArray.length; i++) {
            System.out.println("Index [" + i + "] = " + thirdArray[i] + ", ");
        }
    }

    // !4. Создать квадратный двумерный целочисленный массив (количество строк и
    // !столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные
    // !элементы единицами (можно только одну из диагоналей, если обе сложно).
    // !Определить элементы одной из диагоналей можно по следующему принципу:
    // !индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static void diagDoubleArray() {
        int[][] doubleArray = new int[7][7];
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                if (i == j) {
                    doubleArray[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                System.out.print(doubleArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // !5. Написать метод, принимающий на вход два аргумента: len и initialValue, и
    // !возвращающий одномерный массив типа int длиной len, каждая ячейка которого
    // !равна initialValue;
    public static void createArray(int len, int initialValue) {
        int[] arrayTop = new int[len];
        for (int i = 0; i < arrayTop.length; i++) {
            arrayTop[i] = initialValue;
        }
        for (int i = 0; i < arrayTop.length; i++) {
            System.out.print(arrayTop[initialValue]);
        }
        System.out.println();

    }

    // !6. * Задать одномерный массив и найти в нем минимальный и максимальный
    // !элементы;
    public static void minMax(int[] thisArray) {
        int number = thisArray[0];

        for (int i = 0; i < thisArray.length; i++) {
            if (thisArray[i] < number) {
                number = thisArray[i];
            }
        }
        System.out.println("min = " + number);

        for (int i = 0; i < thisArray.length; i++) {
            if (thisArray[i] > number) {
                number = thisArray[i];
            }
        }
        System.out.println("max = " + number);
    }
}
