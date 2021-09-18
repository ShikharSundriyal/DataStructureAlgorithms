class Solution {
    public int removeDuplicates1(int[] arr) {
        int size = arr.length;
        for(int i = arr.length-1;i>=1;i--){
            if(arr[i] == arr[i-1]){
                arr[i] = Integer.MAX_VALUE;
                size--;
            }
        }
        Arrays.sort(arr);
        return size;
    }
     public int removeDuplicates(int[] arr) {
        int i =0,k=0;
         if(arr.length == 0) return 0;
         while(i < arr.length){
             arr[k++] = arr[i];
             while(i<arr.length-1 && arr[i] == arr[i+1]){
                 i++;
             }
             i++;
         }
        return k;
    }
    public int removeDuplicates(int[] arr) {
          // divide regions
         // 0 to idx unique numbers
        // i to arr.length unknows
         int idx = 0;
         for(int i = 1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                // unique element
                idx++;
                arr[idx] = arr[i];
            }            
         }
        return idx+1;
    }
}
