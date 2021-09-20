class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 0(n+m) Time
        // 0(min(n,m)) Space
        // Add elements of smaller array to a Hashmap containing count of each element
        // Iterate over other array if element present in Hashmap and count >0 then push element to res array
        int n = nums1.length,m= nums2.length;
        if(n>m){
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums1){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int k =0;
        for(int i:nums2){
            int cnt = hm.getOrDefault(i,0);
            if(cnt !=0){
                nums1[k++] = i;
                hm.put(i,cnt-1);
            }
        }
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = nums1[i];
        }
        return res;
        
        //Approach 2 two pointer after sorting
        // 0(n+m) time
        //space constant
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int n = nums1.length-1;
//         int m = nums2.length-1;
//         ArrayList<Integer> al = new ArrayList<>();
//         while(n>=0 && m>=0){
//             if(nums1[n] == nums2[m]){
//                 al.add(nums1[n]);
//                 n--;
//                 m--;
//             }else if(nums1[n] > nums2[m]){
//                 n--;
//             }else{
//                 m--;
//             }
            
//         }
//         System.out.println(al);
//         int[] objects = new int[al.size()];
//         int i =0;
//         for(int ob:al){
//             objects[i++] = ob;
            
//         }
//         return objects;
    }
}
