

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] threshold;
    private final int n;
    private final int t;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.threshold = new double[trials];
        this.n = n;
        this.t = trials;

        /* Monte Carlo Simulation */
        for (int i = 0; i < t; i++) {
            Percolation p = new Percolation(n);
            threshold[i] = simulate(p);
        }
    }

    /**
     * Open randomly until the system percolates. Return the threshold.
     */
    private double simulate(Percolation p) {
        int[] openorder = StdRandom.permutation(n * n);
        for (int i = 0; !p.percolates(); i++) {
            int x = coordinate(openorder[i])[0];
            int y = coordinate(openorder[i])[1];
            p.open(x, y);
        }
        return ((double) p.numberOfOpenSites()) / (n * n);
    }

    private int[] coordinate(int index) {
        return new int[]{index / n, index % n};
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(threshold);
    }

    /**
     * Low endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(t);
    }

    /**
     * High endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(t);
    }

    /* For test */
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(100, 1000);
        System.out.printf("mean = %.6f\n", ps.mean());
        System.out.printf("sd = %.6f\n", ps.stddev());
        System.out.println("95% Confidence Interval:");
        System.out.printf("(%.6f, %.6f)\n", ps.confidenceLo(), ps.confidenceHi());
    }
}
