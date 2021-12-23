package lesson;

public class Lesson1 {
    public static void main(String[] args) {

        // Напечатайте в кавычках три слова которые хотите вывести в терминал
        printThreeWords("Orange", "Banana", "Apple");

        // Напечатайте 2 числа, чтобы узнать положительна или отрицательна их сумма
        checkSumSign(-11, 10);

        // Напечатайте любое число и узнаете в какую цветовую зону оно входит
        printColor(-100);

        // Напечатайте 2 числа и узнайте какое больше
        compareNumbers(500, 100);

    }

    // Метод для печати в терминале трех слов
    public static void printThreeWords(String name1, String name2, String name3) {
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
    }

    // Метод для определения знака (+/-) их суммы
    public static void checkSumSign(int a, int b) {
        int result = a + b;
        if (result >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Метод для определения цветовой зоны числа
    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Метод для сравнения двух чисел
    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else
            System.out.println("a < b");
    }
}
