package classcodes;

public class SubsetProblem {
//    static boolean subsetSum(int[] arr,int i,int sum){
//        if(sum==0) return true;
//        if(i<0) return false;
//        if(sum>=arr[i]){
//            return subsetSum(arr,i-1,sum-arr[i]) || subsetSum(arr,i-1,sum);
//        }
//        else{
//            return subsetSum(arr,i-1,sum);
//        }
//
//    }
//    public static void main(String[] args){
//        int[] arr={2,3,6,9,1};
//        int sum=13;
//        int dp[][]=new int[arr.length-1][arr.length-1];
//        System.out.println(subsetSum(arr, arr.length-1,sum ));
//    }

    static boolean subsetSum(int[] arr,int i,int sum,boolean dp[][]){
        if(sum==0) return true;
        if(i<0) return false;
        if(dp[i][sum]!=false) return dp[i][sum];
        if(sum>=arr[i]){
            dp[i][sum]=subsetSum(arr,i-1,sum-arr[i],dp) || subsetSum(arr,i-1,sum,dp);
        }
        else{
            dp[i][sum]=subsetSum(arr,i-1,sum,dp);
        }
        return dp[i][sum];
    }

    public static void main(String[] args) {
        int[] arr={2,4,6,9,1};
        int sum=30;
        boolean dp[][]=new boolean[arr.length-1][arr.length-1];
        System.out.println(subsetSum(arr,arr.length-1,sum,dp));
    }
}

