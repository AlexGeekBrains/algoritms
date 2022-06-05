package ru.alex.java.algoritm.less4;

public class MainApp {
    public static void main(String[] args) {

        DoublyListQueue queue = new DoublyListQueue();
        Iterator iterator = new Iterator(queue);
        System.out.println(iterator.deleteCurrent());
        queue.insert(new Cat("Barsik", 12));
        iterator.insertAfter(new Cat("Tishka", 3));
        System.out.println(iterator.getCurrent());
        System.out.println(queue.delete(new Cat("Tishka", 3)));
        System.out.println(iterator.getCurrent());
        iterator.insertBefore(new Cat("Valera",1));
        System.out.println(iterator.getCurrent());
        System.out.println(queue);
        System.out.println(iterator.atEnd());
        iterator.nextNode();
        iterator.nextNode();
        System.out.println(iterator.getCurrent());
        iterator.nextNode();
        iterator.deleteCurrent();
        System.out.println(queue.getTail());
        System.out.println(queue.peekTail());
        System.out.println(iterator.getCurrent());
        iterator.insertAfter(new Cat("Maximus",5));
        System.out.println(queue.getTail());
        System.out.println(queue);
    }
}
