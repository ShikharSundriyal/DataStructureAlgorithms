class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int j = arr.length-1,i=arr.length-1;
        int cons = Integer.MIN_VALUE;
        while(i>=0){
            if(arr[i] == 1){
                i--;
            }else if(arr[i] == 0){
                cons = Math.max(j-(i+1)+1, cons);
                i--;
                j = i;
                
            }
        }
        if(i != j){
        	cons = Math.max(j-(i+1)+1, cons);
               i--;
        }
        return cons;  
    }
}
