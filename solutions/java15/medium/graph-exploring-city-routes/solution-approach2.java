// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-exploring-city-routes/problem?isFullScreen=true
// Problem     Graph - Exploring City Routes
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 12:15 p.m.
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
