class Solution {
    public int climbStairs(int n) {
        if (n<=2) return n;
        int prev3=0;
        int prev2=1;
        int prev =2;
        int curr;
        for (int i=3;i<n+1;i++){
            curr=prev+prev2;
            prev2=prev;
            prev=curr;
           
            
           
        }
         return prev;
    }
}