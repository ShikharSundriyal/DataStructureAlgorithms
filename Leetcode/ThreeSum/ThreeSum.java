class Solution {
	
	/** O(n2) **/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res= new HashSet<>();
        if(nums.length==0) 
			return new ArrayList<>(res);
        for(int i =0;i<nums.length-2;i++){
            int left = i+1,right=nums.length-1;
            while(left<right){
                int sum =  nums[left] + nums[right];
                if(sum == -nums[i]){
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[left]);
                    al.add(nums[right]);
                    res.add(al);
                    left++;
                    right--;
                }
                else if(sum > -nums[i]){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}