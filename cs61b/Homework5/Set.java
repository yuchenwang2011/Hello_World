import list.*;

public class Set {
  private List mySet;

  public Set() { 
	 mySet = new DList();
  }

  public int cardinality() {
    return mySet.length();
  }

  public void insert(Comparable c) {
    if(mySet.isEmpty()) {
    	mySet.insertBack(c);
    } else {
    	try { 	
    	  ListNode currentNode = mySet.front();
    	  
    	  while (currentNode.isValidNode()) {
    		  int compareResult = ((Comparable) currentNode.item()).compareTo(c);
    		  if (compareResult < 0) {
    			  currentNode = currentNode.next();
    	  	  } else if (compareResult == 0) {
    	  		  break;
    	  	  } else {
    	  		  currentNode.insertBefore(c);
    	  		  break;
    	  	  }  	  	  
      	  }
    	  if (!currentNode.isValidNode()) {
    		  mySet.insertBack(c);
    	  }
    	} catch (InvalidNodeException e) {
    		System.out.println ("An InvalidNodeException is catched");
    	}
    }
  }

  public void union(Set s) {
    if (s.mySet.length() >= 1 && this.mySet.length() >= 1) {
       ListNode p1 = this.mySet.front();
       ListNode p2 = s.mySet.front();
       Comparable c1,c2;
       try {
         while (p2.isValidNode()) {
        	 c1 = (Comparable) (p1.item());
        	 c2 = (Comparable) (p2.item());
    	     int compareResult = c1.compareTo(c2);
    	     if(compareResult < 0) {
    		   p1 = p1.next();
    		   System.out.println("compareResult is: " + compareResult);
    	     } else if (compareResult == 0) {
    	    	 
    	    	 p1 = p1.next();
    	    	 p2 = p2.next();
    	     } else {
    	    	 
    	    	 this.insert((Comparable) p1.item());
    	    	 p2 = p2.next();
    	     }
    	     
    	     if (!p1.isValidNode()) {
                 mySet.back().insertAfter(p2.item());
                 p2 = p2.next();
                 continue;
             }
         }    	 
       } catch (InvalidNodeException e) {
        	 System.out.println ("Invalid node exception is caught by union method");
       }
    } else if (s.mySet.length() == 1 && this.mySet.length() == 0) {
    	this.mySet = s.mySet;
    } else {
    	;
    }
  }

  public void intersect(Set s) {
    if (this.mySet.length() >=1 && s.mySet.length() >=1) {
    	ListNode p1 = this.mySet.front();
    	ListNode p2 = s.mySet.front();
    	
    	try {
    	  while (p1.isValidNode()) {
    	    int compareResult = ((Comparable) p1.item()).compareTo((Comparable) p2.item());
    	    if (compareResult < 0 ) {
    		    ListNode removeNode = p1;
    		    p1 = p1.next();
    		    removeNode.remove();
    	    } else if (compareResult == 0) {
    		    p1 = p1.next();
    		    p2 = p2.next();
    	    } else {
    	    	p2 = p2.next();
    	    }
    	    
    	    if (!p2.isValidNode()) {
                if (!p1.next().isValidNode()) {
                    p1.remove();
                    //break;
                } else {
                    p1 = p1.next();
                    p1.prev().remove();
                    //continue;
                }
            }
    	    
    	  }
    	} catch (InvalidNodeException e) {
    		System.err.println("invalid node exception is caught by intersect method");
    	}
    	
    } else if (this.mySet.length() == 0 && s.mySet.length() == 1) {
    	this.mySet = s.mySet;
    } else {
    	;
    }
  }

  /**
   *  toString() returns a String representation of this Set.  The String must
   *  have the following format:
   *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
   *            between them.
   *    {  1  2  3  } for a Set of three Integer elements.  No spaces before
   *            "{" or after "}"; two spaces before and after each element.
   *            Elements are printed with their own toString method, whatever
   *            that may be.  The elements must appear in sorted order, from
   *            lowest to highest according to the compareTo() method.
   **/
  public String toString() {
    String myString = "{ ";
    ListNode p = this.mySet.front();
    
    while (p.isValidNode()) {
    	try { 
          myString = myString + p.item().toString() + " ";
    	  p = p.next();
    	} catch (InvalidNodeException e) {
    		System.err.println("invalid node exception is caught by toString method");
    	}
    }
    
    myString = myString + "}";
    return myString;
  }

  public static void main(String[] argv) {
    Set s = new Set();
    s.insert(new Integer(3));
    s.insert(new Integer(4));
    s.insert(new Integer(3));
    System.out.println("Set s = " + s);

    Set s2 = new Set();
    s2.insert(new Integer(4));
    s2.insert(new Integer(5));
    s2.insert(new Integer(5));
    System.out.println("Set s2 = " + s2);

    Set s3 = new Set();
    s3.insert(new Integer(5));
    s3.insert(new Integer(3));
    s3.insert(new Integer(8));
    System.out.println("Set s3 = " + s3);

    s.union(s2);
    System.out.println("After s.union(s2), s = " + s);

    s.intersect(s3);
    System.out.println("After s.intersect(s3), s = " + s);

    System.out.println("s.cardinality() = " + s.cardinality());
    // You may want to add more (ungraded) test code here.
  }
}
