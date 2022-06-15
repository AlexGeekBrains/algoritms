package ru.alex.java.algoritm.less7;

public class MainApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('J');
        graph.addVertex('L');
        graph.addVertex('O');
        graph.addVertex('M');
        graph.addVertex('K');

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'J');
        graph.addEdge('E', 'L');
        graph.addEdge('F', 'K');
        graph.addEdge('J', 'O');
        graph.addEdge('L', 'M');
        graph.addEdge('O', 'K');
        graph.addEdge('M', 'K');
        graph.addEdge('B', 'F');
        graph.addEdge('L', 'D');
        graph.addEdge('M', 'K');

//        graph.depthTraverse();
//        graph.widthTraverse();

        graph.getWay('A', 'D');
    }
}
