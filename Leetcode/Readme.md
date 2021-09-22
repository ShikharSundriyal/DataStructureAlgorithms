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
