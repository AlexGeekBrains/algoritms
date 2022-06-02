package ru.alex.java.algoritm.less3;

public class Deque {
    private int maxSize;
    private int[] deque;
    private int head;
    private int tail;
    private int items;

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        deque = new int[this.maxSize];
        head = this.maxSize;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void insertLeft(int i) {
        if (head - 1 == tail && isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            System.arraycopy(deque, 0, tmpArr, 0, tail + 1);
            System.arraycopy(deque, head, tmpArr, tmpArr.length - (deque.length - head), deque.length - head);
            head = tmpArr.length - (deque.length - head);
            tmpArr[--head] = i;
            items++;
            deque = tmpArr;
        } else if (head - 1 == -1 && tail != maxSize - 1) {
            head = maxSize;
            deque[--head] = i;
            items++;
        } else if (head - 1 == -1 && tail == maxSize - 1) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            System.arraycopy(deque, 0, tmpArr, 0, deque.length);
            head = maxSize;
            tmpArr[--head] = i;
            items++;
            deque = tmpArr;
        } else {
            deque[--head] = i;
            items++;
        }
    }

    public void insertRight(int i) {
        if (tail + 1 == head && isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            System.arraycopy(deque, 0, tmpArr, 0, tail + 1);
            System.arraycopy(deque, head, tmpArr, tmpArr.length - (deque.length - head), deque.length - head);
            head = tmpArr.length - (deque.length - head);
            tmpArr[++tail] = i;
            items++;
            deque = tmpArr;
        } else if (tail + 1 == maxSize && head != 0) {
            tail = -1;
            deque[++tail] = i;
            items++;
        } else if (tail + 1 == maxSize && head == 0) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            System.arraycopy(deque, 0, tmpArr, 0, deque.length);
            tmpArr[++tail] = i;
            items++;
            deque = tmpArr;
        } else {
            deque[++tail] = i;
            items++;
        }
    }

    public int removeLeft() {
        if (!isEmpty()) {
            if (head == maxSize) {
                head = 0;
            }
            int temp = deque[head++];
            items--;
            return temp;
        }
        throw new RuntimeException("Deque is empty");
    }

    public int removeRight() {
        if (!isEmpty()) {
            if (tail == -1) {
                tail = maxSize - 1;
            }
            int temp = deque[tail--];
            items--;
            return temp;
        }
        throw new RuntimeException("Deque is empty");
    }

    public int peekRight() {
        if (!isEmpty()) {
            if (tail == -1) {
                tail = maxSize - 1;
            }
            return deque[tail];
        }
        throw new RuntimeException("Deque is empty");
    }

    public int peekLeft() {
        if (!isEmpty()) {
            if (head == maxSize) {
                head = 0;
            }
            return deque[head];
        }
        throw new RuntimeException("Deque is empty");
    }
}