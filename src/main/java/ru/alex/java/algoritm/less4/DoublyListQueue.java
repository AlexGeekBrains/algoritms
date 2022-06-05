package ru.alex.java.algoritm.less4;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
public class DoublyListQueue {
    private Node head;
    private Node tail;
    private Iterator iterator;

    public DoublyListQueue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Cat cat) {
        Node newNode = new Node(cat);
        newNode.setNext(head);

        if (isEmpty()) {
            this.tail = newNode;
        } else {
            head.setPrevious(newNode);
        }
        this.head = newNode;
        if (iterator != null) {
            if (iterator.getCurrent() == null)
                iterator.reset();
        }
    }


    /**
     * Если итератор находится на удаляемой позиции
     * сработает reset
     */
    @Nullable
    public Cat remove() {
        if (isEmpty()) return null;
        Cat cat = tail.getCat();
        if (iterator != null) {
            if (iterator.getCurrent() == tail)
                iterator.reset();
        }
        tail = tail.getPrevious();
        if (tail != null)
            tail.setNext(null);
        return cat;
    }

    /**
     * Если итератор находится на удаляемой позиции
     * сработает reset
     */
    @Nullable
    public Cat delete(Cat cat) {
        Node curr = head;
        while (!curr.getCat().equals(cat)) {
            if (curr.getNext() == null)
                return null;
            else
                curr = curr.getNext();
        }
        if (curr == head && curr == tail) {
            head = null;
            tail = null;
        } else if (curr == head) {
            head = head.getNext();
            head.setPrevious(null);
        } else if (curr == tail) {
            tail = tail.getPrevious();
            tail.setNext(null);
        } else {
            curr.getPrevious().setNext(curr.getNext());
            curr.getNext().setPrevious(curr.getPrevious());
        }
        if (iterator != null){
            if (iterator.getCurrent()==curr)
                iterator.reset();
        }
        return curr.getCat();
    }

    @Nullable
    public Cat peekTail() {
        if (isEmpty()) return null;
        return tail.getCat();
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.getNext();
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }
}