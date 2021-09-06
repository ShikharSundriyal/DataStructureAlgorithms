class Solution {
    public int removeDuplicates(int[] arr) {
        
        if(arr.length == 1) return 1;
        int i = 0, j = 1;
        while(j < arr.length){
            if(arr[i] == arr[j]){
                j++;
            }else{
                i++;
                arr[i] = arr[j];
                j++;
            }
            
        }
        return i+1;
        // int count =0;
        // for(int i = arr.length-1;i>0;i--){
        //     if(arr[i] == arr[i-1]){
        //         if(i+1 < arr.length){
        //             arr[i] = arr[i+1];
        //             arr[i+1] = 500;
        //         }
        //     }else{
        //         count++;
        //     }
        // }
        // int k = 0;  
        // for(int i = 0;i<arr.length;i++){
        //     if(arr[i]!=500){
        //         arr[k] = arr[i];
        //         k++;
        //     }
        // }
        // //Arrays.sort(arr);
        // return count+1;
    }
}
