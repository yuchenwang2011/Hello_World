public class SList {
    private SListNode head;
    private int size;
    
    public SList() {
    	  head = null;
    	  size = 0;
    }
    public int getSize() {
    	  return size;
    }  
    public boolean isEmpty() {
    	  return size == 0;
    }
    public void insertFront(Object value) {
      SListNode newNode = new SListNode(value,null);
    	  if(size == 0) {
    		  head = newNode;
    	  } else {
    		  newNode.setNext(head);	
    		  head = newNode;
    	  }
    	  size++;
    }
    public void insertEnd(Object value) {
    	  SListNode newNode = new SListNode(value);
    	  if(size == 0) {
    		 head = newNode;
    	  } else {
    		 SListNode tmp = head.getNext();
    		 while(tmp.getNext() != null) {
    			 tmp = tmp.getNext();
    		 }
    		 tmp.setNext(newNode);
    	  }
    	  size++;
    }
    public void delete(Object value) {
    	  if (find(value) == null) {
    		  System.err.println(value + " doesn't exist in this list");
    	  } else {
    		  SListNode currentNode = head;
    		  SListNode nextNode = currentNode.getNext();
    		  if (currentNode.getValue().toString().equals(value.toString())) {
    			currentNode.setNext(null);
    			head = nextNode;
    		  } else {
    		    while(!nextNode.getValue().toString().equals(value.toString())) {
    			    currentNode = nextNode;
    		  	    nextNode = nextNode.getNext();
    		    }
    		    currentNode.setNext(nextNode.getNext());
    		    nextNode.setNext(null);
    		  }
    		  size --;
    	  }
    }

    public Object nth(int position) {
    	   if (position <1 || position > size) {
    		   return null;
    	   } else {
    		   SListNode tmp = head;
    		   int trav = 1;
    		   while (trav != position) {
               tmp = tmp.getNext();
    			   trav ++;
    		   }
    		   return tmp.getValue();
    	   }
    }
    public String toString() {
    	  String result = new String();
    	  result = "[ ";
    	  SListNode tmp = head;
    	  while(tmp != null) {
    		  result = result + tmp.getValue().toString() + " ";
    		  tmp = tmp.getNext();
    	  }
    	  result = result + "]";
    	  return result;
    }
    
    public SListNode find(Object value) {
  	  SListNode tmp = this.head;
  	  while(tmp != null) {
  	     if (tmp.getValue().toString().equals(value.toString())) {
  	    	   return tmp;
  	     } else {
  	    	   tmp = tmp.getNext();
  	     }
      }
  	  return tmp;
    }
    public static void main (String[] args) {
    	  SList myList = new SList();
    	  myList.insertFront("1");
    	  System.out.println(myList.toString());
    	  myList.insertFront(0);
    	  System.out.println(myList.toString());
    	  myList.insertEnd(2);
    	  System.out.println(myList.toString());
    	  myList.insertEnd(3);
    	  System.out.println(myList.toString());
    	  
    	  System.out.println("the 1st:" + myList.nth(1));
    	  System.out.println("the 2nd:" + myList.nth(2));
    	  System.out.println("the 3rd:" + myList.nth(3));
    	  
    	  System.out.println(myList.find(0).getValue());
    	  System.out.println(myList.find(11));
    	  myList.delete(3);
    	  System.out.println(myList.toString());
    	  myList.delete(0);
    	  System.out.println(myList.toString());
    	  myList.delete(2);
    	  System.out.println(myList.toString());
    	  myList.delete(12);
    	  System.out.println(myList.toString());
    }
}

