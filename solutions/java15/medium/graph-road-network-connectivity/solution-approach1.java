// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-road-network-connectivity/problem?isFullScreen=true
// Problem     Graph - Road Network Connectivity
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 02:24 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {
    public static void DFS(int n, int[] visited, List<List<Integer>> arr ){
        
        if(visited[n]==0){
            // mark printed verted as visited
            visited[n] = 1;
        }
         
        //  Recursion for the adjacent elements
        for(int num:arr.get(n)){
        // if adj vertex is not visited it is sent to Traversal else move forw
            if(visited[num]==0){
                DFS(num, visited, arr);
            }
        }        
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        // Adjacent List Construction
        
        List<List<Integer>> arr = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();

            arr.get(l).add(m);
            rev.get(m).add(l);

        }

        // Visited array to track if the vertex is visited
        int[] visited = new int[v+1];
        
        // DFS Traversal
        DFS(1, visited, arr);
        
        for(int i=1; i<visited.length; i++){
            if(visited[i]==0){
                System.out.println("The road network is not connected.");
                return;
            }
        }
        
        Arrays.fill(visited, 0);
        DFS(1, visited, rev);
        
        for(int i=1; i<visited.length; i++){
            if(visited[i]==0){
                System.out.println("The road network is not connected.");
                return;
            }
        }
        
        System.out.println("The road network is connected.");
        return;
        
    }
}
