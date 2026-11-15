// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-access-to-libraries-in-hackerland/problem?isFullScreen=true
// Problem     Graph - Access to Libraries in HackerLand
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-16, 12:39 a.m.
// ──────────────────────────────────────────────────

import java.util.*;

public class Main{
    public static int DFS(int[] vis, ArrayList<ArrayList<Integer>> arr, int n){
        
        if(vis[n]==0){
            // System.out.print(n + " ");
            vis[n] = 1;
        }
        int count = 1;
        
        for(int num:arr.get(n)){
            if(vis[num]==0){
                count += DFS(vis, arr, num);
            }
        }
        
        return count;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T--!=0){
            
            int v = sc.nextInt();
            int e = sc.nextInt();
            int c_lib = sc.nextInt();
            int c_road = sc.nextInt();
            
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
            
            int[] vis = new int[v+1];
            
            if(c_lib<c_road){
                System.out.println(c_lib*v);
                continue;
            }
            
            int total_Cost = 0;
            
            for(int i=1; i<=v; i++){
                if(vis[i]==0){
                    int cnt = DFS(vis, arr, i);
                    total_Cost += c_lib+(cnt-1)*c_road;
                }
            }
            
            System.out.println(total_Cost);
            
        }
    }
}
