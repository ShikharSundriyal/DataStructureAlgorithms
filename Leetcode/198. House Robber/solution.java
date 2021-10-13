class Solution {
//     public int rob1(int[] arr) {
//         int m1=0,m2=0;
        
//         int[] dp1 = new int[arr.length];
//         int[] dp2 = new int[arr.length];
//         dp1[0] = arr[0];
//         for(int i = 1;i<arr.length;i++){
//             dp1[i] = arr[i]+dp2[i-1];
//             dp2[i] = Math.max(dp1[i-1],dp2[i-1]);
//         }
//         return Math.max(dp1[arr.length-1],dp2[arr.length-1]);
//     }
    
     public int rob(int[] prices) {
        int oldMaxIncluded = prices[0] , oldMaxExcluded = 0;
        for(int i =  1;i<prices.length ; i++){
            int newMaxIncluded = oldMaxExcluded +  prices[i];
            int newMaxExcluded = Math.max(oldMaxIncluded, oldMaxExcluded);
            oldMaxIncluded = newMaxIncluded;
            oldMaxExcluded = newMaxExcluded;
         }
        return Math.max(oldMaxIncluded,oldMaxExcluded);
         
         
         // int[] r  = h(arr,arr.length-1);
       //   return Math.max(r[0],r[1]);
    }
    public int[] h(int[] arr, int n){
        if(n == 0){
            int[] r = new int[2];
            r[0] = arr[n];
            r[1] = 0;
            return r;
         }
        
        int[] res = h(arr,n-1);
        int v1 = arr[n]+res[1];
        int v2 = Math.max(res[0],res[1]);
        res[0] = v1;
        res[1] = v2;
        return res;
        
    }
}
