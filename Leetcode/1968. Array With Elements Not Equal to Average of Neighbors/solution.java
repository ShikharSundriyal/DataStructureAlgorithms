class Solution {
    public int[] rearrangeArray(int[] arr) {
        int[] res  = new int[arr.length];
        Arrays.sort(arr);
        
        int k=0;
        int l = 0,r=arr.length-1;
        while(l<=r){
            res[k++] = arr[r];
            r--;
            if(l>r) break;
            res[k++] = arr[l];
            l++;            
        }

        return res;
    }
}
