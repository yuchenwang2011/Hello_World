package list;

public class DListNode extends ListNode {

  /**
   *  (inherited)  item references the item stored in the current node.
   *  (inherited)  myList references the List that contains this node.
   **/
  protected DListNode prev;
  protected DListNode next;

  DListNode(Object i, DList l, DListNode p, DListNode n) {
    item = i;
    myList = l;
    prev = p;
    next = n;
  }

  public boolean isValidNode() {
    return myList != null;
  }

  public ListNode next() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("next() called on invalid node");
    }
    return next;
  }

  public ListNode prev() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("prev() called on invalid node");
    }
    return prev;
  }

  public void insertAfter(Object item) throws InvalidNodeException {
    if (!isValidNode()) {
    	throw new InvalidNodeException("insertAfter() called an invalid node");
    }
    DListNode node2 = ((DList) myList).newNode(item, (DList) myList, this, this.next);
    this.next.prev = node2;
    this.next = node2; 
    this.myList.size++;
  }

  public void insertBefore(Object item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("insertBefore() called an invalid node");
    } else {
    DListNode node2 = ((DList) myList).newNode(item, (DList) myList, this.prev, this);
    this.prev.next = node2;
    this.prev = node2;
    this.myList.size++;
    }
  }

  public void remove() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("remove() called on invalid node");
    } else {
    this.prev.next = this.next;
    this.next.prev = this.prev;
    this.prev = null;
    this.next = null;
    this.myList.size --;
    myList = null;
    }
  }
}
