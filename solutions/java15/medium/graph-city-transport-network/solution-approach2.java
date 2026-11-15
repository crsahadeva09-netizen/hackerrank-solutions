// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transport-network/problem?isFullScreen=true
// Problem     Graph - City Transport Network
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 10:32 a.m.
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
