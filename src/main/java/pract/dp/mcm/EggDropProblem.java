package pract.dp.mcm;

public class EggDropProblem {
    int[][] t;

    EggDropProblem() {
        int e = 100;
        int f = 100;
        t = new int[e + 1][f + 1];
        for (int i = 0; i < e + 1; i++) {
            for (int j = 0; j < f + 1; j++) {
                t[i][j] = -1;
            }
        }
    }


    int eggDrop(int e, int f) {
        if (f == 1 || f == 0)
            return f;

        if (e == 1)
            return f;

        int min = Integer.MAX_VALUE;
        int x, res;

        for (x = 1; x <= f; x++) {
            res = Math.max(eggDrop(e - 1, x - 1),
                    eggDrop(e, f - x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }

    // memoized version


//    int eggDrop(int e, int f) {
//        if (f == 1 || f == 0)
//            return f;
//
//        if (e == 1)
//            return f;
//
//        if (t[e][f] != -1) {
//            return t[e][f];
//        } else {
//            int min = Integer.MAX_VALUE;
//            int x, res;
//
//            for (x = 1; x <= f; x++) {
//                res = Math.max(eggDrop(e - 1, x - 1),
//                        eggDrop(e, f - x));
//                if (res < min)
//                    min = res;
//            }
//            t[e][f] = min + 1;
//            return min + 1;
//
//        }
//    }

    public static void main(String args[]) {
        int e = 2, f = 3;
        EggDropProblem obj = new EggDropProblem();
        System.out.println("****");
        System.out.print("Minimum number of "
                + "trials in worst case with "
                + e + " eggs and " + f
                + " floors is " + obj.eggDrop(e, f));


    }
} 
