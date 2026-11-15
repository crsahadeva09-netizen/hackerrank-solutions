// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/graph-constructing-a-weighted-graph/problem?isFullScreen=true
// Problem     Graph - Constructing a Weighted Graph
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-15, 11:02 a.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        List<List<int[]>> arr = new ArrayList<>();
        
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<e; i++){
            int l = sc.nextInt();
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            arr.get(l).add(new int[]{m,n});
            arr.get(m).add(new int[]{l,n});
            
        }
        
        for(int i=1; i<=v; i++){
            System.out.print(i);
            for(int[] num:arr.get(i)){
                System.out.print(" -> (" + num[0] + ", " + num[1] + ")");
            }
            System.out.println();
        }
    }
}


