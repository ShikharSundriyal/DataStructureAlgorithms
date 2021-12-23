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
