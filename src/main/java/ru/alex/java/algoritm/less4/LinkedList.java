package ru.alex.java.algoritm.less4;

public class LinkedList {
    private Node head;


    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Cat cat) {
        Node newNode = new Node(cat);
        newNode.setNext(head);
        this.head = newNode;
    }

    public Cat pop() {
        if (isEmpty()) return null;
        Cat cat = head.getCat();
        head = head.getNext();
        return cat;
    }

    public Cat peek() {
        if (isEmpty()) return null;
        return head.getCat();
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

    public Cat find(Cat cat) {
        Node curr = head;
        while (!curr.getCat().equals(cat)) {
            if (curr.getNext() == null) {
                return null;
            } else {
                curr = curr.getNext();
            }
        }
        return curr.getCat();
    }

    public Cat delete(Cat cat) {
        Node curr = head;
        Node prev = head;
        while (!curr.getCat().equals(cat)) {
            if (curr.getNext() == null) {
                return null;
            } else {
                prev = curr;
                curr = curr.getNext();
            }
        }
        if (curr == head) {
            head = head.getNext();
        } else {
            prev.setNext(curr.getNext());
        }
        return curr.getCat();
    }
}
