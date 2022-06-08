package ru.alex.java.algoritm.less5;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(exponentiation(2, 8));
        print(10);
        fromAToB(10, 30);
        System.out.println(sum(5));
        System.out.println(sumNumber(123));
    }

    // Написать программу по возведению числа в степень с помощью рекурсии.
    public static long exponentiation(int base, int exponent) {
        if (exponent == 1) {
            return base;
        } else if (exponent == 0) {
            return 1;
        }
        return base * exponentiation(base, exponent - 1);
    }

    //Дано натуральное число n. Выведите все числа от 0 до n.
    public static void print(int a) {
        if (a == 0) {
            System.out.println(a);
        } else {
            print(a - 1);
            System.out.println(a);

        }
    }

    //Даны два целых числа A и В (каждое в отдельной строке).
    // Выведите все числа от A до B включительно, в порядке возрастания,
    // если A < B, или в порядке убывания в противном случае.

    public static void fromAToB(int a, int b) {
        if (a == b) {
            System.out.println(a);
        } else if (a < b) {
            System.out.println(a);
            fromAToB(a + 1, b);
        } else {
            System.out.println(a);
            fromAToB(a-1, b );
        }
    }

    //Сумма чисел
    public static int sum(int a) {
        if (a == 0) {
            return a;
        } else return a + sum(a - 1);
    }

    //Дано натуральное число N. Вычислите сумму его цифр.
    //При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
    public static int sumNumber(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + sumNumber(n / 10);
        }
    }

}
