package ru.alex.java.algoritm.less4;

import org.jetbrains.annotations.Nullable;

public class Iterator {
    private Node curr;
    private DoublyListQueue list;

    public Iterator(DoublyListQueue list) {
        this.list = list;
        this.curr = list.getTail();
        list.setIterator(this);
    }

    public void reset() {
        curr = list.getHead();
    }

    public boolean atEnd() {
        return (curr.getNext() == null);
    }

    /**
     * В случае если итератор на последнем значении
     * сработает reset;
     */
    public void nextNode() {
        if (curr.getNext() != null)
            curr = curr.getNext();
        else reset();
    }

    @Nullable
    public Node getCurrent() {
        return curr;
    }

    public void insertAfter(Cat cat) {
        Node newNode = new Node(cat);
        if (!list.isEmpty()) {
            if (curr.getNext() != null) {
                curr.getNext().setPrevious(curr);
            } else {
                list.setTail(newNode);
            }
            newNode.setNext(curr.getNext());
            newNode.setPrevious(curr);
            curr.setNext(newNode);
            nextNode();
        } else {
            list.setHead(newNode);
            list.setTail(newNode);
            curr = newNode;
        }
    }

    public void insertBefore(Cat cat) {
        Node newNode = new Node(cat);
        if (!list.isEmpty()) {
            if (curr.getPrevious() != null) {
                curr.getPrevious().setNext(newNode);
            } else {
                list.setHead(newNode);
            }
            newNode.setNext(curr);
            newNode.setPrevious(curr.getPrevious());
            curr.setPrevious(newNode);
        } else {
            list.setHead(newNode);
            list.setTail(newNode);
        }
        curr = newNode;
    }

    @Nullable
    public Cat deleteCurrent() {
        if (curr == null) return null;
        Cat cat = curr.getCat();
        if (curr.getPrevious() == null && curr.getNext() == null) {
            list.setHead(null);
            list.setTail(null);
            reset();
        } else if (curr.getPrevious() == null) {
            list.setHead(curr.getNext());
            curr.getNext().setPrevious(curr.getPrevious());
            reset();
        } else if (curr.getNext() == null) {
            list.setTail(curr.getPrevious());
            curr.getPrevious().setNext(curr.getNext());
            curr = curr.getPrevious();
        } else {
            curr.getPrevious().setNext(curr.getNext());
            curr.getNext().setPrevious(curr.getPrevious());
            curr = curr.getNext();
        }
        return cat;
    }
}