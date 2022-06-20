package ru.alex.java.algoritm.less8;

import org.jetbrains.annotations.Nullable;

public class ChainHashTable {
    private LinkedList[] hashArr;
    private int arrSize;

    public ChainHashTable(int size) {
        this.arrSize = size;
        hashArr = new LinkedList[arrSize];
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null)
                System.out.print(hashArr[i]);
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
        if (hashArr[hashVal] == null) {
            hashArr[hashVal] = new LinkedList();
        }
        hashArr[hashVal].push(cat);
    }

    @Nullable
    public Cat delete(int key) {
        int hashVal = hashFunc(key);
        if (hashArr[hashVal] != null)
            return hashArr[hashVal].delete(new Cat(key));
        else
            return null;
    }

    @Nullable
    public Cat find(int key) {
        int hashVal = hashFunc(key);
        if (hashArr[hashVal] != null)
            return hashArr[hashVal].find(new Cat(key));
        else
            return null;
    }
}
