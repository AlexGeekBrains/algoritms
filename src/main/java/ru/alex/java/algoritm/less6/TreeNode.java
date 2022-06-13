package ru.alex.java.algoritm.less6;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    private Cat cat;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return String.format("TN(%s)", cat);
    }
}
