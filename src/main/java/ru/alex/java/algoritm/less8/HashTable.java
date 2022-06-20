package ru.alex.java.algoritm.less8;

public class HashTable {
    private Cat[] hashArr;
    private int arrSize;
    private Cat nonItem;

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Cat[arrSize];
        nonItem = new Cat(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null)
                System.out.print(hashArr[i].getAge() + " ");
            else
                System.out.print(" * ");
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public void insert(Cat cat) {
        int hashVal = hashFunc(cat.getAge());
        while (hashArr[hashVal] != null && hashArr[hashVal].getAge() != -1) {
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = cat;
    }

    public Cat delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getAge() == key) {
                Cat temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Cat find(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getAge() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }
}