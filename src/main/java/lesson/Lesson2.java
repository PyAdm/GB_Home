package lesson;


public class Lesson2 {
    public static void main(String[] args) {

        if (checkLimit(5, -10)) {
            System.out.println("Summ between 10 and 20");
        } else {
            System.out.println("Summ isn`t limit");
        }

        System.out.println("***************");

        if (checkTypeNumber(-2)) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }

        System.out.println("***************");

        System.out.println(checkTypeNumber2(-2));

        System.out.println("***************");

        printText("Hello", 5);

        System.out.println("***************");

        System.out.println(printTypeYear(1900));

        System.out.println("***************");

    }

    // !1. Написать метод, принимающий на вход два целых числа и проверяющий, что их
    // !сумма лежит в пределах от 10 до 20 (включительно),
    // !если да – вернуть true, в противном случае – false.

    public static boolean checkLimit(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    // !2. Написать метод, которому в качестве параметра передается целое число,
    // !метод должен напечатать в консоль, положительное ли число передали или
    // !отрицательное. Замечание: ноль считаем положительным числом.

    public static boolean checkTypeNumber(int number) {
        return (number >= 0);
    }

    // !3. Написать метод, которому в качестве параметра передается целое число.
    // !Метод должен вернуть true, если число отрицательное, и вернуть false если
    // !положительное.

    public static boolean checkTypeNumber2(int number) {
        return (number < 0);
    }

    // !4. Написать метод, которому в качестве аргументов передается строка и число,
    // !метод должен отпечатать в консоль указанную строку, указанное количество
    // !раз;

    public static void printText(String text, int repeat) {
        for (int i = 1; i <= repeat; i++) {
            System.out.println(text);
        }
    }

    // !Написать метод, который определяет, является ли год високосным, и возвращает
    // !boolean (високосный - true, не високосный - false). Каждый 4-й год является
    // !високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean printTypeYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

}

