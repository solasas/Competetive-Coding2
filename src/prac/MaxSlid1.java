package prac;

import java.util.*;

public class MaxSlid1 {
    public static void main(String[] args){
        int n = 7;
        int arr[] = {3,10,7,12,2,9,4};
        int k = 3;

        Deque<Integer> que = new LinkedList<>(); 

        // First window
        for(int i = 0; i < k; i++){
            while(!que.isEmpty() && arr[que.peekLast()] <= arr[i]){
                que.pollLast();
            }
            que.addLast(i);
        }

        // Remaining windows
        for(int i = k; i < n; i++){
            // Print max of previous window
            System.out.print(arr[que.peekFirst()] + " ");

            // Remove elements outside window
            while(!que.isEmpty() && que.peekFirst() <= i - k){
                que.pollFirst();
            }

            // Remove smaller elements
            while(!que.isEmpty() && arr[que.peekLast()] <= arr[i]){
                que.pollLast();
            }

            que.addLast(i);
        }

        // Print max of last window
        System.out.println(arr[que.peekFirst()]);
    }
}