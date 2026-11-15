// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-exploring-city-routes/problem?isFullScreen=true
// Problem     Graph - Exploring City Routes
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 12:15 p.m.
// Technique   recursive-dfs-adjacency-list
// Time        O(V + E)
// Space       O(V + E)
// Insight     The algorithm maintains a visited array to track explored nodes and recursively traverses unvisited neighbors in the order they appear in the adjacency list.
// Interview   Before: "How would you perform a depth-first traversal on this graph?" After: "I implemented a recursive DFS using an adjacency list, which achieves O(V + E) time complexity by visiting each node and edge exactly once, ensuring we explore as far as possible along each branch before backtracking."
// Pitfalls    (1) The adjacency list is initialized with size v+1 to accommodate 1-based indexing, which will cause an ArrayIndexOutOfBoundsException if the input contains a city index greater than v.  (2) The recursion depth is limited by the number of cities, which may trigger a StackOverflowError for extremely large, linear graph structures.  (3) The order of traversal is strictly dependent on the input order of edges in the adjacency list, which may differ from sorted order.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {
    public static void DFS(int n, int[] visited, List<List<Integer>> arr ){
        
        if(visited[n]==0){
            System.out.print(n + " ");
            visited[n] = 1;
        }
         
        //  Recursion for the adjacent elements
        for(int num:arr.get(n)){
            // if not visited it is sent to Traversal else move forw
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
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();
            
            arr.get(l).add(m);
            arr.get(m).add(l);      // Since Bi-directional Graph
            
        }
        
        // starting vertex of Traversal
        int start = sc.nextInt();

        // Visited list to track if the vertex is visited
        int[] visited = new int[v+1];
        
        // DFS Traversal
        DFS(start, visited, arr);
        
    }
}
