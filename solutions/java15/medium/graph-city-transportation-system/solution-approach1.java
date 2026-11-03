// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transportation-system/problem?isFullScreen=true
// Problem     Graph - City Transportation System
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-03, 04:21 p.m.
// Technique   adjacency-matrix-representation
// Time        O(V^2 + E)
// Space       O(V^2)
// Insight     The implementation uses an adjacency matrix to store undirected edges, where each entry at index (u-1, v-1) is marked as 1 to indicate a direct road between city u and city v.
// Interview   Before: "How would you store the road network?" After: "I used an adjacency matrix of size V by V to store the connections, which takes O(V^2) space and allows O(V^2 + E) time to populate and display the graph, ensuring all bidirectional roads are correctly mapped."
// Pitfalls    (1) The adjacency matrix approach consumes O(V^2) space, which may be inefficient for sparse graphs compared to an adjacency list.  (2) The implementation assumes 1-based indexing for cities, requiring a conversion to 0-based indices for array access.  (3) The nested loop for printing iterates over all V^2 possible connections, which is less efficient than traversing adjacency lists for sparse graphs.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        int[][] arr = new int[v][v];
        
        for(int i=0; i<e; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            arr[m-1][n-1] = 1;
            arr[n-1][m-1] = 1;
        }
        
        for(int i=0; i<v; i++){
            System.out.print("City " + (i+1) + ": ");
            for(int j=0; j<v; j++){
                if(arr[i][j] == 1){
                    System.out.print(j+1 + " ");
                }
            }
            System.out.println();
        }
    }
}
