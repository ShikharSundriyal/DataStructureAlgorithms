class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] p1 = new int[nums.length];
        int[] p2 =  new int[nums.length];
        int[] res =  new int[nums.length];
        p1[0] = nums[0];
        for(int i =1;i<nums.length;i++){
         p1[i] = p1[i-1]*nums[i]; 
        }
        p2[nums.length-1]=nums[nums.length-1];
        for(int i =nums.length-2;i>=0;i--){
            p2[i] = p2[i+1]*nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            
            res[i] = (i-1>=0?p1[i-1]:1)*(i+1<nums.length?p2[i+1]:1);
        }
        return res;
    }
}
