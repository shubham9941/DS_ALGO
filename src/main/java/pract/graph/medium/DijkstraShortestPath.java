package pract.graph.medium;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    int totalV;
    int[] vertex_weight;
    LinkedList<Integer>[] adj;
    int[][] edge_weight;

    DijkstraShortestPath(int totalV) {
        this.totalV = totalV;
        this.adj = new LinkedList[totalV];
        this.vertex_weight = new int[totalV];
        this.edge_weight = new int[totalV][totalV];

        for (int i = 0; i < totalV; i++) {
            adj[i] = new LinkedList<>();
            vertex_weight[i] = Integer.MAX_VALUE;
        }
    }

    void addEdge(int v, int u, int w) {
//        System.out.println("= came to add edge = from = " + v + " to = "  + u + " w = " + w );
        adj[v].add(u);
        adj[u].add(v);

        edge_weight[v][u] = w;
    }


    class QueueNode implements Comparable<QueueNode> {
        int v;
        int from;
        int to;

        QueueNode(int v, int from, int to) {
            this.v = v;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(QueueNode o) {
            if (vertex_weight[this.v] < vertex_weight[o.v]) {
                return -1;
            }
            return 1;
        }
    }


    // O(E+V) * Log V solution
    int[] findShortestPath(int startNode) {
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[totalV];
        vertex_weight[startNode] = 0;
        pq.add(new QueueNode(startNode, 0, 0));
        while (!pq.isEmpty()) {
            QueueNode node = pq.peek();
            visited[node.v] = true;
            Iterator<Integer> it = adj[node.v].iterator();
            while (it.hasNext()) {
                int next = it.next();
                if (!visited[next]) {
                    if (vertex_weight[next] == Integer.MAX_VALUE) {
                        pq.add(new QueueNode(next, node.v, next));
                    }

                    int total_weight = vertex_weight[node.v] + edge_weight[node.v][next];
                    if (total_weight < vertex_weight[next]) {
                        vertex_weight[next] = total_weight;
                    }
                }
            }
            pq.poll();

        }
        return vertex_weight;
    }



    // O(n^2) with less space
    int[] dijkstra(int graph[][], int src, int V) {
        int vetex_weight[] = new int[V]; // The output array. dist[i] will hold
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            vetex_weight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        vetex_weight[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(vetex_weight, visited , V);
            visited[u] = true;
            for (int v = 0; v < V; v++)
                if (!visited[v] && graph[u][v] != 0 && vetex_weight[u] != Integer.MAX_VALUE && vetex_weight[u] + graph[u][v] < vetex_weight[v])
                    vetex_weight[v] = vetex_weight[u] + graph[u][v];
        }

        return vetex_weight;
    }

    int minDistance(int vetex_weight[], Boolean visited[] , int V) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!visited[v]&& vetex_weight[v] <= min) {
                min = vetex_weight[v];
                min_index = v;
            }

        return min_index;
    }


    public static void main(String[] args) {


//        obj.addEdge(0,1,25);
//        obj.addEdge(0,3,7);
//        obj.addEdge(0,2,2);
//
//        obj.addEdge(2,1,5);
//        obj.addEdge(2,3,1);

        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        DijkstraShortestPath obj = new DijkstraShortestPath(graph.length);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {

                if (graph[i][j] != 0) {
                    obj.addEdge(i, j, graph[i][j]);
                }
            }
        }

        obj.findShortestPath(0);


    }
}
