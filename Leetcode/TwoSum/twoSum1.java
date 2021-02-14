class Solution {
    /** O(n2) **/
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /** O(n) approach **/
    public int[] twoSum(int[] nums, int target) {
        Map < Integer, Integer > map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int remaining = target - val;
            if (map.containsKey(val) && map.containsKey(remaining)) {
                if (val != remaining) {
                    res[0] = map.get(val);
                    res[1] = map.get(remaining);
                    return res;
                } else {
                    if (i != map.get(remaining)) {
                        res[0] = i;
                        res[1] = map.get(remaining);
                        return res;
                    }
                }
            }

        }
        return res;
    }
}