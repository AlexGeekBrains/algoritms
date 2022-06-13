package ru.alex.java.algoritm.less6;


public class Tree {
    private TreeNode root;

    public Tree() {
        root = null;
    }

    public void insert(Cat c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (c.getAge() < current.getCat().getAge()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else if (c.getAge() > current.getCat().getAge()) {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(node);
                        return;
                    }
                } else {
                    return;
                }
            }

        }
    }

    public Cat find(int age) {
        TreeNode current = root;
        while (current.getCat().getAge() != age) {
            if (age < current.getCat().getAge())
                current = current.getLeftChild();
            else
                current = current.getRightChild();

            if (current == null)
                return null;
        }
        return current.getCat();
    }

    private void inOrderTravers(TreeNode current) {
        if (current != null) {
            System.out.println(current);
            inOrderTravers(current.getLeftChild());
            inOrderTravers(current.getRightChild());
        }
    }


    //вычисляем глубину дерева
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left_Depth = maxDepth(root.getLeftChild());
        int right_Depth = maxDepth(root.getRightChild());
        int bigger = Math.max(left_Depth, right_Depth);
        return bigger + 1;
    }

    // проверяем дерево на сбалансированность.
    public Boolean checkBalance() {
        if (root == null)
            return true;
        else {
            int biggerLeft = maxDepth(root.getLeftChild());
            int biggerRight = maxDepth(root.getRightChild());
            return Math.abs(biggerLeft - biggerRight) <= 1;
        }
    }


    public void displayTree() {
        inOrderTravers(root);
    }

    public boolean delete(int age) {
        TreeNode curr = root;
        TreeNode prev = root;
        boolean isLeftChild = true;
        while (curr.getCat().getAge() != age) {
            prev = curr;
            if (age < curr.getCat().getAge()) {
                isLeftChild = true;
                curr = curr.getLeftChild();
            } else {
                isLeftChild = false;
                curr = curr.getRightChild();
            }
            if (curr == null)
                return false;
        }

        if (curr.getLeftChild() == null && curr.getRightChild() == null) {
            if (curr == root) {
                root = null;
            } else if (isLeftChild) {
                prev.setLeftChild(null);
            } else {
                prev.setRightChild(null);
            }
        } else if (curr.getRightChild() == null) {
            if (isLeftChild) {
                prev.setLeftChild(curr.getLeftChild());
            } else {
                prev.setRightChild(curr.getLeftChild());
            }
        } else if (curr.getLeftChild() == null) {
            if (isLeftChild) {
                prev.setLeftChild(curr.getRightChild());
            } else {
                prev.setRightChild(curr.getRightChild());
            }
        } else {
            TreeNode successor = getSuccessor(curr);
            if (curr == root) {
                root = successor;
            } else if (isLeftChild) {
                prev.setLeftChild(successor);
            } else {
                prev.setRightChild(successor);
            }
            successor.setLeftChild(curr.getLeftChild());
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode deleted) {
        TreeNode successorParent = deleted;
        TreeNode successor = deleted;
        TreeNode flag = deleted.getRightChild();

        while (flag != null) {
            successorParent = successor;
            successor = flag;
            flag = flag.getLeftChild();
        }
        if (successor != deleted.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deleted.getRightChild());
        }
        return successor;
    }
}

