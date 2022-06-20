package ru.alex.java.algoritm.less8;


import org.jetbrains.annotations.Nullable;

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

    @Nullable
    public Cat pop() {
        if (isEmpty()) return null;
        Cat cat = head.getCat();
        head = head.getNext();
        return cat;
    }

    @Nullable
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

    @Nullable
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

    @Nullable
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