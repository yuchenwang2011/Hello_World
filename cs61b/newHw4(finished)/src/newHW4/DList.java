package newHW4;

public class DList {
	  protected DListNode head;
	  protected int size;

	  /* DList invariants:
	   *  1)  head != null.
	   *  2)  For any DListNode x in a DList, x.next != null.
	   *  3)  For any DListNode x in a DList, x.prev != null.
	   *  4)  For any DListNode x in a DList, if x.next == y, then y.prev == x.
	   *  5)  For any DListNode x in a DList, if x.prev == y, then y.next == x.
	   *  6)  size is the number of DListNodes, NOT COUNTING the sentinel,
	   *      that can be accessed from the sentinel (head) by a sequence of
	   *      "next" references.
	   */

	  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
	    return new DListNode(item, prev, next);
	  }

	  /**
	   *  DList() constructor for an empty DList.
	   */
	  public DList() {
	     head = newNode(null,null,null);
	     head.next = head;
	     head.prev = head;
	     size = 0;
	  }

	  public boolean isEmpty() {
	    return size == 0;
	  }

	  public int length() {
	    return size;
	  }

	  public void insertFront(Object item) {
	    if (size == 0) {
	       DListNode node = newNode(item,head,head);
	       head.next = node;
	       head.prev = node;
	    } else if (size >0) {
	       DListNode node = newNode(item,head,head.next);
	       head.next.prev = node;
	       head.next = node;
	    }
	    size++;
	  }

	  public void insertBack(Object item) {
	    if (size == 0) {
	    	DListNode node = newNode(item,head,head);
	    	head.next = node;
	    	head.prev = node;
	    } else if (size >0) {
	    	DListNode node = newNode(item,head.prev,head);
	    	head.prev.next = node;
	    	head.prev = node;
	    }
	    size++;
	  }

	  public DListNode front() {
	    if (size == 0) {
	    	return null;
	    } else {
	    	return head.next;
	    }
	  }

	  public DListNode back() {
	    if (size == 0) {
	    	return null;
	    } else {
	    	return head.prev;
	    }
	  }

	  public DListNode next(DListNode node) {
	    if (size == 0) {
	    	return null;
	    } else if (node.next == head) {
	    	return null;
	    } else {
	    	return node.next;
	    }
	  }

	  public DListNode prev(DListNode node) {
	    if (size == 0) {
	    	return null;
	    } else if  (node.prev == head ){
	        return null;
	    } else {
	    	return node.prev;
	    }
	  }

	  public void insertAfter(Object item, DListNode node) {
	    if (node != null) {
	    	DListNode node2 = newNode(item,node,node.next);
	    	node.next.prev = node2;
	    	node.next = node2;
	    }
	    size ++;
	  }

	  public void insertBefore(Object item, DListNode node) {
	    if (node != null) {
	    	DListNode node2 = newNode (item, node.prev,node);
	    	node.prev.next = node2;
	    	node.prev = node2;
	    }
	    size ++;
	  }

	  public void remove(DListNode node) {
	    if (size == 1) {
	    	head = null;
	    } else if (size >1) {
	    	DListNode prevNode = node.prev;
	    	DListNode nextNode = node.next;
	    	prevNode.next = nextNode;
	    	nextNode.prev = prevNode;
	    }
	    size --;
	  }

	  /**
	   *  toString() returns a String representation of this DList.
	   *
	   *  DO NOT CHANGE THIS METHOD.
	   *
	   *  @return a String representation of this DList.
	   *  Performance:  runs in O(n) time, where n is the length of the list.
	   */
	  public String toString() {
	    String result = "[  ";
	    DListNode current = head.next;
	    while (current != head) {
	      result = result + current.item + "  ";
	      current = current.next;
	    }
	    return result + "]";
	  }
	  
	  public static void main(String[] args) {
		    testEmpty();
		    testAfterInsertFront();
		    testAfterInsertEnd();
	  }
	  
	  private static void testEmpty() {
		    DList lst1 = new DList();
		    DList lst2 = new DList();
		    System.out.println("Here is a list after construction: "
				       + lst1.toString());
		    TestHelper.verify(lst1.toString().equals("[  ]"),
				      "toString on newly constructed list failed");
		    System.out.println("isEmpty() should be true. It is: " +
				       lst1.isEmpty());
		    TestHelper.verify(lst1.isEmpty() == true,
				      "isEmpty() on newly constructed list failed");    

		    System.out.println("length() should be 0. It is: " +
				       lst1.length());
		    TestHelper.verify(lst1.length() == 0, 
				      "length on newly constructed list failed");    
		    lst1.insertFront(new Integer(3));
		    System.out.println("Here is a list after insertFront(3) to an empty list: "
				       + lst1.toString());
		    TestHelper.verify(lst1.toString().equals("[  3  ]"),
				      "InsertFront on empty list failed");
		    lst2.insertBack(new Integer(5));
		    System.out.println("Here is a list after insertBack(5) on an empty list: "
				       + lst2.toString());
		    TestHelper.verify(lst2.toString().equals("[  5  ]"),
				      "insertEnd on empty list failed");
		    System.out.println("haha");
	  }
	  
	  private static void testAfterInsertFront() {
		    DList lst1 = new DList();
		    lst1.insertFront(new Integer(3));
		    lst1.insertFront(new Integer(2));
		    lst1.insertFront(new Integer(1));
		    System.out.println();
		    System.out.println("Here is a list after insertFront 3, 2, 1: "
				       + lst1.toString());
		    TestHelper.verify(lst1.toString().equals("[  1  2  3  ]"),
				      "InsertFronts on non-empty list failed");
		    System.out.println("isEmpty() should be false. It is: " +
				       lst1.isEmpty());
		    TestHelper.verify(lst1.isEmpty() == false,
				      "isEmpty() after insertFront failed");    
		    System.out.println("length() should be 3. It is: " +
				       lst1.length());
		    TestHelper.verify(lst1.length() == 3, 
				      "length() after insertFront failed");
		    lst1.insertBack(new Integer(4));
		    System.out.println("Here is the same list after insertEnd(4): "
				       + lst1.toString());
		    TestHelper.verify(lst1.toString().equals("[  1  2  3  4  ]"),
				      "insertEnd on non-empty list failed");
		    System.out.println("haha2");
		  }
	  
	  private static void testAfterInsertEnd() {
		    DList lst1 = new DList();
		    lst1.insertBack(new Integer(6));
		    lst1.insertBack(new Integer(7));
		    System.out.println();
		    System.out.println("Here is a list after insertEnd 6, 7: "
				       + lst1.toString());
		    System.out.println("isEmpty() should be false. It is: " +
				       lst1.isEmpty());
		    TestHelper.verify(lst1.isEmpty() == false,
				      "isEmpty() after insertEnd failed");    
		    System.out.println("length() should be 2. It is: " +
				       lst1.length());
		    TestHelper.verify(lst1.length() == 2, 
				      "length() after insertEndfailed");
		    lst1.insertFront(new Integer(5));
		    System.out.println("Here is the same list after insertFront(5): "
				       + lst1.toString());
		    TestHelper.verify(lst1.toString().equals("[  5  6  7  ]"),
				      "insertFront after insertEnd failed");
		    System.out.println("haha3");
		  }
}
