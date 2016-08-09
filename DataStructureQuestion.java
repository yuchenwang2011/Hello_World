//This notes covers data strucutre interview questions.
//They way I will answer those questions is, first give a short defination as below, 
//then the interviewer will keep ask you questions, just answer them. 
//Otherwise if I write too long for questions below,  it's hard to remember them even you understand them.
//And remember to review all of them in this cheatsheet
//http://bigocheatsheet.com/
1. What is an Array?
  An array is a container that holds a type of things. The length is fixed after created.

2. What is an arraylist?
  An arraylist is an list that can dynamically grows the length of it's array.
  
3. What is a list? 
  It's a collection.
  
4. What is a hashset?
  It's a set.
  
5. What is a set?
  It's a collection with no duplicate elements. 

6. What is a hashtable?
  It's a table to store key value pairs
  
7. What is a map?
  A object that maps keys to values.
  
8. What is a stack?
  It's a LIFO stack of object

9. What is a queue?
  It's a FIFO collection of objects
  
10. What is a Binary Search Tree?
  It's an ordered container

11. What is a heap?
  It's a special tree data structure that stores things in order, it can be min heap or max heap.


Big O Notation
                     Access    Search     Insertion   Deletion    
Array      Average     O(1)      O(n)        O(n)       O(n)
           Worst       O(1)      O(n)        O(n)       O(n)
Stack      Average     O(n)      O(n)        O(1)       O(1)
           Worst       O(n)      O(n)        O(1)       O(1)
Queue      Average     O(n)      O(n)        O(1)       O(1)
           Worst       O(n)      O(n)        O(1)       O(1)
LinkedList Average     O(n)      O(n)        O(1)       O(1)
           Worst       O(n)      O(n)        O(1)       O(1)
HashTable  Average     N/A      *O(1)*       O(1)       O(1)
           Worst       N/A      *O(n)*       O(n)       O(n)
