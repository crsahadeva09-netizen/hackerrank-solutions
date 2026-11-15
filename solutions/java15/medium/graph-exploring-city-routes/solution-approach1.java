// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-exploring-city-routes/problem?isFullScreen=true
// Problem     Graph - Exploring City Routes
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 11:58 a.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {
    public static void DFS(int n, int[] visited, List<List<Integer>> arr ){
        
        if(visited[n]==0){
            System.out.print(n + " ");
            visited[n] = 1;
        }
            
        for(int num:arr.get(n)){
            if(visited[num]==0){
                DFS(num, visited, arr);
            }
        }        
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();
            
            arr.get(l).add(m);
            arr.get(m).add(l);
            
        }
        
        int start = sc.nextInt();

        int[] visited = new int[v+1];
        
        DFS(start, visited, arr);
        
    }
}
