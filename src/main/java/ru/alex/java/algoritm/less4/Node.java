package ru.alex.java.algoritm.less4;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
