class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0,j=nums.length-1,k=nums.length-1;
        while(i<=j){
            if(nums[i]*nums[i] <=nums[j]*nums[j]){
                arr[k]=nums[j]*nums[j];
                j--;
            }else{
                arr[k]=nums[i]*nums[i];
                i++;
            }
            k--;
        }
        return arr;
    }
}
