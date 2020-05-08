package list;

public abstract class List {

  protected int size;

  public boolean isEmpty() {
    return size == 0;
  }

  public int length() {
    return size;
  }
  
  public abstract void insertFront(Object item);
  public abstract void insertBack(Object item);
  public abstract ListNode front();
  public abstract ListNode back();
  public abstract String toString();
}
