1. 26 Remove Duplicates from Sorted Array : 2 approaches </br>
    - Approach 1 : 2 pointer i at 0 , j at 1, if(arr[i] == arr[j] ) increase j++ else i++ assign value of arr[i] = arr[j] then increase j++ </br>
    - Approach 2 : Start vising the array from backwards, if arr[i] == arr[i-1] then arr[i] = arr[i+1] and arr[i+1] = Integer.Maxvalue make sure to handle case for [1,1] and else count++ return count+1; </br>

2. 561 Array Partition I </br>
    - Approach : We need to make the sum max, so inorder to make sum max we need to make sure we select a pair which contains the maximum number, so for that we sort the array and take the i and i+2 elemnts and sum them as min(arr[o],arr[1]) will be arr[0] as array is sorted.
3. Plus one
	- Approach 1 : travel from left most index of array to 0th idx :<br>
         - if arr[idx] == 9 then arr[i]=0 else arr[i]++ return arr<br>
         - after for loop even if we havent returned that means if we have a array like 999.. , so answer has to be 1000.. i.e. a new array of length arr.length+1
    - Approach 2 : More traditional approach : 
	    - maintain a carry, start from end of array carry = arr[i]+k+carry / 10, arr[i] = arr[i]+k+carry %10,i--,k=0.
       	    - if carry == 0 return arr else same case as 1.2</br>
 
 4. 283 Move Zeroes Time 0(n) Space 0(1)
	- Approach 1 : Similar to partition an array, divide the array into regions
		- from k to arr.length unsolved region
		- from 0 to i-1 non zeroes
		- from i to k-1 zeroes
		- If we encounter an nonzero grow o to i-1 region, swap arr[k] and arr[i] and i++ and k++
		- If we encounter an 0 grow i to k-1 region, k++
			 
5. 485 Max Consecutive Ones : Time 0(n), Space 0(1)
	- Approach 1 : keep two pointer i = arr.length-1 and j=arr.length-1, 
		- if arr[i] == 1 move  i = i -1
		- if arr[i] == 0 calculate the total number of ones, those will be = j-(i+1) + 1 store them in a variable and compare it with other occurences, then decrease i i.e. i-- and j = i

6. 349 Intersection of Two Arrays : (The result shot have unique values)
	- Approach 1 : Brute force 0(n * m)
		- Find the smaller array, iterate over all elements of smaller array one by one and check if they are present in the second array if yes push to output array.
	- Approach 2 : Two pointer approach (Time complexity 0( nlogn + mlogm) , Space 0(1) )
		- Sort both the arrays
		- place i = arr1.length-1, j = arr2.length-1
			- if arr1[i] == arr2[j] then push element to output and i--,j--
			- else if arr1[i] > arr2[j] then i--
			- else if arr2[j]>arr1[i] j--
	- Approach 3 : Using a Hashmap (Time Complexity : 0(n+m) , Space Complexity : 0(min(n,m)))
		- Maintain a hashmap for the smaller array, element along with its count 
		- iterate over other array and check if the element is present in the hashmap and count>0 
			- If yes , push the element to the output and decrease count in the hashmap for the element	 

7. 1 Two Sum : 
	- Approach 1 : Brute Force (Time 0(n2) , Space 0(1))
		- choose each element one by one and iterate over i+1 to arr.length and check if arr[i] + arr[j] == target
	- Approach 2 ( Complement ): Time( 0(n) , Space 0(n)) -- 2 parse approach
		- create a hashmap and put each element to the hashmap along with its index, {nums[idx]:idx}
		- Now iterate over the array and calculate complement i.e. tar - arr[i] 
			- check if complement is present in the set and also the value of complement should not be equal to i itself Sample test case (3,2,4) target 6 
	- Approach 3 (Complement ) : Time( 0(n) , Space 0(n)) -- 1 parse approach
		- iterate over each element and calculate complement
			-  if complement present in hashset we have the answer as (hm,get(complement) , i)
			-  if complement is not present than add the current nums[i] and i to the hashmap. 

8.  Valid Sudoku : Time 0(n * m) space 0(1)
	- Approach 1 Using Hashset :
		- Iterate over each cell, and determine the boxnumber, row number and column number 
			- box number = (i/3)* 3 + j/3 , row = i , col = j
			- form  encoded value corresponding to box =  nums[i][j]+ "box-"+ box_number 
			- form  encoded value corresponding to row =  nums[i][j]+ "row-" + row 
			- form  encoded value corresponding to col =  nums[i][j]+ "col-" + col 
			- Check if any of these values are already present in hashset if yes return false else push all 3 values to hashset

9. 242 Valid Anagram :
	- Approach 1 : Time 0(nlogn) Space 0(n) {taken by toCharArray}
		-  check the length of both strings, should be equal else return false
		-  convert both string to char array (str.toCharArray())
		-  sort both the char arrays
		-  now check if both the arrays are identical 
	- Approach 2 : Using a HashMap Time 0(n) , Space 0(1) as at anytime max elements in hashmap will be 26
		-  check the length of both strings, should be equal else return false
		-  iterate over both the strings in same for loop and add the count of each element to the respective hashmap
		-  now iterate over 2nd string and check if first hashmap contains the character from 2nd string if yes match should also match
	- Approach 3 : Using a HashSet Time 0(n) , Space 0(1) as at anytime max elements in hashset/array will be 26
		- create two int array of length 26
		- fill the two array with count of each charaacter in a string to a char array arr[ch-'a'] = arr[ch-'a']++
		- now check if both the arrays are equal using Arrays.equals or normal iterate and check. 

