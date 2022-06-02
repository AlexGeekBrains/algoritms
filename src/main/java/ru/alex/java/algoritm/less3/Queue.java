package ru.alex.java.algoritm.less3;

public class Queue {
    private int maxSize;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Queue(int s) {
        maxSize = s;
        queue = new int[maxSize];
        head = 0;
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

    public void insert(int i) {
        if (isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            if (tail >= head) {
                System.arraycopy(queue, 0, tmpArr, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
                System.arraycopy(queue, head, tmpArr,
                        maxSize - (queue.length - head), queue.length - head);
                head = tmpArr.length - (queue.length - head); // поправил код с урока
            }
            queue = tmpArr;  //на уроке не переназначили ссылку на массив
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }
        queue[++tail] = i;
        ++items;
    }

    public int remove() {
       if(!isEmpty()){
           int temp = queue[head++];
           head %= maxSize;
           items--;
           if (isEmpty()) {
               tail = -1;
               head = 0;
           }
           return temp;
       }
        throw new RuntimeException("Queue is empty");
    }

    public int peek() {
        return queue[head];
    }
}