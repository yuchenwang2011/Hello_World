package newHW4;

public class LockDList extends DList{
   
	protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
		return new LockDListNode(item,prev,next);
	}
	
	
	public void lockNode (DListNode d) {
	   if (d instanceof LockDListNode) {
		   ((LockDListNode) d).locked = true;
	   }
   }
   
	  public void remove(DListNode d) {
        if (d instanceof LockDListNode) {
        	if (((LockDListNode) d).locked == false) {
        		super.remove(d);
        	}
        }
	  }
	  
	  public static void main(String[] args) {
		    testEmpty();
		    testAfterInsertFront();
		    testAfterInsertEnd();
	  }
	  
	  private static void testEmpty() {
		    LockDList lst1 = new LockDList();
		    LockDList lst2 = new LockDList();
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
		    System.out.println("hahaa");
	  }
	  
	  private static void testAfterInsertFront() {
		    LockDList lst1 = new LockDList();
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
		    System.out.println("haha2a");
		  }
	  
	  private static void testAfterInsertEnd() {
		    LockDList lst1 = new LockDList();
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
		    System.out.println("haha3a");
		  }
}
