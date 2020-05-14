package ds_algo_assignment.week_1.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] results;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        results = new double[T]; // perform T independent experiments on an
        // N-by-N grid
        for (int i = 0; i < T; i++) {
            results[i] = calculateResults(N);
        }

    }

    private double calculateResults(int n) {
        int openSites = 0;
        Percolation percolation = new Percolation(n);
        while (!percolation.percolates()) {
            int i = StdRandom.uniform(n) + 1;
            int j = StdRandom.uniform(n) + 1;
            if (!percolation.isOpen(i, j)) {
                percolation.open(i, j);
                openSites++;
            }
        }
        return (double) openSites / (n * n);
    }

    public double mean() {
        return StdStats.mean(results);
    }

    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(results.length));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(results.length));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(N, T);
        System.out.println("mean                    = " + percolationStats.mean());
        System.out.println("stddev                  = " + percolationStats.stddev());
        System.out.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");
    }
}