package ru.alex.java.algoritm.less3;

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue(3);
        queue.insert(1);
        queue.insert(2);
        System.out.println(queue.remove());
        queue.insert(3);
        System.out.println(queue.remove());
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        System.out.println(queue.remove());

        PriorityQueue priorityQueue = new PriorityQueue(4);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);
        priorityQueue.insert(2);
        priorityQueue.insert(1);
        priorityQueue.insert(0);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());

        Deque deque = new Deque(4);
        deque.insertLeft(1);
        deque.insertLeft(3);
        deque.insertLeft(4);
        deque.insertRight(5);
        deque.insertLeft(6);
        deque.insertRight(7);
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        deque.insertLeft(8);
        deque.insertLeft(9);
        deque.insertRight(10);
        deque.insertRight(11);
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());

        Stack stack = new Stack(4);
        stack.check("public int removeLeft() {\n" +
                "        if (!isEmpty()) {\n" +
                "            if (head == maxSize) {\n" +
                "                head = 0;\n" +
                "            }\n" +
                "            int temp = deque[head++];\n" +
                "            head %= maxSize;\n" +
                "            items--;\n" +
                "            return temp;\n" +
                "        }\n" +
                "        throw new RuntimeException(\"Deque is empty\");\n" +
                "    }");
    }
}
