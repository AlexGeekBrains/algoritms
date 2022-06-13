package ru.alex.java.algoritm.less6;

public class Main {
    public static void main(String[] args) {
// Создать и запустить программу для построения двоичного дерева. В цикле построить двести деревьев из 100 элементов.
// Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int. Число, которое попадает
// в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.

        Tree[] arr = new Tree[200];
        double imbalance = 0;

        for (int i = 0; i < 200; i++) {
            arr[i] = new Tree();
            for (int j = 0; j < 100; j++) {
                arr[i].insert(new Cat("Tishka " + j, (int) (Math.random() * 201 - 100)));
            }
            if (!arr[i].checkBalance())
                imbalance++;
        }

// Проанализировать, какой процент созданных деревьев являются несбалансированными.

        System.out.println(imbalance);
        System.out.println(100 / (200 / imbalance));
    }
}

