package newHW4;

public class DListNode {
	  public Object item;
	  protected DListNode prev;
	  protected DListNode next;

	  /**
	   *  DListNode() constructor.
	   *  @param i the item to store in the node.
	   *  @param p the node previous to this node.
	   *  @param n the node following this node.
	   */
	  DListNode(Object i, DListNode p, DListNode n) {
	    item = i;
	    prev = p;
	    next = n;
	  }
}
