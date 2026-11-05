// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-transportation-system/problem?isFullScreen=true
// Problem     Graph - City Transportation System
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-05, 12:12 p.m.
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









