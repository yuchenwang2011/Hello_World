package dict;

public class Tree234 extends IntDictionary {

  Tree234Node root;

  public Tree234() {
    root = null;
    size = 0;
  }

  public String toString() {
    if (root == null) {
      return "";
    } else {
      /* Most of the work is done by Tree234Node.toString(). */
      return root.toString();
    }
  }

  public void printTree() {
    if (root != null) {
      /* Most of the work is done by Tree234Node.printSubtree(). */
      root.printSubtree(0);
    }
  }

  public boolean find(int key) {
    Tree234Node node = root;
    while (node != null) {
      if (key < node.key1) {
        node = node.child1;
      } else if (key == node.key1) {
        return true;
      } else if ((node.keys == 1) || (key < node.key2)) {
        node = node.child2;
      } else if (key == node.key2) {
        return true;
      } else if ((node.keys == 2) || (key < node.key3)) {
        node = node.child3;
      } else if (key == node.key3) {
        return true;
      } else {
        node = node.child4;
      }
    }
    return false;
  }

  /**
   *  insert() inserts the key "key" into this 2-3-4 tree.  If "key" is
   *  already present, a duplicate copy is NOT inserted.
   *
   *  @param key is the key sought.
   **/
  public void insert(int key) {
	if (this.find(key)!=true) {
	  Tree234Node node = root;
	  if (node == null) {
		  root = new Tree234Node (null,key);
		  return;
	  }
	  if (node.keys == 3) {
		  System.out.println("node kys 3");
		  if (key<=node.key2) {
			  rearrangeNode(node);
		  } else {
			  node = rearrangeNode(node);
		  }
	  }

	  while (node.child1 != null) {
		  System.out.println("we are in the while loop");
		  //this rearrange is for below if, we have to make sure when we loop down to a 3-key node, we rearrange it
		  // and also the node should not have more than 3 children after the arrangement??????
		  if (node.keys ==3) {
			  if (key<node.key2) {
				  rearrangeNode(node);
			  } else {
				  node = rearrangeNode(node);
			  }
		  }
		  
		  if (key<=node.key1) {
			  node=node.child1;
		  } else if (node.keys == 1 || key<=node.key2) {
			  node=node.child2;
		  } else {
			  node = node.child3;
		  }
		  
		  //for the case where the last node has 3 keys and its child1 is null
		  //since the while loop won't go through it, we have to rearrange the node at the end
		  if (node.keys==3) {
			  if (key<node.key2) {
				  rearrangeNode(node);
			  } else {
				  node = rearrangeNode(node);
			  }
		  }
	  }
	  if(key<node.key1) {
		 System.out.println("insert key if condition 1");
		 node.key3 = node.key2;
		 node.key2 = node.key1;
		 node.key1 = key;
	  } else if (node.keys == 1 || key<node.key2) {
		 System.out.println("insert key if condition 2");
		 node.key3 = node.key2;
		 node.key2 = key;
	  } else {
		  System.out.println("insert key if condition 3");
		    System.out.println("check port 1");
		    String treeString = toString();
		    System.out.println(treeString);
		    System.out.println("check port 2");
		    System.out.println(node.key2);
		    
		  node.key3 = key;
	  }
	  node.keys++;
	  size++;  
	}
  }
  
  private Tree234Node rearrangeNode(Tree234Node node) {
      if (node.parent == null) {
          Tree234Node newRoot = new Tree234Node(null, node.key2);
          newRoot.child1 = node;
          node.parent = newRoot;
          newRoot.child2 = deleteNSplitNode(node);
          root = newRoot;
          return newRoot.child2;
      } else {
    	  if (node.key2<node.parent.key1) {
    		  node.parent.key3 = node.parent.key2;
    		  node.parent.key2 = node.parent.key1;
    		  node.parent.key1 = node.key2;
    	  } else if (node.key2==node.parent.key1 || node.key2 < node.parent.key2) {
    		  node.parent.key3 = node.parent.key2;
    		  node.parent.key2 = node.key2;
    	  } else {
    		  node.parent.key3 = node.key2;  
    	  }
    	  node.keys++;
    	  
          if (node.parent.child1 == node) {
              node.parent.child4 = node.parent.child3;
              node.parent.child3 = node.parent.child2;
              node.parent.child2 = deleteNSplitNode(node);
              return node.parent.child2;
          } else if (node.parent.child2 == node) {
              node.parent.child4 = node.parent.child3;
              node.parent.child3 = deleteNSplitNode(node);
              return node.parent.child3;
          } else if (node.parent.child3 == node) {
              node.parent.child4 = deleteNSplitNode(node);
              return node.parent.child4;
          } else {
              System.out.println("Error, Node is not child");
              return new Tree234Node(null, 0);
          }
      }
  }

