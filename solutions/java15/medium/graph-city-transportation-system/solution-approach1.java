// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transportation-system/problem?isFullScreen=true
// Problem     Graph - City Transportation System
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-03, 04:21 p.m.
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
