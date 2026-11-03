// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-constructing-a-social-network-graph/problem?isFullScreen=true
// Problem     Graph - Constructing a Social Network Graph
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-03, 04:15 p.m.
// Technique   adjacency-matrix-construction
// Time        O(V^2 + E)
// Space       O(V^2)
// Insight     The implementation maps 1-based vertex indices to 0-based array indices by subtracting one from each input node identifier to populate a symmetric adjacency matrix.
// Interview   Before: "How would you represent a social network graph?" After: "I would use an adjacency matrix to store friendships, which takes O(V^2) space and O(V^2 + E) time to initialize and populate, ensuring O(1) lookup for any edge between two users."
// Pitfalls    (1) Failing to adjust 1-based input indices to 0-based array indices results in an ArrayIndexOutOfBoundsException.  (2) Assuming the graph is directed when the problem specifies an undirected graph, which requires setting both arr[u-1][v-1] and arr[v-1][u-1] to 1.
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
            for(int j=0; j<v; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
