class Solution {
    public int singleNumber(int[] nums) {
      int  ans = 0;
        for(int k : nums){
            ans = ans^k;
        }
        return ans;
    }
}