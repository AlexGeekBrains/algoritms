package ru.alex.java.algoritm.less7;

import ru.alex.java.algoritm.less3.Queue;

import java.util.*;

public class Graph {
    private final static int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack<Integer> stack;
    private Queue queue;
    private LinkedList<Vertex> way;
    private Map<Vertex, Vertex> map;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(char start, char end) {
        adjMat[getVertex(start)][getVertex(end)] = 1;
        adjMat[getVertex(end)][getVertex(start)] = 1;
    }

    public void displayAdj() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getVertex(char vertexChar) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (vertexList[i].getLabel() == vertexChar) {
                a = i;
            }
        }
        if (a != -1) return a;
        else throw new RuntimeException("vertexChar not found");
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex]);
    }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && !vertexList[i].isWasVisited()) {
                return i;
            }
        }
        return -1;
    }

    public void depthTraverse() {
        stack = new Stack<>();
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].setWasVisited(false);
        }
    }

    public void widthTraverse() {
        queue = new Queue(size);
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        queue.insert(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].setWasVisited(true);
                displayVertex(v2);
                queue.insert(v2);
            }
        }
        for (int i = 0; i < size; i++)
            vertexList[i].setWasVisited(false);
    }

    public void getWay(char start, char end) {
        map = new HashMap<>();
        queue = new Queue(size);
        vertexList[getVertex(start)].setWasVisited(true);
        queue.insert(getVertex(start));
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].setWasVisited(true);
                queue.insert(v2);
                map.put(vertexList[v2], vertexList[v1]);
                if (vertexList[v2].getLabel() == end) break;
            }
        }
        way = new LinkedList<>();
        Vertex v = map.get(vertexList[getVertex(end)]);
        while (v != null) {
            way.addFirst(v);
            v = map.remove(v);
        }
        if (!way.isEmpty()) {
            way.add(vertexList[getVertex(end)]);
            System.out.println(way);
        } else System.out.println("Couldn't get a route");
        for (int i = 0; i < size; i++)
            vertexList[i].setWasVisited(false);
    }
}
