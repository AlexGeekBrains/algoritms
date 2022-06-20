package ru.alex.java.algoritm.less8;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private Cat cat;
    private Node next;
    private Node previous;

    public Node(Cat cat){
        this.cat = cat;
    }

    public Cat getValue(){
        return cat;
    }

    @Override
    public String toString() {
        return "Node{" +  "cat=" + cat;
    }
}
