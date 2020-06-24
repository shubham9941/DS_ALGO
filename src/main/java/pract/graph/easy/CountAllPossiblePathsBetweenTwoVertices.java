package pract.graph.easy;

import java.util.Iterator;
import java.util.LinkedList;

public class CountAllPossiblePathsBetweenTwoVertices {

    LinkedList<Integer>[] adj;
    int totalV;

    CountAllPossiblePathsBetweenTwoVertices(int totalV) {
        this.totalV = totalV;
        this.adj = new LinkedList[totalV];
        for (int i = 0; i < totalV; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    static int count = 0;

    int countPaths(int from, int to) {
        if (from == to) {
            count++;
        }
        Iterator<Integer> it = adj[from].iterator();
        while (it.hasNext()) {
            countPaths(it.next(), to);
        }
        return count;
    }

    public static void main(String[] args) {

        CountAllPossiblePathsBetweenTwoVertices g = new CountAllPossiblePathsBetweenTwoVertices(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(4, 2);

        int s = 0, d = 3;
        System.out.print(g.countPaths(s, d));

    }
}
