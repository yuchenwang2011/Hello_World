package dict;

public class BinaryTree implements Dictionary {

  protected int size;
  protected BinaryTreeNode root;

  public BinaryTree() {
    makeEmpty();
  }

  public void makeEmpty() {
    size = 0;
    root = null;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Entry insert(Object key, Object value) {
    Entry entry = new Entry(key, value);
    if (root == null) {
      root = new BinaryTreeNode(entry);
    } else {
      insertHelper(entry, (Comparable) key, root);
    }

    size++;
    return entry;
  }

  private void insertHelper(Entry entry, Comparable key, BinaryTreeNode node) {
    if (key.compareTo(node.entry.key()) <= 0) {
      if (node.leftChild == null) {
	    node.leftChild = new BinaryTreeNode(entry, node);
      } else {
	    insertHelper(entry, key, node.leftChild);
      }
    } else {
      if (node.rightChild == null) {
	    node.rightChild = new BinaryTreeNode(entry, node);
      } else {
	    insertHelper(entry, key, node.rightChild);
      }
    }
  }

  public Entry find(Object key) {
    BinaryTreeNode node = findHelper((Comparable) key, root);
    if (node == null) {
      return null;
    } else {
      return node.entry;
    }
  }

  private BinaryTreeNode findHelper(Comparable key, BinaryTreeNode node) {
    if(key.compareTo(node.entry.key) ==0) {
    	  return node;
    } else if (key.compareTo(node.entry.key) < 0) {
    	  if (node.leftChild==null) {
    		  return null;
    	  } else {
    		  return findHelper(key, node.leftChild);
    	  }
    } else {
    	   if (node.rightChild==null) {
    		   return null;
    	   } else {
    		   return findHelper(key, node.rightChild);
    	   }
    }
  }

  public Entry remove(Object key) {
    BinaryTreeNode node = findHelper((Comparable) key, root);
    if (node == null) {
    	   return null;
    } else {
       //no child
    	   if (node.leftChild == null && node.rightChild == null) {
    		  if (node == root) {
    			  root = null;
    			  return null;
    		  } else {
    			  if (node.parent.leftChild == node) {
    				  node.parent.leftChild = null;
    			  } else {
    				  node.parent.rightChild = null;
    			  }
    			size --;
    			node.parent = null;
    			return node.entry;
    		  }
    	   // has only left child
    	   } else if (node.leftChild != null && node.rightChild == null) {
    		  if (node == root) {
    			  root = node.leftChild;
    			  node.leftChild.parent = null;
    			  node.leftChild = null;
    			  return node.entry;
    		  } else {
    			  if (node.parent.leftChild == node) {
    				  node.parent.leftChild = node.leftChild;
    			  } else {
    				  node.parent.rightChild = node.leftChild;
    			  }
    			  node.leftChild.parent = node.parent;
    			  node.leftChild = null;
    			  node.parent = null;
    		  }
		  size --;
		  return node.entry;
    	   // has only one right child
    	   } else if (node.leftChild == null && node.rightChild != null) {
    		   if (node == root) {
    			   root = node.rightChild;
    			   node.rightChild.parent = null;
    			   node.rightChild = null;
    		   } else {
    			   if (node.parent.leftChild == node) {
    				   node.parent.leftChild = node.rightChild;
    			   } else if (node.parent.rightChild == node) {
    				   node.parent.rightChild = node.rightChild;
    			   }
    			 node.rightChild.parent = node.parent;
        		 node.rightChild = null;
    		   }
    		   node.parent = null;
    		   size --;
    		   return node.entry;
    	   } else if (node.leftChild != null && node.rightChild != null) {
    		   BinaryTreeNode iterNode = node.rightChild;
    		   while (iterNode.leftChild != null) {
    			   iterNode = iterNode.leftChild;
    		   }
    		   Entry nodeEntry = node.entry;
    		   node.entry = iterNode.entry;
    		   if (iterNode == iterNode.parent.rightChild) {
    			   iterNode.parent.rightChild = iterNode.rightChild;
    			   if (iterNode.rightChild != null) {
    			     iterNode.rightChild.parent = iterNode.parent;
    			   }
    		   } else if (iterNode == iterNode.parent.leftChild) {
    			   iterNode.parent.leftChild = iterNode.rightChild;
    			   if (iterNode.rightChild != null) {
    			     iterNode.rightChild.parent = iterNode.parent;
    			   }
    		   }
		   iterNode.rightChild = null;
		   iterNode.parent = null;
		   size --;
           return nodeEntry;
    	   }
    }
	return null;
  }

  public String toString() {
    if (root == null) {
      return "";
    } else {
      return root.toString();
    }
  }

  /* Tests the binary search tree. */
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    System.out.println("Inserting 1A, 6V, 3K, 2Z, 5L, 9L:");
    tree.insert(new Integer(1), "A");
    tree.insert(new Integer(6), "V");
    tree.insert(new Integer(3), "K");
    tree.insert(new Integer(2), "Z");
    tree.insert(new Integer(5), "L");
    tree.insert(new Integer(9), "L");
    System.out.println("The tree is:  " + tree);
    System.out.println("Size:  " + tree.size());

    System.out.println("\nTesting find() ...");
    tree.testFind(1, "A");
    tree.testFind(9, "L");
    tree.testFind(5, "L");
    tree.testFind(4, null);
    tree.testFind(6, "V");
    tree.testFind(3, "K");

    System.out.println("\nTesting remove() (for nodes with < 2 children) ...");
    tree.testRemove(5, "1A(((2Z)3K)6V(9L))");
    tree.testRemove(3, "1A((2Z)6V(9L))");
    tree.testRemove(1, "(2Z)6V(9L)");
    tree.insert(new Integer(7), "S");
    tree.insert(new Integer(8), "X");
    tree.insert(new Integer(10), "B");
    System.out.println("After inserting 7S, 8X, 10B:  " + tree);
    System.out.println("Size:  " + tree.size());
    if (tree.size() != 6) {
      System.out.println("  SHOULD BE 6.");
    }

    System.out.println("\nTesting remove() (for nodes with 2 children) ...");
    tree.testRemove(6, "(2Z)7S((8X)9L(10B))");
    tree.testRemove(9, "(2Z)7S((8X)10B)");
    System.out.println("Size:  " + tree.size());
    if (tree.size() != 4) {
      System.out.println("  SHOULD BE 4.");
    }
  }

  private void testRemove(int n, String shouldBe) {
    Integer key = new Integer(n);
    System.out.print("After remove(" + n + "):  ");
    remove(key);
    System.out.println(this);
    if (!toString().equals(shouldBe)) {
      System.out.println("  SHOULD BE " + shouldBe);
    }
  }

  private void testFind(int n, Object truth) {
    Integer key = new Integer(n);
    Entry entry = find(key);
    System.out.println("Calling find() on " + n);
    if (entry == null) {
      System.out.println("  returned null.");
      if (truth != null) {
        System.out.println("  SHOULD BE " + truth + ".");
      }
    } else {
      System.out.println("  returned " + entry.value() + ".");
      if (!entry.value().equals(truth)) {
        if (truth == null) {
          System.out.println("  SHOULD BE null.");
        } else {
          System.out.println("  SHOULD BE " + truth + ".");
        }
      }
    }
  }
  
}
