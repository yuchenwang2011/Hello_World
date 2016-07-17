This is my note working on the book <<Cracking the Coding Interview 5th version>>.
Chapter 1 Array:
    In a very simple implementation of a hash table, the hash table has an underlying array and a hash function. When you want to insert 
        an object and its key, the hash function maps the key to an integer, which indicates the index in the array. The object is then 
        stored at that index.
    Instead of making an extremly large array and storing objects at index hash(key), we can make the array much smaller and store 
        objects in a linked list at index hash(key) % array_length. To get the object with a particular key, we must search the linked 
        list for this key.
    An arraylist, or a dynamically resizing array, is an array that resizes itself as needed while still providing O(1) access. A typical
        implementation is that when the array is full, the array doubles in size. Each doubling takes O(n) time, but happens so rarely 
        that it's amortized time is still O(1).
    If you don't use string builder but just string = "x" + "y" + "z", assuming each string is x length, you need to combine n of them, 
        the complexity is O(x + 2x + ...+ nx) = O(n^2). Because each time a new string is created and two strings are copied over, 
        character by character. 
    Question 1.6 is worthy to re-think. 

Chapter 2 Linked List: 
    Question 2.7 is worthy to re-think recursive answer, but refer to my leetcode answer.

Chapter 3 Stacks and Queues

Chapter 4 Trees and graphs

Chapter 5 Bit Manipulation
    
