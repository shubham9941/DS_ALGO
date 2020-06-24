package pract.graph.easy;

// Here is graph implementation and BFS and DFS


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphWithBFSAndDFSTraverse {

    int totalVertex;

    LinkedList<Integer>[] arr;

    GraphWithBFSAndDFSTraverse(int totalV) {
        this.totalVertex = totalV;
        arr = new LinkedList[totalV];
        for (int i = 0; i < totalV; i++) {
            arr[i] = new LinkedList<Integer>();
        }
    }

    // This is for directed graph
    void addEdge(int v, int w) {
        arr[v].add(w); // This is for directed cycle, if there is no directed graph then we have to add arr[W].add(v)
    }


    void BFS(int startNode) {
        boolean[] isVisited = new boolean[totalVertex];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(startNode);
        isVisited[startNode] = true;

        while (!qu.isEmpty()) {
            int ele = qu.poll();
            System.out.print(ele + " ");
            Iterator<Integer> adj = arr[ele].iterator();
            while (adj.hasNext()) {
                int connectedNode = adj.next();
                if (!isVisited[connectedNode]) {
                    qu.add(connectedNode);
                    isVisited[connectedNode] = true;
                }
            }
        }
    }

    void printDFSUntil(int startNode , boolean[]isVisited){
        System.out.print(startNode + " ");
        Iterator<Integer> it = arr[startNode].iterator();

        while (it.hasNext()){
            int next = it.next();
            if(!isVisited[next]){
                isVisited[next] = true;
                printDFSUntil(next , isVisited);
            }
        }
    }

    void DFS(int startNode){
        boolean[] isVisited = new boolean[totalVertex];
        isVisited[startNode] = true;

        printDFSUntil(startNode , isVisited);
    }


    public static void main(String[] args) {

        GraphWithBFSAndDFSTraverse g = new GraphWithBFSAndDFSTraverse(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

//        g.BFS(2);
        g.DFS(2);

    }

}
