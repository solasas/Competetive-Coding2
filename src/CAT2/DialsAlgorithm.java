package CAT2;

import java.util.*;

public class DialsAlgorithm {

    static int[] dial(int V, int[][] edges, int S) {

        int maxWeight = 0;
        for (int[] e : edges) {
            maxWeight = Math.max(maxWeight, e[2]);
        }

        int maxDistance = maxWeight * V;

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDistance; i++) {
            bucket.add(new ArrayList<>());
        }

        dist[S] = 0;
        bucket.get(0).add(S);

        for (int i = 0; i <= maxDistance; i++) {

            while (!bucket.get(i).isEmpty()) {

                int u = bucket.get(i).remove(0);

                for (int[] e : edges) {
                    int from = e[0], to = e[1], wt = e[2];

                    if (from == u && dist[u] + wt < dist[to]) {

                        if (dist[to] != (int)1e8) {
                            bucket.get(dist[to]).remove((Integer) to);
                        }

                        dist[to] = dist[u] + wt;
                        bucket.get(dist[to]).add(to);
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 3, 3},
                {2, 3, 1},
                {3, 4, 2}
        };

        int source = 0;

        int[] dist = dial(V, edges, source);

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + dist[i]);
        }
    }
}