package prac;

import java.util.ArrayList;
import java.util.List;

public class MaxSlid {
    public static List<Integer> maxslid(int[] arr,int k){
        int s=arr.length;
        List<Integer> ar=new ArrayList<>();
        for(int i=0;i<=s-k;i++){
            int maxx=arr[i];
            for(int j=i;j<i+k;j++){
                maxx=Math.max(maxx,arr[j]);
            }ar.add(maxx);
        }
        return ar;
    }
    public static void main(String[] args) {
        int[] arr={2,4,7,12,6,8,4,1};
        System.out.println(maxslid(arr,3));
    }
}
