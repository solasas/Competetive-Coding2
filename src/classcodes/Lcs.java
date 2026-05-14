package classcodes;
import  java.util.*;
public class Lcs {
    public static void main(String[] args) {
        String s="abcbda";
        int[][] dp=new int [s.length()][s.length()];;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(longestsub(s,0,s.length()-1,dp));

    }
    public static int longestsub(String s,int l,int r,int dp[][]){
        if(l==r) return 1;
        if(l>r) return 0;
        if(s.charAt(l)==s.charAt(r)){
            return 2+longestsub(s,l+1,r-1,dp);
        }
        else{
            return Math.max(longestsub(s,l+1,r,dp),longestsub(s,l,r-1,dp));
        }
    }
}