10. 1328 Break a Palindrome :
	- Approach 1 : Time 0(n) , space 0(N)
		- Create a hashmap and store character and there count , convert the string to a charArray
		- check if frequency of a == str.length  which means all are 'a', so change the last character to b
		- check if frequency of 'a' == str.length-1 which means all are a except middle character , so change the last character to b as if we try to change first non 'a' character to a it will result into 'aaaaa' type string which will be palindronic.
		- else replace first non 'a' character to 'a'
	- Approach 2 : Time 0(n) , space 0(N) (Greedy)
		-  As the given string is plaindronic we have two cases if length of string is even or odd
			- if even then we will have excatly same two halves of string where half 2 will be reverse of half 1
			- if odd then we will have two halves having above property along with additional character which will not play and role as even if we change it to any character it will still give a palindrone.
			- this means in either case we should consider only half the length of the string 
				- replace the first non 'a' character with 'a' and return new string
			- if all the characters were a in the half string we should change the last character to 'b' and return	  

11. 125 Valid Palindrome : 
	- Approach 1 : Time 0(n), Space 0(n)
		- create a string builder and add only alpha numeric chars to string builder and make them lowercase while inserting
		- now check if sb.reverse().toString().equals(sb.toString())
	- Approach 2 : Two pointer Time 0(n), Space 0(1)
		- keep two pointer left at 0 right at s.length-1
		- while l < r 
			- if s.charAt(left) and s.charAt(right) are both alphanumeric compare if both are equal , if yes left++, right-- else return false
			- else if s.charAt(left) is not alphanumeric then left++
			- else if  s.charAt(right) is not alphanumeric then right--


## Linked List 
12. 237 Delete Node in a Linked List :
	- Approach : Time 0(N), Space 0(1)
		- As we are given only the node that needs to be deleted, we shift the values of all the nodes after the node to be deleted to one left and on the second last node we make it point it to null to reduce the overall size of the linked list.
	- Approach 2 : Time 0(1) , space 0(1)
		- copy the value of next node to the node that needs to be deleted
		- now , point the current node that is the node to be deleted to , node.next.next  
		- (node.val = node.next.val; node.next = node.next.next;)

13. Remove Nth Node from end Linked List :
	- Approach 1 : Time 0(N) , Space 0(1) (2 traversal)
		- traverse over the linked list and find the size of linked list
		-  Now to remove kth node from the end , remove size -k +1 th node from beginning.  
	- Approach 2 : Time 0(N) , Space 0(1) (single traversal)
		- take two pointer , A and B , keep A at head and keep B k positions from head
		- now move both A and B each by one position till the time B pointer reaches the last element, the A pointer will be kth position from the end

14. Reverse a Linked list :
	- Approach 1 : Using recursion changing data part  Time 0(N) Space 0(N) { Space is of the java call stack}
		- move to the end of the linked list by making the calls head.next till tead reaches to null
		- keep a ListNode data member( front ) which points to the head, keep another data member left 
		- in each iteration swap the data and increase the frontand left value, recursion will handle moving back one pointer from end and also the right value . where right and left value help us to determine after which position we need to stop swapping as we have to swapp only first half.	 
	- Approach 2 : Time 0(N) , Space 0(1)
		- Keep two pointer , current and previous. Keep previous at null, current at head
		- while current != null 
			- save the link temp = current.next
			- place current.next = prev
			- move both current and previous pointers,  prev = current , current = temp.  


15. 442 Find All Duplicates in an Array :
	- Approach 1 (Brute Force) : 0(n2) Space 0(1)
		- Take 2 pointer i and j , place i at 0 and j at 1 and travel from j to arr.length and see if same element as arr[i] is present
		- now increase i and j = i+1	
	- Approach 2 : 0(n) , Space 0(N)
		- Maintain a Hashset insert the element to hashset , before checking if the element is present in Hashset or not
	- Approach 3 : Time 0(n), Space 0(1)
		- Travel over the array
		- at each element do the following, nums[nums[i]-1] * = -1 (means making the element at idx -ve thus letting )
		- once you get the same element and we check if nums[abs[ nums[ i ]] - 1] is negative means that this element was already presnt in array and is duplicate  	 




## String
16. 8 String to Integer (atoi) :
	- Approach 1 : time 0(n), space 0(n)
		- convert string to char array  
		- handle whitespaces case, iterate over the char array while there is " " (make sure to check that the pointer is within the range of array lemgth)
		- check for + or - sign ,
		- iterate while we have digits, while(p<ch.length && (ch[p] >='0' && ch[p]<='9')) and calculate the res i.e res = res* 10 + ch[p]
		- while calculating make sure that the res is within the integer range
17. Count and Say :
	- Approach 1: Time 0(n) , space 0(n) (RECURSION STACK) 
		- base case if n = 1 , return "11", if n = 2 return "11"
		- for n = 3 , we need to look at n=2 result i.e. "11" and from that we make , "21"  (count of 1 + number)
		- for n = 4 , we need to look at n = 3 result i.e. "21" , "1211" (count of 2 + number + count of 1 + number)
		- From this we can easily make out that its a recursion problem , get result for n-1 and from that make result for n.
18. 14 Longest Common Prefix :
	- Approach 1 : Time 0(sum of length of string), space 0(1)
		- iterate over first elements character (for i = 0 ; i<arr[0].length();i++)
			- inside that iterate over remaining elements of the array and check if element from outside loop is equal to the arr[j].charAt(i) and strs[j].length()> i then continue
			- else return arr[0].substring(0,i)  
		- if we come out of for loop that meaans all elements are common with first string return first string.
