1. Implement a Trie class : 
  - A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
  - Implement the Trie class:
    - Trie() Initializes the trie object.
    - void insert(String word) Inserts the string word into the trie.
    - boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    - boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 
<details><summary>Code</summary>
<p>

```java
class Trie {
    public static class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null) return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
     
    public void printAll(Node curr,String str){
        if(curr.isEnd){
            System.out.println(str);
        }
        
        for(int i = 0;i<26;i++){
            
            if(curr.children[i] != null){
                // System.out.println(i);
                 char ch = (char)('a'+i);
                printAll(curr.children[i],str+ch+"" );
            }
        }
    }
}

```
                                       
</p>
</details>
