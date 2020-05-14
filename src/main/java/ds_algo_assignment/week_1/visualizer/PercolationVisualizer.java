package ds_algo_assignment.week_1.visualizer;

import java.awt.Font;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import ds_algo_assignment.week_1.percolation.Percolation;

public class PercolationVisualizer {

    // delay in miliseconds (controls animation speed)
    private static final int DELAY = 100;

    // draw n-by-n ds_algo_assignment.week_1.percolation system
    public static void draw(Percolation percolation, int n) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-0.05*n, 1.05*n);
        StdDraw.setYscale(-0.05*n, 1.05*n);   // leave a border to write text
        StdDraw.filledSquare(n/2.0, n/2.0, n/2.0);

        // draw n-by-n grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (percolation.isFull(row+1, col+1)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                }
                else if (percolation.isOpen(row+1, col+1)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                StdDraw.filledSquare(col + 0.5, n - row - 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.25*n, -0.025*n, percolation.numberOfOpenSites() + " open sites");
        if (percolation.percolates()) StdDraw.text(0.75*n, -0.025*n, "percolates");
        else                          StdDraw.text(0.75*n, -0.025*n, "does not percolate");

    }

    private static void simulateFromFile(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        Percolation percolation = new Percolation(n);

        // turn on animation mode
        StdDraw.enableDoubleBuffering();

        // repeatedly read in sites to open and draw resulting system
        draw(percolation, n);
        StdDraw.show();
        StdDraw.pause(DELAY);

        while (!in.isEmpty()) {
            int row = in.readInt();
            int col = in.readInt();
            percolation.open(row, col);
            draw(percolation, n);
            StdDraw.show();
            StdDraw.pause(DELAY);
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String filename = "/home/shubhamagarwal/Documents/work_exzeo/inbox/Coursera-assignments/src/main/resources/wayne98.txt" ;
        simulateFromFile(filename);
    }
}