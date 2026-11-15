// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transport-network/problem?isFullScreen=true
// Problem     Graph - City Transport Network
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 10:32 a.m.
// Technique   adjacency-matrix-construction
// Time        O(V^2 + E)
// Space       O(V^2)
// Insight     The implementation maps 1-based city indices to 0-based matrix coordinates by decrementing each input node identifier.
// Interview   Before: "How would you represent a directed graph with V nodes and E edges?" After: "I would use an adjacency matrix of size V by V, which takes O(V^2) space and O(V^2 + E) time to populate, ensuring direct routes are marked as 1 at indices (u-1, v-1)."
// Pitfalls    (1) Failing to adjust 1-based input indices to 0-based array indices results in an ArrayIndexOutOfBoundsException.  (2) Assuming the graph is undirected when the problem specifies directed routes leads to incorrect matrix population.
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
            int l = sc.nextInt();
            int m = sc.nextInt();
            
            arr[l-1][m-1] = 1;
        }
        
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
