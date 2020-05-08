package list;

public abstract class ListNode {

  protected Object item;
  protected List myList;

  public boolean isValidNode() {
    return myList != null;
  }

  public Object item() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException();
    }
    return item;
  }

  public void setItem(Object item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException();
    }
    this.item = item;
  }
  public abstract ListNode next() throws InvalidNodeException;
  public abstract ListNode prev() throws InvalidNodeException;
  public abstract void insertAfter(Object item) throws InvalidNodeException;
  public abstract void insertBefore(Object item) throws InvalidNodeException;
  public abstract void remove() throws InvalidNodeException;
}
