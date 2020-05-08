package list;

public class SListNode extends ListNode {

  /**
   *  (inherited)  item references the item stored in the current node.
   *  (inherited)  myList references the List that contains this node.
   **/
  protected SListNode next;

  SListNode(Object i, SList l, SListNode n) {
    item = i;
    myList = l;
    next = n;
  }

  public ListNode next() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("next() called on invalid node");
    }
    if (next == null) {
      // Create an invalid node.
      SListNode node = ((SList) myList).newNode(null, null);
      node.myList = null;
      return node;
    } else {
      return next;
    }
  }

  public ListNode prev() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("prev() called on invalid node");
    }
    SListNode prev = ((SList) myList).head;
    if (prev == this) {
      // Create an invalid node.
      prev = ((SList) myList).newNode(null, null);
      prev.myList = null;
    } else {
      while (prev.next != this) {
        prev = prev.next;
      }
    }
    return prev;
  }

  public void insertAfter(Object item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("insertAfter() called on invalid node");
    }
    SListNode newNode = ((SList) myList).newNode(item, next);
    if (next == null) {
      ((SList) myList).tail = newNode;
    }
    next = newNode;
    myList.size++;
  }

  public void insertBefore(Object item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("insertBefore() called on invalid node");
    }
    SListNode newNode = ((SList) myList).newNode(item, this);
    if (this == ((SList) myList).head) {
      ((SList) myList).head = newNode;
    } else {
      SListNode prev = (SListNode) prev();
      prev.next = newNode;
    }
    myList.size++;
  }

  public void remove() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("remove() called on invalid node");
    }
    if (this == ((SList) myList).head) {
      ((SList) myList).head = next;
      if (next == null) {
        ((SList) myList).tail = null;
      }
    } else {
      SListNode prev = (SListNode) prev();
      prev.next = next;
      if (next == null) {
        ((SList) myList).tail = prev;
      }
    }
    myList.size--;
    myList = null;
    next = null;
  }

}
