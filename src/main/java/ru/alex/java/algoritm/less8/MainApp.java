package ru.alex.java.algoritm.less8;

public class MainApp {
    public static void main(String[] args) {
        ChainHashTable hashTable = new  ChainHashTable(25);
        hashTable.insert(new Cat(10));
        hashTable.insert(new Cat(20));
        hashTable.insert(new Cat(30));
        hashTable.insert(new Cat(75));
        hashTable.insert(new Cat(40));
        hashTable.insert(new Cat(50));
        hashTable.insert(new Cat(60));
        hashTable.insert(new Cat(70));
        hashTable.insert(new Cat(1));
        hashTable.display();
        System.out.println(hashTable.delete(1));
        System.out.println(hashTable.delete(50));
        System.out.println(hashTable.delete(99));
        System.out.println(hashTable.find(75));
        hashTable.display();
        hashTable.insert(new Cat(1));
        hashTable.display();
    }
}
