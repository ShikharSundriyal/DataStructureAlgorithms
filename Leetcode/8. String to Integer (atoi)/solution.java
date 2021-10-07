class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0){return 0;}
        String st = s.toLowerCase();
        char[] sch = st.toCharArray();
        int pointer = 0;
         int mf = 1;
        // HANDLING WHITESPACES
        while(pointer<sch.length && sch[pointer] == ' '){
            pointer+=1;
        }
       // check if + or - sign
        if(pointer<sch.length && (sch[pointer] == '+' || sch[pointer] == '-')){
            if(sch[pointer] == '-')
                mf = -1;
            pointer+=1;
        }
        // check if the string starts with non digit
        if(pointer<sch.length && sch[pointer] >= 'a' && sch[pointer] <= 'z' ){
            return 0;
        }
        long res = 0;
        int mul = 1;
        // while we are getting digits
        // take note if the res becomes greater than integer range return max or minn value based on + or - sign
        while(pointer<sch.length && sch[pointer] >= '0' && sch[pointer] <= '9' ){
            res = res*mul + (sch[pointer] - '0');
            pointer++;
            mul=10;
            if(mf == 1){
                if(res >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else {
                if(res*-1 <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
           
        }
        if(mf == 1){
              return (int)res;
        }else {
               return (int)res*mf; 
            }
        
    }
}
