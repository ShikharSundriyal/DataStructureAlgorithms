class Solution {
    
    public boolean isPalindrome(int x){
        String str = x+"";
        StringBuilder sb = new StringBuilder(str);
        if( sb.reverse().toString().equals(str))
            return true;
        return false;
    }
    
    public boolean isPalindrome1(int x) {
        long res = x;        
        long num = x;
        long nod=0;
        while(num!=0){
            nod++;
            num/=10;
        }
        
        long rev =0;
        while(x>0){
            nod--;
            int rem = x%10;
            
            rev+= rem*Math.pow(10,nod);
            
            x/=10;
        }
        
        if(rev == res) 
            return true;
        return false;
    }
}