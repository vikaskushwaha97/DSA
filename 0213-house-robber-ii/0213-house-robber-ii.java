//memoization ans prractise for robber circuar proble
import java.util.Arrays;

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int ans1 = helper(0, n - 2, nums, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int ans2 = helper(1, n - 1, nums, dp2);

        return Math.max(ans1, ans2);
    }

    private int helper(int start, int i, int[] nums, int[] dp) {

        if (i < start)
            return 0;

        if (i == start)
            return nums[start];

        if (dp[i] != -1)
            return dp[i];

        int pick = nums[i] + helper(start, i - 2, nums, dp);
        int notPick = helper(start, i - 1, nums, dp);

        dp[i] = Math.max(pick, notPick);

        return dp[i];
    }
}