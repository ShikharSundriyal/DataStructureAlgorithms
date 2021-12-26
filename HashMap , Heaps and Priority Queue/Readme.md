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
     
# Priority Queue : 

4. K Largest Elements : 
    - Given an array find the k largest elements 
    - input arr [1,7,3,4,6] , k = 3
    - Approach 1 : T 0(nlogn), S 0(1)
      - sort the array [1,3,4,6,7]
      - from the end print k elements
    - Approach 2 : T o(klogk + nlogk), space 0(k)
      - Create a Priority Queue where lower value has more priority i.e. MIN Priority Queue
      - iterate over the array
        - if queue.size <= k 
          - add element to the queue
        - else 
          - check if queue.peek() (which contains the min value amongst the queue) < element of the array
            - then remove the element from the queue and add the array element to the queue.             

5. Merge K sorted Lists :
    - Given a Arraylist of size k containing k sorted arraylist, we need to return a combined sorted arraylist 
    - Approach 1 : T(nlogn) 
      - Add all elements of every list to an array and then sort
    - Approach 2 :
      - we need to keep k pointers at beginning of each list , compare all elements of each list according to appropriate pointer position and push the smallest element to the result arraylist and as one element from that list is consumed for next comparisions we need to move the pointer for that list by 1
      - Inorder to solve this we make a Pair class which has 3 data members, listnumber, index, value -> which correspond to listno from lists arraylist, index is the current index which need to be compared, the value is the value for that list at that index
      - We will add 0th index elements from k list to a priority queue ,
        - now we will remove the smallest element from queue 
        - and push the value of that pair to resultant arraylist
        - now we need to add another element to the queue from the list the element got removed but with an increased index . The only thing to keep in mind is that while doing so we need to check that the list is not totaally consumed i.e. all elements are already consumed from that list.  
