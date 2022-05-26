package ru.alex.java.algoritm;

public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println(exponentiation(8, 3));
        System.out.println(exponentiationWithParity(8, 4));
        sumFromZeroToOneHundred();
        sumFromZeroToOneHundredVersionTwo();
    }

    //1. возведение в степень
    public static long exponentiation(int base, int exponent) {
        long variable = 1;
        for (int i = 0; i < exponent; i++) {
            variable *= base;
        }
        return variable;
    }

    //2. возведение в степень (с использованием свойства чётности степени)
    public static long exponentiationWithParity(int base, int exponent) {
        long variable = 1;
        if (exponent % 2 == 0) {
            for (int i = 0; i < exponent / 2; i++) {
                variable *= base;
            }
            variable *= variable;
        } else {
            for (int i = 0; i < exponent; i++) {
                variable *= base;
            }
        }
        return variable;
    }

    //3. получить сумму всех чисел в ряду от 0 до 100.
    public static void sumFromZeroToOneHundred() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void sumFromZeroToOneHundredVersionTwo() {
        int sum = 0;
        for (int i = 0, j = 100; i <= 50; i++, j--) {
            if (i != 50) {
                sum += i + j;
            } else {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}