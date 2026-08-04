//Memoization Solution practise
class Solution {
    public int rob(int[] nums) {
    int []dp =new int [nums.length];
    Arrays.fill(dp,-1);
    return Helper(nums.length-1,dp,nums);
        }
    private int Helper(int n,int[]dp,int[]nums){
        int pick;
        int notpick;
        if (n==0) return nums[0];
        if (n<0) return 0;
        if (dp[n]!=-1) return dp[n];
        else {pick= Helper(n-2,dp,nums)+nums[n];
              notpick=Helper(n-1,dp,nums);
              dp[n]=Math.max(pick,notpick);}
              return dp[n];
         }
}