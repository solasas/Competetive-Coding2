package CAT2;

import java.util.*;

public class TopoSort {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, adj, visited, st);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!st.isEmpty()){
            result.add(st.pop());
        }

        return result;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited, Stack<Integer> st) {

        visited[node] = true;

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adj, visited, st);
            }
        }

        st.push(node);
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1}, {0,2}, {1,3}, {2,3}};

        System.out.println(topoSort(V,edges));

    }
}