package CAT2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {
    public static List<Integer> slidingmax(int[] arr,int k){
        List<Integer> ans=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        int s=arr.length;
        for(int i=0;i<k;i++){
            while(!dq.isEmpty()&& arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }

        for(int i=k;i<s;i++){
            ans.add(arr[dq.peekFirst()]);

            while(!dq.isEmpty()&& dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        ans.add(arr[dq.peekFirst()]);

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> sl=new ArrayList<>();
        int[] arr={2,4,7,12,6,8,4,1};
        int k=3;
        sl=slidingmax(arr,k);
        System.out.println(sl);
    }
}
