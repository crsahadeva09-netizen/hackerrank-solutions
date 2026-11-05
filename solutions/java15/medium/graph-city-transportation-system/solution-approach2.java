// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transportation-system/problem?isFullScreen=true
// Problem     Graph - City Transportation System
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-05, 12:12 p.m.
// Technique   adjacency-list-with-sorting
// Time        O(E log E + V)
// Space       O(V + E)
// Insight     The implementation uses an adjacency list with 1-based indexing to store undirected edges, ensuring each city's neighbors are sorted before output.
// Interview   Before: "I will use an adjacency matrix to store the graph." After: "Using an adjacency list with O(V+E) space is more efficient for sparse graphs, and sorting the neighbors ensures the output matches the required format in O(E log E) time."
// Pitfalls    (1) Using 0-based indexing for input cities when the problem requires 1-based output formatting.  (2) Failing to sort the adjacency list, which may lead to incorrect output order compared to the expected results.  (3) Allocating an adjacency list of size v instead of v+1, causing an IndexOutOfBoundsException when accessing index v.
// ──────────────────────────────────────────────────

// import java.io.*;
// import java.util.*;

// public class Solution {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         int v = sc.nextInt();
//         int e = sc.nextInt();
        
//         int[][] arr = new int[v][v];
        
//         for(int i=0; i<e; i++){
//             int m = sc.nextInt();
//             int n = sc.nextInt();
            
//             arr[m-1][n-1] = 1;
//             arr[n-1][m-1] = 1;
//         }
        
//         for(int i=0; i<v; i++){
//             System.out.print("City " + (i+1) + ": ");
//             for(int j=0; j<v; j++){
//                 if(arr[i][j] == 1){
//                     System.out.print(j+1 + " ");
//                 }
//             }
//             System.out.println();
//         }
//     }
// }

import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        List<List<Integer>> adj = new ArrayList<>(v+1);
        
        for(int i=0; i<=v; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            adj.get(m).add(n);
            adj.get(n).add(m);
        }
        
        for(int i=0; i<=v; i++){
            Collections.sort(adj.get(i));
        }
        
        for(int i=1; i<=v; i++){
            System.out.print("City " + i + ": ");
            for(int k:adj.get(i))
               System.out.print(k + " ");
            System.out.println();
        }
        
    }
}









