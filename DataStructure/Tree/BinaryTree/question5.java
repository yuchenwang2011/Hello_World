unordered binary tree --> array --> sorted array --> heap --> binary tree
                            ^
                            |
                            |
                        array sorting

actually you can simply reorder the unordered binary tree to make a binary heap in O(n) time
while this one would be O(nlog(n))

this answer will use min-heap, because after array sorting, the array starts with the smaller num.

public static int traverse(Node node, int count, NodeArray[] arry) {
  if(node == null) {
    return 0;
  } else {
    if(arry != null) {
      arry[count] = node;
    } 
    count++;
    count = traverse(node.getLeft(), count, arry);
    count = traverse(node.getRight(), count, arry);
    return count;
  }
}

public static Node heapifyTree(Node node) {
  int size = traverse(node, 0, null);
  array = new NodeArray[size];
  traverse(node, 0, array); 

  Array.Sort(array); //just igore this part here at this moment, I don't understand it

  for(int i = 0; i < size; i++) {
     array[i].setLeft((2*i+1) >= size? null : array[2*i+1]);
     array[i].setRight((2*i+2 >= size? null : array[2*i+2]));
  }
  return array[0]; //return the new root
}
