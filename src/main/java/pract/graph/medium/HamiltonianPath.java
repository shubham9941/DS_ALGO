package pract.graph.medium;


import pract.Reader;

import java.util.Iterator;
import java.util.LinkedList;

public class HamiltonianPath {

    int totalV;
    LinkedList<Integer>[] adj;

    HamiltonianPath(int totalV) {
        this.totalV = totalV;
        adj = new LinkedList[totalV];
        for (int i = 0; i < totalV; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    boolean checkPath(int start, boolean[] visited, int count ) {
        visited[start] = true;
        count++;
        Iterator<Integer> it = adj[start].iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (!visited[next]) {
                if (checkPath(next, visited,count)) {
                    return true;
                }
            }
        }
        if (count == totalV) {
            return true;
        } else {
            visited[start] = false;
            return false;
        }
    }

    int isHamiltonianPathExist() {

        boolean []visited = new boolean[totalV];

        for (int i = 0; i < totalV; i++) {
            if(!visited[i]){
               if(checkPath(i , visited , 0)){
                   return 1 ;
               }
            }
        }
        return 0;

    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int totalV = sc.nextInt();
            HamiltonianPath obj = new HamiltonianPath(totalV);
            int totalE = sc.nextInt();
            for (int i = 0; i < totalE; i++) {
                obj.addEdge(sc.nextInt()-1 , sc.nextInt()-1);
            }
            System.out.println(obj.isHamiltonianPathExist());

        }

    }
}
