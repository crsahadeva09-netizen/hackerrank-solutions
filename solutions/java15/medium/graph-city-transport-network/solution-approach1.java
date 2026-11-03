// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transport-network/problem?isFullScreen=true
// Problem     Graph - City Transport Network
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-03, 04:14 p.m.
// Technique   adjacency-matrix-construction
// Time        O(V^2 + E)
// Space       O(V^2)
// Insight     The implementation maps 1-based city indices to 0-based matrix coordinates by subtracting one from each input node identifier.
// Interview   Before: "How would you represent a directed graph with V nodes and E edges?" After: "I would use an adjacency matrix of size V by V, which takes O(V^2) space and O(V^2 + E) time to populate, ensuring 1-based input nodes are correctly mapped to 0-based indices."
// Pitfalls    (1) Failing to adjust 1-based input indices to 0-based array indices results in an ArrayIndexOutOfBoundsException.  (2) Assuming the graph is undirected when the problem specifies directed routes leads to incorrect matrix population.  (3) Printing the matrix with trailing spaces on each line may cause formatting issues depending on the strictness of the output validator.
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
        }
        
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
