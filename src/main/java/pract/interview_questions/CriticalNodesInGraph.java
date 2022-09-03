package pract.interview_questions;


import java.util.Iterator;
import java.util.LinkedList;

public class CriticalNodesInGraph {
    LinkedList<Integer>[] vert;

    int totalV;

    CriticalNodesInGraph(int totalV) {
        this.totalV = totalV;
        vert = new LinkedList[totalV];
        for (int i = 0; i < totalV; i++) {
            vert[i] = new LinkedList<>();
        }
    }

    void add(int u, int v) {
        vert[u].add(v);
        vert[v].add(u);
    }



    int DFSUtil(int start, boolean[] visted, int critical) {
        visted[start] = true;
        int res = 1;
//        System.out.print(start + " ");
        Iterator<Integer> it = vert[start].iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (!visted[next] && next != critical) {
                res+=DFSUtil(next, visted, critical);
            }
        }
        return res;
    }

    void DFSTrav() {
        boolean[] visited = new boolean[totalV];
        for (int i = 0; i < totalV; i++) {
            int start = (i == 0)  ? i + 1 : 0 ;
            visited = new boolean[totalV];
            int res = DFSUtil(start , visited, i);
            if(res < totalV-1){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        CriticalNodesInGraph gp = new CriticalNodesInGraph(7);
        gp.add(0, 1);
        gp.add(0, 2);
        gp.add(1, 3);
        gp.add(2, 3);
        gp.add(3, 4);
        gp.add(2, 5);
        gp.add(5, 6);

        gp.DFSTrav();

    }
}
