package fromTreesDay16;

import java.util.*;

public class GraphSimpleUnidirectional {
    private Map<Integer, List<Integer>> adjList;

    public GraphSimpleUnidirectional() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);  
    }

    public void printConnections() {
        for (int node : adjList.keySet()) {
            System.out.print("Node " + node + " is connected to: ");
            for (int neighbor : adjList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    	GraphSimpleUnidirectional g = new GraphSimpleUnidirectional();

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        g.printConnections();
    }
}


