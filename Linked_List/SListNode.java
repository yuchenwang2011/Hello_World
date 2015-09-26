public class SListNode {
	private Object value;
	private SListNode next;
	
	SListNode (Object value, SListNode next) {
	   this.value = value;
	   this.next = next;
	}
	
	SListNode(Object obj){
	   this.value = obj;
	   this.next = null;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public void setNext(SListNode next) {
		this.next = next;
	}
 	
	public Object getValue() {
		return this.value;
	}
	
	public SListNode getNext() {
		return this.next;
	}
}

