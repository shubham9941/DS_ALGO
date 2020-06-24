package pract.graph.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        Edge() {

        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight < o.weight) {
                return -1;
            }
            return 1;
        }
    }

    int V;
    int E;
    Edge[] edge;
    int[] subset;

    MinimumSpanningTree(int V, int E) {
        this.V = V;
        this.E = E;
        this.edge = new Edge[E];
        this.subset = new int[V];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
        for (int i = 0; i < V; i++) {
            subset[i] = i;
        }
    }

    private int root(int i) {
        while (subset[i] != i) i = subset[i];
        return i;
    }

    boolean isConnected(int i, int j) {
        return (root(i) == root(j));
    }

    void connect(int i, int j) {
        subset[root(i)] = root(j);
    }

    void KruskalMST() {
        Edge[] result = new Edge[V - 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Arrays.asList(edge));
        int e = 0;
        int r = 0;
        while (e < V - 1 && !pq.isEmpty()) {
            Edge elem = pq.poll();
            if (!isConnected(elem.src, elem.dest)) {
                e++;
                connect(elem.src, elem.dest);
                result[r++] = elem;
            }
        }
        for(int i = 0 ; i < result.length ; i++){
            System.out.println(result[i].src+" -- " +
                    result[i].dest+" == " + result[i].weight);
        }
    }


    public static void main(String[] args) {

        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph

        MinimumSpanningTree graph = new MinimumSpanningTree(V, E);
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.KruskalMST();



    }
}
