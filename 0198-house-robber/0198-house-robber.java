//Memoization practise answer
class Solution {
    public int rob(int[] nums) {
        int dp[]=new int [nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,dp,nums);
         }
         private int helper(int n,int []dp,int []nums){
            int pick;
            int notpick;
            if (n==0){
                return nums[0];
            }if(n<0){return 0;}
            if (dp[n]!=-1){
                return dp[n];
                }
           else{
               pick=helper(n-2,dp,nums)+nums[n];
               notpick=helper(n-1,dp,nums);
               return dp[n]=Math.max(pick,notpick);
           }


         }
}