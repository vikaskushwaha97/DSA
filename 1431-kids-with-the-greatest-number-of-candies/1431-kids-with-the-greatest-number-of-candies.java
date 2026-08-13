class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
            List<Boolean> ans = new ArrayList<>();
        for(int i =0;i<candies.length;i++){
            if (candies[i]>max){
                max=candies[i];
            }
            
        } for (int j=0 ;j<candies.length;j++){
            ans.add(candies[j]+extraCandies>= max);
            
        }return ans ;
}
}