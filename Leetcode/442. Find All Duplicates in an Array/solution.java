class Solution {
    // time 0(NlogN) space 0(1)
    public List<Integer> findDuplicates1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]) res.add(nums[i]);
        }
        return res;
    }
    public List<Integer> findDuplicates(int[] nums) {
        
        // time 0(N) space 0(1)
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[Math.abs(nums[i]) -1] < 0){
                res.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i]) -1] *=-1;   
            
         }
        return res;
    }
}
