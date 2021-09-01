class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum % 2 !=0) return false;
        else{
            return helper1(nums,sum/2);
        }
        
    }
    public boolean helper(int[] nums, int sum, int idx){
        
        if( sum == 0) return true;
        if( sum < 0) return false;
        if( idx == nums.length) return false;    
        boolean y  = helper(nums, sum-nums[idx], idx+1);
        if(y == true) return true;
        boolean n = helper(nums, sum,idx+1);
        if(n == true) return true;
        return false;
    }
    
     public boolean helper1(int[] nums, int sum){
         boolean[][] dp = new boolean[nums.length+1][sum+1];
         for(int i=0; i<=nums.length;i++){
            dp[i][0] = true;
        }
        for(int k=1; k <= sum; k++){
            dp[0][k] = false;
        }
         for(int i = 1 ; i < dp.length; i++){
             for( int j = 1; j < dp[0].length;j++){
                dp[i][j] = dp[i-1][j] || ( j-nums[i-1] >=0 ?dp[i-1][j-nums[i-1]]:false);
                 
             }
         }
         return dp[dp.length-1][dp[0].length-1];
     }
}
