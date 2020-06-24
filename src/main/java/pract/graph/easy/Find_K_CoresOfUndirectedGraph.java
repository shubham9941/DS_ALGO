package pract.graph.easy;

import java.util.Iterator;
import java.util.LinkedList;

public class Find_K_CoresOfUndirectedGraph {

    int totalV;
    LinkedList<Integer>[] adj;

    Find_K_CoresOfUndirectedGraph(int totalV) {
        this.totalV = totalV;
        this.adj = new LinkedList[totalV];
        for (int i = 0; i < totalV; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
    }

    void DFSUtil(int v, int[] degree, boolean[] visited, int k) {
        if (degree[v] < k) {
            visited[v] = true;
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()) {
                int next = it.next();
                if (!visited[next]) {
                    degree[next]--;
                    DFSUtil(next, degree, visited, k);
                }
            }
        }
    }

    void printKCores(int k) {

        boolean[] visited = new boolean[totalV];
        int[] degree = new int[totalV];

        int minDegree = Integer.MAX_VALUE;
        int startVertex = 0;

        for (int i = 0; i < totalV; i++) {
            int size = adj[i].size();
            degree[i] = size;
            if (minDegree > size) {
                minDegree = size;
                startVertex = i;
            }
        }

        DFSUtil(startVertex, degree, visited, k);

        for (int i = 0; i < totalV; i++) {
            if (!visited[i]) {
                DFSUtil(i, degree, visited, k);
            }
        }

        for (int i = 0; i < totalV; i++) {
            if (degree[i] >= k) {
                System.out.print("["+i+"]" + " -> ");
                Iterator<Integer> it = adj[i].iterator();
                while (it.hasNext()) {
                    int next = it.next();
                    if (degree[next] >= k) {
                        System.out.print(next + " -> ");
                    }
                }
                System.out.println();
            }

        }
    }


    public static void main(String[] args) {

        Find_K_CoresOfUndirectedGraph g1 = new Find_K_CoresOfUndirectedGraph(9);
        int k = 3;
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(2, 6);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(3, 7);
        g1.addEdge(4, 6);
        g1.addEdge(4, 7);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);
        g1.printKCores(k);

    }
}
