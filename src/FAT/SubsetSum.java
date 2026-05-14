package FAT;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    public static boolean subsetSum(int[] arr, int target) {

        int n = arr.length;

        // dp[i][j] = can we make sum j using first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case:
        // Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= target; j++) {

                // Exclude current element
                dp[i][j] = dp[i - 1][j];

                // Include current element if possible
                if (arr[i - 1] <= j) {
                    dp[i][j] =
                            dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        // Print DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print((dp[i][j] ? "T " : "F "));
            }
            System.out.println();
        }
        List<Integer> subset = new ArrayList<>();

        int i = n;
        int j = target;

        while (i > 0 && j > 0) {

            // Element not included
            if (dp[i - 1][j]) {
                i--;
            }

            // Element included
            else {
                subset.add(arr[i - 1]);
                j = j - arr[i - 1];
                i--;
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 7, 8, 10};
        int target = 11;

        boolean ans = subsetSum(arr, target);

        System.out.println("\nSubset exists: " + ans);
    }
}


//
//public class SubsetSum {
//    public boolean subsetSum(int[] nums, int target) {
//        int n = nums.length;
//        boolean[][] dp = new boolean[n + 1][target + 1];
//
//        // Base case
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = true;
//        }
//
//        // Fill DP table
//        for (int i = 1; i <= n; i++) {
//            for (int s = 1; s <= target; s++) {
//                if (nums[i - 1] <= s) {
//                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - nums[i - 1]];
//                } else {
//                    dp[i][s] = dp[i - 1][s];
//                }
//            }
//        }
//
//
//
//        return dp[n][target];
//    }
//}