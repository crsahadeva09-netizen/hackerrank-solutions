// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-city-infrastructure-planning/problem?isFullScreen=true
// Problem     Graph - City Infrastructure Planning
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 12:47 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {
    public static void BFS(int n, int[] visited, List<List<Integer>> arr){

        Queue<Integer> q = new LinkedList<>();
        
        q.offer(n);
        System.out.print(n);
        visited[n] = 1;
        
        while(!q.isEmpty()){
            int num = q.poll();
            
            for(int i:arr.get(num)){
                if(visited[i]==0){
                    visited[i] = 1;
                    System.out.print(" " + i);
                    q.offer(i);
                }
            }
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        // Adjacent List Construction

        List<List<Integer>> arr = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();
            
            arr.get(l).add(m);
            arr.get(m).add(l);      // Since undirectional Graph
            
        }
        
        // starting vertex of Traversal
        int start = sc.nextInt();

        // Visited array to track if the vertex is visited
        int[] visited = new int[v+1];
        
        // BFS Traversal
        BFS(start, visited, arr);
        
    }
}
