package ru.alex.java.algoritm.less2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(new int[]{9, 8, 12,4, 1, 41, 5, 1, 3, 7});
        arr.display();
        arr.improvedSortBubble();
        arr.display();
        arr.insert(3,111);
        arr.display();
    }
}
