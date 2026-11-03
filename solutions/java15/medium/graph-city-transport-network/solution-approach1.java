// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transport-network/problem?isFullScreen=true
// Problem     Graph - City Transport Network
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-03, 04:14 p.m.
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
