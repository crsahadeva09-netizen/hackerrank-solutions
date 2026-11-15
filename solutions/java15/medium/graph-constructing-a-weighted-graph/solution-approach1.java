// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-constructing-a-weighted-graph/problem?isFullScreen=true
// Problem     Graph - Constructing a Weighted Graph
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 11:02 a.m.
// Technique   adjacency-list-array-of-lists
// Time        O(V + E)
// Space       O(V + E)
// Insight     The implementation uses an array of lists to store undirected weighted edges, ensuring each intersection's connections are printed in the order they were added to the adjacency list.
// Interview   Before: "How would you represent a weighted graph for efficient traversal?" After: "I used an adjacency list with O(V + E) time and space complexity, which is optimal for storing V intersections and E roads while allowing direct iteration over neighbors."
// Pitfalls    (1) The code uses 1-based indexing for intersections, so initializing the list with v+1 elements is necessary to avoid IndexOutOfBoundsException.  (2) The graph is undirected, requiring the addition of both (u, v) and (v, u) to the adjacency list for every input edge.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        List<List<int[]>> arr = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            arr.get(l).add(new int[]{m,n});
            arr.get(m).add(new int[]{l,n});
            
        }
        
        for(int i=1; i<=v; i++){
            System.out.print(i);
            for(int[] num:arr.get(i)){
                System.out.print(" -> (" + num[0] + ", " + num[1] + ")");
            }
            System.out.println();
        }
    }
}


