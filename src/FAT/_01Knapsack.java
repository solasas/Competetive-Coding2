package FAT;

public class _01Knapsack {
    public static int knapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        // Build table row by row
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                // If we can include this item
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],                         // exclude
                            val[i - 1] + dp[i - 1][j - wt[i - 1]] // include
                    );
                } else {
                    // Cannot include → carry previous value
                    dp[i][j] = dp[i - 1][j];
                }
              
            }
        }

        return dp[n][W];
    }
    public static void main(String[] args) {
        int[] val = {1, 2, 5, 6};
        int[] wt = {2, 3, 4, 5};
        int W = 8;
        int n = val.length;

        System.out.println(knapsack(wt, val, n, W)); // Output: 8

    }
}
