package ds_algo_assignment.week_1.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public final class Percolation {

    final private int n;
    private int totalOpenSite = 0;
    final private boolean[] openSites;
    final private WeightedQuickUnionUF wqf;
    final private WeightedQuickUnionUF wqfForFull;


    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        openSites = new boolean[n * n + 2];
        wqf = new WeightedQuickUnionUF(n * n + 2);
        wqfForFull = new WeightedQuickUnionUF(n * n + 2);

    }

    public void open(int row, int col) {

        if (isIndicesInvalid(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        int index = getIndex(row, col);

        if (!openSites[index]) {
            openSites[index] = true;
            totalOpenSite = totalOpenSite + 1;

            if (row == 1) {
                wqf.union(index, 0);
                wqfForFull.union(0, index);
            }

            if (row > 1 && isOpen(row - 1, col)) {
                wqf.union(index, getIndex(row - 1, col));
                wqfForFull.union(index, getIndex(row - 1, col));
            }
            if (row < n && isOpen(row + 1, col)) {
                wqf.union(index, getIndex(row + 1, col));
                wqfForFull.union(index, getIndex(row + 1, col));
            }
            if (col > 1 && isOpen(row, col - 1)) {
                wqf.union(index, getIndex(row, col - 1));
                wqfForFull.union(index, getIndex(row, col - 1));
            }
            if (col < n && isOpen(row, col + 1)) {
                wqf.union(index, getIndex(row, col + 1));
                wqfForFull.union(index, getIndex(row, col + 1));
            }

            if (row == n) {
                wqf.union(getIndex(row, col), (n * n) + 1);
            }
        }
    }

    public boolean isOpen(final int row, final int col) {
        if (isIndicesInvalid(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        return openSites[getIndex(row, col)];
    }

    public boolean isFull(final int row, final int col) {
        if (isIndicesInvalid(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        int r = wqfForFull.find(getIndex(row, col));
        return (r == wqfForFull.find(0));
    }

    public boolean percolates() {
        return (wqf.find(0) == wqf.find(n * n + 1));
    }

    public int numberOfOpenSites() {
        return totalOpenSite;
    }

    private Boolean isIndicesInvalid(final int i, final int j) {
        return (i < 1 || i > n || j < 1 || j > n);
    }

    private int getIndex(int i, int j) {
        if (isIndicesInvalid(i, j)) {
            throw new IndexOutOfBoundsException();
        }
        return (n * (i - 1) + j);
    }
}
