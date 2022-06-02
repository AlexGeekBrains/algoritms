package ru.alex.java.algoritm.less3;

public class PriorityQueue {
    private int maxSize;
    private int[] queueArray;
    private int items;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        items = 0;
    }

    /**
     * чем выше число, тем выше приоритет.
     * Число с самым высоким приоритетом будет первым в очерди на выход.
     * @param elem
     */
    public void insert(int elem) {
        int i;
        if (isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            System.arraycopy(queueArray, 0, tmpArr, 0, items);
            queueArray = tmpArr;
            for (i = items - 1; i >= 0; i--) {
                if (elem < queueArray[i]) {
                    queueArray[i + 1] = queueArray[i];
                } else {
                    break;
                }
            }
            queueArray[i + 1] = elem;
            items++;
        } else if (items == 0) {
            queueArray[items++] = elem;
        } else {
            for (i = items - 1; i >= 0; i--) {
                if (elem < queueArray[i]) {
                    queueArray[i + 1] = queueArray[i];
                } else {
                    break;
                }
            }
            queueArray[i + 1] = elem;
            items++;
        }
    }

    public int remove() { // достаем с конца массива
        if (!isEmpty()) {
            return queueArray[--items];
        }
        throw new RuntimeException("Priority Queue is empty");
    }

    public long peek() {
        if (!isEmpty()) {
            return queueArray[items - 1];
        }
        throw new RuntimeException("Priority Queue is empty");
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }
}
