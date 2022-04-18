package lesson;

//Импортируем библиотеки для выбора рандомных чисел и для ввода с входных данных

import java.util.Random;
import java.util.Scanner;

public class Lesson4_XO {
    //Определяем константы
    public static int S = 5; //Указываем размер карты
    public static int V = 4; //Указываем сколько знаков в линию нужно для победы
    public static char E = '•'; //Указываем символ для обозначения пустых ячеек (Символ "Пустота")
    public static char X = 'X'; //Указываем символ для обозначения ходов человека
    public static char O = 'O'; //Указываем символ для обозначения ходов компьютера
    public static char[][] map; //Массив в который будем помещать карту
    public static Scanner sc = new Scanner(System.in); //Метод для ввода координат хода человеком
    public static Random rand = new Random(); //Метод генерации рандомных цифр

    public static void main(String[] args) {
        //Начало игры
        //Вызываем метод который заполнит массив, то есть создат карту
        createMap(); //Вызываем метод создания карты
        showMap(); //Вызываем метод отображения текущего состояния массива (карты)
        while (true) { //Начинаем цикл поочередных ходов человека и ПК, выход из которого возможен только когда один победит или будет ничья
            moveHuman(); //Вызываем метод хода человека
            showMap(); //Вызываем метод отображения текущего состояния массива (карты)
            if (checkVictory(X)) { //Вызываем метод проверки условий победы
                System.out.println("Победил Человек");
                break;
            }
            if (accessMap()) { //Вызываем метод проверки доступности карты, то есть наличия пустых ячеек, если он сработал, значит победителя не будет
                System.out.println("Ничья");
                break;
            }
            movePC(); //Вызываем метод хода компьютера
            showMap();
            // После каждого хода проверяются условия победы
            if (checkVictory(O)) { //Вызываем метод проверки условий победы
                System.out.println("Победил Компьютер");
                break;
            }
            if (accessMap()) { //Вызываем метод проверки доступности карты, то есть наличия пустых ячеек, если он сработал, значит победителя не будет
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    //Метод создания карты
    public static void createMap() {
        map = new char[S][S]; //создаем двумерный массив с равными сторонами
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                map[i][j] = E; //заполняем все ячейки массива символом "Пустота"
            }
        }
    }

    //Метод отображения текущего состояния массива (карты)
    public static void showMap() {
        for (int i = 0; i <= S; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < S; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < S; j++) {
                System.out.print(map[i][j] + " ");
            }
            //Благодаря переносам, массив отобразится в виде таблицы с упорядоченными сторонами
            System.out.println();
        }
        System.out.println();
    }

    //Метод хода человека
    public static void moveHuman() {
        int x, y;
        do {
            System.out.println("Введите координаты Вашего хода в формате X Y");
            x = sc.nextInt() - 1; //От координаты X отнимаем единицу, так как в массиве нумерация начинается с нуля
            y = sc.nextInt() - 1; //От координаты Y отнимаем единицу, так как в массиве нумерация начинается с нуля
        } while (!checkCell(x, y));
        map[y][x] = X;//вносим ход человека в массив
    }

    //Метод хода компьютера
    public static void movePC() {
        int x, y;
        do {
            x = rand.nextInt(S); //Генерируем число для координаты X
            y = rand.nextInt(S); //Генерируем число для координаты Y
        } while (!checkCell(x, y)); //дописать проверку правильности введенного числа
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1)); //К координатам X, Y добавляем единицу, так как в массиве нумерация начинается с нуля
        map[y][x] = O; //вносим ход компьютера в массив
    }

    //Метод определения победы -
    // Можно проверять просчитывать количества одинаковых знаков по диагонали, вертикали и горизонтали
    public static void checkVictory() {
        int diag = 0;

        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;
    }
//Метод определения, что карта полная - проходим циклом по всему массиву и ищем пустые поля, если их нет то карта полная
    public static boolean accessMap() {
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                if (map[i][j] == E) return false; //Нашлась хоть одна ячейка с пустотой, возвращем false, то есть карта еще доступна для ходов
            }
        }
        return true; //Пустые ячейки закончились, карта больше не доступна для ходов
    }

//Метод, проверяющий подходит ли координата. Подходящими будут только пустые ячейки
    public static boolean checkCell(int x, int y) {
        if (x < 0 || x >= S || y < 0 || y >= S) return false;
        if (map[y][x] == E) return true;
        return false;
    }


}



