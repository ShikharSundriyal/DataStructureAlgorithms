//O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
    
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        
        for(int i = 1;i<n;i++){
            int max = 0;
            for(int j = i-1;j>=0;j--){
                if(nums[i] > nums[j])
                    max = Math.max(max,res[j]);
            }
            res[i] = 1+max;
        }
        int max = Integer.MIN_VALUE;
        for(int x:res)
            max = Math.max(max,x);
        return max;
    }
}