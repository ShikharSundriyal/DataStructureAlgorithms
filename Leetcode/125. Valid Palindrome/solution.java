class Solution {
    public boolean isPalindrome(String s) {
     
        int r = s.length()-1,l=0;
        
        while(l<r){
            char left = s.charAt(l);
            char right = s.charAt(r);
            
            if( ((left >='a' && left<='z') || (left >='A' && left<='Z') || (left >='0' && left<='9'))
               && 
              ((right >='a' && right<='z') || (right >='A' && right<='Z') || (right >='0' && right<='9')) ){
                if(Character.toLowerCase(left) ==  Character.toLowerCase(right)){
                    
                    l++;
                    r--;
                }else{
                    return false;
                }
            }else if(  !(left >='a' && left<='z') && !(left >='A' && left<='Z') && !(left >='0' && left<='9') ){
                
                 
                l++;
            }else if( !(right >='a' && right<='z') && !(right >='A' && right<='Z') && !(right >='0' && right<='9') ){
                r--;
            }
            
        }
        return true;
        
    }
}
