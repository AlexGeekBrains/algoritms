package ru.alex.java.algoritm.less7;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vertex {
    private char label;
    private boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    @Override
    public String toString() {
        return "Vertex(" + label +')';
    }
}
