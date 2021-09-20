class Solution {
    public void moveZeroes(int[] arr) {
// O TO I-1 -> NON ZEROES
// I -> K-1 ZEROE
// K->ARR.LENGTH INSOLVED
// K =0

// IF ARR[K] !=0{
// SWAP(ARR[K] ARR[I])
// I++;
// K++;
// }
        //0(n) space -> 0(1)
        int i = 0;
        for(int k = 0;k<arr.length;k++){
            if(arr[k] !=0){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
    }
}
