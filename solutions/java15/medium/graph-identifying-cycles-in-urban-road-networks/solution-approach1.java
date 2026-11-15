// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-identifying-cycles-in-urban-road-networks/problem?isFullScreen=true
// Problem     Graph - Identifying Cycles in Urban Road Networks
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 12:59 a.m.
// ──────────────────────────────────────────────────

import java.util.*;

public class Main{
    public static boolean DFS(int[] vis, ArrayList<ArrayList<Integer>> arr, int n, int parent){
        
        vis[n] = 1;
        
        for(int num:arr.get(n)){
            if(vis[num]==0){
                DFS(vis, arr, num, n);
            }else if(num!=parent){
                return true;
            }
        }
        
        return false;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();
            
            arr.get(l).add(m);
            arr.get(m).add(l);
            
        }
        
        int[] vis = new int[v];
        
        boolean cy = false;
        
        for(int i=0; i<v; i++){
            if(vis[i] == 0){
                if(DFS(vis, arr, i, -1)){
                    cy = true;
                    break;
                }
            }
        }
        
        if(cy){
            System.out.println("Cycle Detected");
        }else{
            System.out.println("No Cycle Detected");
        }
        
    }
}
