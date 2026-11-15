// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transportation-system/problem?isFullScreen=true
// Problem     Graph - City Transportation System
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 10:42 a.m.
// Technique   adjacency-list-with-sorting
// Time        O(E log E + V)
// Space       O(V + E)
// Insight     The implementation uses an array of lists to store undirected edges, ensuring each city's connections are sorted before output to match the required display format.
// Interview   Before: "How would you represent a graph for quick neighbor lookups?" After: "I used an adjacency list, which provides O(1) access to neighbors per edge. Sorting the lists ensures consistent output, resulting in O(E log E + V) total time complexity for V cities and E roads."
// Pitfalls    (1) The code uses 1-based indexing for cities, requiring an array size of v+1 to avoid IndexOutOfBoundsException.  (2) Sorting the adjacency list for each city is necessary to match the expected output order, as input edges are not guaranteed to be sorted.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            arr.get(m).add(n);
            arr.get(n).add(m);
        }

        for(int i=1; i<=v; i++){
            System.out.print("City " + (i) + ": ");
            Collections.sort(arr.get(i));
            for(int num : arr.get(i)){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
