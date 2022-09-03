package pract.graph.medium;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraph {
    int totalV;
    LinkedList<Integer>[] adj;

    DetectCycleInDirectedGraph(int totalV) {
        this.totalV = totalV;
        this.adj = new LinkedList[totalV];
        for (int i = 0; i < totalV; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int u) {
        adj[v].add(u);
    }

    //Use this or look at GFG code also good approach
    boolean isCyclicUsingDFS(int str, int[] visited) {
        visited[str] = 0;

        Iterator<Integer> it = adj[str].iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (visited[next] != 1) {
                if (visited[next] == 0) {
                    return true;
                }
                if(isCyclicUsingDFS(next, visited)){
                    return true;
                }
            }
        }
        visited[str] = 1;
        return false;
    }

    boolean isCyclicUsingBFS(int str, int[] visited) {
        Queue<Integer> qu = new LinkedList<Integer>();
        visited[str] = -1;
        qu.add(str);
        while (!qu.isEmpty()){
            Iterator<Integer> it = adj[qu.poll()].iterator();
            while (it.hasNext()){
                int next = it.next();
                if(visited[next]!=-1){
                    if(visited[next]!=1){
                        visited[next] = 1;
                        qu.add(next);
                    }
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

    // using DFS and have 3 values in visited like -1 , 0 , 1 (-1 not visited ,  0 visited , 1 no more adj after visited)
    int detectCycleUsingDFS() {
        int[] visited = new int[totalV];
        Arrays.fill(visited, -1);
        for (int i = 0; i < totalV; i++) {
            if (isCyclicUsingDFS(i, visited)) {
                return 1;
            }
        }
        return 0;
    }

    int detectCycleUsingBFS() {
        int[] visited = new int[totalV];
        for (int i = 0; i < totalV; i++) {
            if (isCyclicUsingBFS(i, visited)) {
                return 1;
            }
            System.out.println("For i " + i );
            visited[i] = 0;
            System.out.println(Arrays.toString(visited));
        }
        return 0;
    }

    public static void main(String[] args) {

        DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph(4);

        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(2,3);
        obj.addEdge(3,1);

        System.out.println(obj.detectCycleUsingBFS());


    }
}
