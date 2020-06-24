package pract.graph.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleInInDirectGraph {
    int totalV;
    LinkedList<Integer>[] adj;

    DetectCycleInInDirectGraph(int totalV) {
        this.totalV = totalV;
        this.adj = new LinkedList[totalV];
        for (int i = 0; i < totalV; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }

    boolean isCyclicUsingDFS(int str, int p, boolean[] visited) {
        visited[str] = true;

        Iterator<Integer> it = adj[str].iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (next == str) {
                return true;
            }

            if (next != p) {
                if (!visited[next]) {
                    if (isCyclicUsingDFS(next, str, visited)) {
                        return true;
                    }

                } else {
                    return true;
                }
            }


        }
        return false;
    }

    int isCyclic() {
        boolean[] visited = new boolean[totalV];
        for (int i = 0; i < totalV; i++) {
            if (!visited[i]) {
                if (isCyclicUsingDFS(i, -1, visited)) {
                    return 1;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 46;

        DetectCycleInInDirectGraph g = new DetectCycleInInDirectGraph(n);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);


        System.out.println(g.isCyclic());

    }
}
