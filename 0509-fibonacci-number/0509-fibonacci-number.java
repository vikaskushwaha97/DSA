class Solution {
    public int fib(int n) {
        if (n<2) return n;
        int prev2=0;
        int prev1=1;
        int curr;
        for (int i =2;i<n+1;i++){
          curr=prev1+prev2;
          prev2=prev1;
          prev1=curr;
          
        }  return prev1;
    }
   
}