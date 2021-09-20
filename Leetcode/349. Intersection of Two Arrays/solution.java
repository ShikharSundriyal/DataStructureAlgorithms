
// Here the final answers contains only unique elements, so the brute force way will work i.e search each element in the other set 
// but if we want all the common elements and we try to apply brute force of 0(n*m) then for case [1,2,3] [2,2] we will get out put [2,2] but we should get [2]
// so there we need to apply 0(nlogn+mlogm) two pointer approach (for intersection of two arrays with duplicate elements in result)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //brute force (0(n*m))
        // if(nums1.length>nums2.length) return intersectionHelper(nums2,nums1);
        // else return intersectionHelper(nums1,nums2);
        
        //optimised 0(nlogn+mlogm)
        return intersectionHelperOpti(nums1,nums2);
        
    }
    
    public int[] intersectionHelperOpti(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n = arr1.length-1;
        int m = arr2.length-1;
        HashSet<Integer> al = new HashSet<>();
        while(n>=0 && m>=0){
            if(arr1[n] == arr2[m]){
                al.add(arr1[n]);
                n--;
                m--;
                
            }else if(arr1[n] > arr2[m]){
                n--;
            }else{
                m--;
            }
        }
        int[] res = new int[al.size()];
        int k = 0;
        for(int i:al){
            res[k++] = i;
        }
        return res;
    }
    
    public int[] intersectionHelper(int[] arr1, int[] arr2){
        HashSet<Integer> al = new HashSet<>();
        for(int i = 0;i<arr1.length;i++){
            
            for(int j = 0;j<arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    al.add(arr1[i]);
                    break;
                }
            }
        }
        int[] res = new int[al.size()];
        int k=0;
        for(int i:al){
            res[k++]=i;
        }
        return res;
    }
}
