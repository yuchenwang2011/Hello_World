/* HashTableChained.java */

package dict;
import list.*;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  private int bucketNum=0;
  private int size=0;
  private DList[] table;
  private int collisionNum=0;

  public HashTableChained(int sizeEstimate) {
	bucketNum = (int) (sizeEstimate/0.75);
	bucketNum = primeNear(bucketNum);
	table = new DList[bucketNum];
	for (int i=0; i< bucketNum; i++) {
		table[i]= new DList();
	}
	size = 0;
  }

  public HashTableChained() {
    bucketNum = 101;
    table = new DList[bucketNum];
    for (int i=0; i< bucketNum; i++) {
    	table[i] = new DList();
    }
    size = 0;
  }

  private static boolean isPrime(int k) {
      if(k <2 )
          return false;
      if(k==2)
          return true;
      if(k%2==0)
          return false;
      if(k==3) 
          return true;
      int limit = (int)(Math.sqrt(k))+1;
      for(int i=3; i<=limit; i+=2) {
          if(k%i==0) 
              return false;
      }
      return true;
  }
  private static int primeNear(int k) {
          while(true) {
              if(isPrime(k)) {
                  return k;
              } else {
                  k+=1;
              }

          }
   }
  
  int compFunction(int code) {
    return Math.abs(code)%size;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Entry insert(Object key, Object value) {
    Entry newEntry = new Entry();
    newEntry.key = key;
    newEntry.value = value;
    int position = compFunction(key.hashCode());
    if (!table[position].isEmpty()) {
    	collisionNum++;
    }
    table[position].insertBack(newEntry);
    size++;
    return newEntry;
  }

  public Entry find(Object key) {
    int position = compFunction(key.hashCode());
    ListNode node = table[position].front();
    while (node.isValidNode()) {
    	    try {
    	      if( ((Entry) node.item()).key.equals(key)  ) {
    	    	     return ((Entry) node.item()); 
    	      } else {
    	    	     node = node.next();
    	      }
    	    }
    	    catch (InvalidNodeException e) {
    	    	  System.err.println(e);
    	    }
    }
    return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    int position =  compFunction(key.hashCode());
    ListNode node = table[position].front();
    if (node.isValidNode()) {
    	  try {
    		  if ( ((Entry) node.item()).key.equals(key) ) {
    			  node.remove();
    			  size--;
    			  return ((Entry) node.item());
    		  } else {
    			  node = node.next();
    		  }
    	  }
    	  catch (InvalidNodeException e) {
    		  System.err.println(e);
    	  }
    } else {
      return null;
    }
  }

  public void makeEmpty() {
    for (int i=0; i<bucketNum; i++) {
    	  table[i]= new DList();
    }
    size =0;
    collisionNum =0;
  }

}
