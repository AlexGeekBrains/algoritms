package ru.alex.java.algoritm.less4;

public class DoublyListDeque {
    private Node head;
    private Node tail;

    public DoublyListDeque() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertLeft(Cat cat) {
        Node newNode = new Node(cat);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            head.setPrevious(newNode);
        }
        newNode.setNext(head);
        this.head = newNode;
    }

    public void insertRight(Cat cat) {
        Node newNode = new Node(cat);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious(tail);
        this.tail = newNode;
    }

    public Cat removeLeft() {
        if (isEmpty()) return null;
        Cat cat = head.getCat();
        head = head.getNext();
        head.setPrevious(null);
        return cat;
    }

    public Cat removeRight() {
        if (isEmpty()) return null;
        Cat cat = tail.getCat();
        tail = tail.getPrevious();
        tail.setNext(null);
        return cat;
    }

    public Cat delete(Cat cat) {
        Node curr = head;
        while (!curr.getCat().equals(cat)) {
            if (curr.getNext() == null)
                return null;
            else
                curr = curr.getNext();
        }
        if (curr == head) {
            head = head.getNext();
            head.setPrevious(null);
        } else if (curr == tail) {
            tail = tail.getPrevious();
            tail.setNext(null);
        } else {
            curr.getPrevious().setNext(curr.getNext());
            curr.getNext().setPrevious(curr.getPrevious());
        }
        return curr.getCat();
    }

    public Cat peekHead() {
        if (isEmpty()) return null;
        return head.getCat();
    }

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