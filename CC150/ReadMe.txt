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
    Sample code to implement a stack using a linked list:
    Class Stack[
        Node top;
        Object pop(){
            if(top != null) {
                Object item = top.data;
                top = top.next;
                return item;
            }
            return null;
        }
        Object push(Object item){
            Node t = new Node(item);
            t.next = pop;
            top = t;
        }
        Object peek(){
            return top.data;
        }
    }
    Question 3.1, 3.2, 3.3, 3.4* and 3.7 are worthy to re-think. 
Chapter 4 Trees and graphs
    If a tree is unbalanced, you should describe your algorithm in terms of both the average and worse case time. 
    
    Full and complete trees are trees in which all leaves are at the bottom of the tree, and all non-leaf nodes
        have exactly two children. Note that full and complete trees are extremely rare, as a tree must have exactly
        2^n - 1 node to meet this condition. 
    A trie, each path down the tree may represent a word.
    
    DFS is typically the easiest if we want to visit every node in the graph, or at least visit evry node until we
        find whatever we're looking for. However, if we have a very large tree and want to be prepared to quite when 
        we get too far from the original node, DFS can be problematic. We might search thousands of ancestors of the 
        node, but never even search all of the node's children. BFS is typically prefered. 
    Note that pre-order and other forms of tree traversal are a form of DFS. The key difference is that when
        implementing this algorithm for a graph, we must check if the node has been visited. If we don't, we risk
        getting stuck in infinite loop.
    The pseudocode below implements DFS: 
        void search(Node root){
            if(root == null) return;
            visit(root);
            root.visited = true;
            foreach(Node n in root.adjacent){
                if(n.visited == false) search(n);
            }
        }
    
    BFS, we visit a node's adjacent nodes first before searching it's children. An iterative solution with a queue:
        void search(Node root){
            Queue queue = new Queue();
            root.visited = true;
            visit(root);
            queue.enqueue(root); //add to end of queue
            
            while(!queue.isEmpty()){
                Node r = queue.dequeue(); // Remove from front of queue
                foreach (Node n in r.adjacent) {
                    if(n.visited == false) [
                        visit(n);
                        n.visited = true;
                        queue.enqueue(n);
                    }   
                }
            }
        }
    Question 4.2, 4.5, 4.6, 4.7, 4.8, 4.9 are worthy to review.

Chapter 5 Bit Manipulation
Chapter 6 Brain Teasers
    You have 9 balls, 1 of them is heavier, try to find it using 2 times scale.
    Answer: we devide the balls into sets of three items each.

Chapter 7 Mathematics and Probability
    The Sieve of Eratosthenes to find a list of prime number.
    P(A and B) = P(B given A) * P(A), for example, the probability to find an even number between 1 and 5 from 1 to 10.
    P(x is even and x <= 5) = P(x is even and given x <= 5) * P(x <= 5) = 2/5 * 1/2 = 1/5
    P(x is even or x <= 5) = P(x is even) + P(x<=5) - P(x is even and x<=5) = 1/2 + 1/2 - 1/5 = 4/5
    Mutually exclusive means that A happens, then B won't happen.

Chapter 8 Object-Oriented Design *************This chapter is important, review whole chapter a few times!!!!
    First, Six W method: Who, When, Where, What, HoW, Why to ask interviewers to narrow down the question
    Second, design the core products
    Third, Analyze relationships
    Fourth, Define actions

Chapter 9 Recursion and Dynamic Programming

Chapter 10 Scalability and Memory Limits *****************This is very important Chapter need review!!!!

Chapter 11 Sorting and Searching ***********This Chapter very important!!!
    1. Bubble Sort: average and worst both O(n^2), best is O(n), memory O(1).
    2. Selection Sort: average and worse both O(n^2), memory O(1)
    3. Insertion Sort: 
    4. Merge Sort: average and worse both O(nlog(n)), memory depends
    5. Quick Sort: average O(nlog(n)), worse case O(n^2), memory O(logN).
    6. Radix Sort: O(kn)
    7. Count Sort: 
    8. Heap Sort:
    9. Bucket Sort:
