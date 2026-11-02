// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/22cs102033s/challenges/priority-queue-reordering-packages-in-a-delivery-center/problem?isFullScreen=true
// Problem     Priority Queue - Reordering Packages in a Delivery Center
// Difficulty  Medium
// Subdomain   N/A
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-11-02, 02:32 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        
        for(i=0; i<=k; i++){
            pq.add(arr[i]);
        }
        
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
            if(i<size){
                pq.add(arr[i]);
                i++;
            }
        }
        
        
    }
}
