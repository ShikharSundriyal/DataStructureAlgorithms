class Solution {
    public int numOfStrings(String[] patterns, String word) {
        
        return num(patterns,word,0);
    }
    
    public int num(String[] patterns, String word, int idx){
        if(idx == patterns.length){
            return 0;
        }
        
        int res = num(patterns,word,idx+1);
        String s = patterns[idx];
        if(word.contains(s)) res+=1;
        return res;
    }
}
