package lab11.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private static final int INFINITY = Integer.MAX_VALUE;
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        edgeTo[s] = s;
        for (int i = 0; i < maze.V(); i++) {
            distTo[i]=INFINITY;
        }
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int s) {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        Queue<Integer> q = new ArrayDeque<>();
        distTo[s] = 0;
        marked[s] = true;
        q.add(s);
        announce();

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : maze.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    edgeTo[w] = v;
                    announce();
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    announce();
                    if (w == t) {
                        targetFound = true;
                    }
                    if (targetFound) {
                        return;
                    }
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs(s);
    }
}

