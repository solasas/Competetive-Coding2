package CAT1;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    static Stack<int[]> st=new Stack<>();
    public static int next(int price){
        int span=1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            span+=st.pop()[1];
        }
        st.push(new int[]{price,span});
        return span;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices=new int[n];
        int[] span=new int[n];
        for(int i=0;i<n;i++){
            prices[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            span[i]=next(prices[i]);
        }
        for(int s: span){
            System.out.println(s+" ");
        }
    }
}
