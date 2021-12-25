# HashMap :
  - HashMap is used to store key value pairs
  - they are unordered i.e the order of insertion and the order they are retrieved from HashMap is random
  - HashMap<Integer, Integer> hm = new HashMap<>();
  - some common methods : All these methods are 0(1)
    -  hm.put(key,value) -> add a key value pair to the hm, if its already present its updates it  
    -  hm.remove(key) -> removes the pair from the hashMap
    -  hm.containsKey(key) -> returns true or false if a key is present in the HashMap 
    -  hm.get(key) -> returns the value associated with the key
    -  hm.getOrDefault(key, defaultvalue) -> returns the value associated with key if key does not exist returns the default value mentioned
    -  hm.keySet() -> returns the set of all the keys , inorder to iterate over the keyset we need to use for each loop ( NOT 0(1) )



# Questions :
1. Common elements amongst two arrays : (without duplicates) 0(n)
    - arr1 [1,4,2,5,6,2,1] 
    - arr2 [1,2,6,7]
    - output : 1 , 2,  6
    - Put all the elements of arr1 in a HashSet -> [1,4,2,5,6]
    - Now iterate over arr2 and check if hashset contains that element if yes print that element and remove it from HashSet as we dont need to print duplicates
 
2. Common elements amongst two arrays : (print all the common pairs amongst both the arrays)
    - arr1 [1,4,2,5,6,2,1]
    - arr2 [1,2,6,1,7]
    - output : 1 2 6 1 
    - Create a hashmap from arr1 key=element and value = frequency of that element in array
    - iterate over arr2 , check if the element is present in hashmap and its value is greater than 0 if yes , print the element and reduce the frequency by 1

3. Longest Consecutive Sequence Of Elements :
    - given an array [10,8,9,11,5,4,2,1]
    - possible consecutive sequence : 
      - 1 2
      - 4 5
      - 8 9 10 11 -> Longest sequence 
    - Approach : 
      - We need to first fgure out which all elements will act as a starting point for a subsequence 
      - Create a HashMap which stores an the element as key and boolean value indicating whether it can be a sequence starter.
      - Traverse over array and create a HashMap , assuming all the elements can be a sequence starter
      - Now we need to find which ones can be the actual sequence starters , i.e. the element before that element should not be present in the HashMap example 4 can be a sequence starter as 3 is not present in the HashMap
      - now we iterate over the hashmap and check whether the element can be a sequence starter if yes
        - we form the the sequence by checking while the next element is present in the hashmap .
     
