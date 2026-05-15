package CAT1;

import java.util.Stack;

public class MinStack {
    static Stack<int[]> st=new Stack();
    public static void push(int data){
        if(st.isEmpty()){
            st.push(new int[]{data,data});
        }
        else {
            int min = Math.min(st.peek()[0], data);
            st.push(new int[]{min, data});
        }
    }
    public static void pop(){
        if(!st.isEmpty()){
         st.pop();
        }

    }
    public static int getMin(){
        if(st.isEmpty()){
            return -1;
        }
        return st.peek()[0];
    }
    public static int peek(){
        if(st.isEmpty()){
            return -1;
        }
        return st.peek()[1];
    }
    public static boolean isEmpty(){
        return st.isEmpty();
    }

    public static void main(String[] args) {
        push(5);
        push(2);
        push(8);
        push(1);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        System.out.println(peek());
    }
}
