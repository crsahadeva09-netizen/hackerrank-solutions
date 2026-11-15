// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-road-network-connectivity/problem?isFullScreen=true
// Problem     Graph - Road Network Connectivity
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 02:24 p.m.
// Technique   kosaraju-inspired-two-pass-dfs
// Time        O(V + E)
// Space       O(V + E)
// Insight     The algorithm verifies strong connectivity by performing two depth-first searches, one on the original graph and one on the reversed graph, to ensure all nodes are reachable from a single source in both directions.
// Interview   Before: "How do you check if a directed graph is strongly connected?" After: "You can use two DFS passes in O(V+E) time; the first confirms all nodes are reachable from a starting node, and the second, on the reversed graph, confirms the starting node is reachable from all others."
// Pitfalls    (1) The implementation assumes the graph is 1-indexed based on the input, which may cause an ArrayIndexOutOfBoundsException if the input contains 0 or values greater than v.  (2) The code fails to handle disconnected components correctly if the graph has isolated nodes that are not reachable from the chosen starting node 1.  (3) The logic assumes node 1 always exists in the graph, which will crash if the input provides n=0.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {
    public static void DFS(int n, int[] visited, List<List<Integer>> arr ){
        
        if(visited[n]==0){
            // mark printed verted as visited
            visited[n] = 1;
        }
         
        //  Recursion for the adjacent elements
        for(int num:arr.get(n)){
        // if adj vertex is not visited it is sent to Traversal else move forw
            if(visited[num]==0){
                DFS(num, visited, arr);
            }
        }        
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        // Adjacent List Construction
        
        List<List<Integer>> arr = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();

            arr.get(l).add(m);
            rev.get(m).add(l);

        }

        // Visited array to track if the vertex is visited
        int[] visited = new int[v+1];
        
        // DFS Traversal
        DFS(1, visited, arr);
        
        for(int i=1; i<visited.length; i++){
            if(visited[i]==0){
                System.out.println("The road network is not connected.");
                return;
            }
        }
        
        Arrays.fill(visited, 0);
        DFS(1, visited, rev);
        
        for(int i=1; i<visited.length; i++){
            if(visited[i]==0){
                System.out.println("The road network is not connected.");
                return;
            }
        }
        
        System.out.println("The road network is connected.");
        return;
        
    }
}