  private Tree234Node deleteNSplitNode(Tree234Node node) {
      Tree234Node newNode = new Tree234Node(node.parent, node.key3);
      node.keys = 1;
      if (node.child1 != null) {
          newNode.child1 = node.child3;
          newNode.child2 = node.child4;
          newNode.child1.parent = newNode.child2.parent = newNode;
          node.child3 = node.child4 = null;
      }
      return newNode;
  }

  

  public void testHelper(String correctString) {
    String treeString = toString();
    System.out.println(treeString);
    if (!treeString.equals(correctString)) {
      System.out.println("ERROR:  Should be " + correctString);
    }
  }

  public static void main(String[] args) {
    Tree234 t = new Tree234();

    System.out.println("\nInserting 84.");
    t.insert(84);
    t.testHelper("84");

    System.out.println("\nInserting 7.");
    t.insert(7);
    t.testHelper("7 84");

    System.out.println("\nInserting 22.");
    t.insert(22);
    t.testHelper("7 22 84");

    System.out.println("\nInserting 95.");
    t.insert(95);
    t.testHelper("(7)22(84 95)");

    System.out.println("\nInserting 50.");
    t.insert(50);
    t.testHelper("(7)22(50 84 95)");

    System.out.println("\nInserting 11.");
    t.insert(11);
    t.testHelper("(7 11)22(50 84 95)");

    System.out.println("\nInserting 37.");
    t.insert(37);
    t.testHelper("(7 11)22(37 50)84(95)");

    System.out.println("\nInserting 60.");
    t.insert(60);
    t.testHelper("(7 11)22(37 50 60)84(95)");

    System.out.println("\nInserting 1.");
    t.insert(1);
    t.testHelper("(1 7 11)22(37 50 60)84(95)");

    System.out.println("\nInserting 23.");
    t.insert(23);
    t.testHelper("(1 7 11)22(23 37)50(60)84(95)");

    System.out.println("\nInserting 16.");
    t.insert(16);
    t.testHelper("((1)7(11 16)22(23 37))50((60)84(95))");

    System.out.println("\nInserting 100.");
    t.insert(100);
    t.testHelper("((1)7(11 16)22(23 37))50((60)84(95 100))");

    System.out.println("\nInserting 28.");
    t.insert(28);
    t.testHelper("((1)7(11 16)22(23 28 37))50((60)84(95 100))");

    System.out.println("\nInserting 86.");
    t.insert(86);
    t.testHelper("((1)7(11 16)22(23 28 37))50((60)84(86 95 100))");

    System.out.println("\nInserting 49.");
    t.insert(49);
    t.testHelper("((1)7(11 16)22(23)28(37 49))50((60)84(86 95 100))");

    System.out.println("\nInserting 81.");
    t.insert(81);
    t.testHelper("((1)7(11 16)22(23)28(37 49))50((60 81)84(86 95 100))");

    System.out.println("\nInserting 51.");
    t.insert(51);
    t.testHelper("((1)7(11 16)22(23)28(37 49))50((51 60 81)84(86 95 100))");

    System.out.println("\nInserting 99.");
    t.insert(99);
    t.testHelper("((1)7(11 16)22(23)28(37 49))50((51 60 81)84(86)95(99 100))");

    System.out.println("\nInserting 75.");
    t.insert(75);
    t.testHelper("((1)7(11 16)22(23)28(37 49))50((51)60(75 81)84(86)95" +
                 "(99 100))");

    System.out.println("\nInserting 66.");
    t.insert(66);
    t.testHelper("((1)7(11 16)22(23)28(37 49))50((51)60(66 75 81))84((86)95" +
                 "(99 100))");

    System.out.println("\nInserting 4.");
    t.insert(4);
    t.testHelper("((1 4)7(11 16))22((23)28(37 49))50((51)60(66 75 81))84" +
                 "((86)95(99 100))");

    System.out.println("\nInserting 80.");
    t.insert(80);
    t.testHelper("(((1 4)7(11 16))22((23)28(37 49)))50(((51)60(66)75" +
                 "(80 81))84((86)95(99 100)))");

    System.out.println("\nFinal tree:");
    t.printTree();
  }

}
