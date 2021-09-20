class Solution {
    public int[] plusOne(int[] digits) {
        //Approach 2
        int n = digits.length;
         for (int idx = n - 1; idx >= 0; --idx) {
      // set all the nines at the end of array to zeros
      if (digits[idx] == 9) {
        digits[idx] = 0;
      }
      // here we have the rightmost not-nine
      else {
        // increase this rightmost not-nine by 1
        digits[idx]++;
        // and the job is done
        return digits;
      }
    }
    // we're here because all the digits are nines
    digits = new int[n + 1];
    digits[0] = 1;
    return digits;
        
        // Approach 1 0(n), 0(n)
//         int carry = 0;
//         int k =1;
//         int i = digits.length-1;
//         ArrayList<Integer> al = new ArrayList<>();
//         while(i>=0){
//             int sum = digits[i] + k +carry ;
//             carry = sum/10;
//             int digit = sum %10;
//             digits[i] = digit;
//             k = 0;
//             i--;
//         }
//         if(carry != 0){
//             int x=1;
//             int[] res = new int[digits.length+1];
//             res[0] = 1;
            
//             return res;
//         }
//         return digits;
    }
}
