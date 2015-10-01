public class BinaryTreeNode {
	private BinaryTreeEntry entry;
	private BinaryTreeNode parent;
	private BinaryTreeNode leftChild,rightChild;
	
	BinaryTreeNode(BinaryTreeEntry entry, BinaryTreeNode parent, 
			BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
		this.entry = entry;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public String toString() {
		String result = "";
		if (this.leftChild != null) {
			result = "(" + leftChild.toString() + ")";
		}
		result = result + entry.getKey().toString() + " " + entry.getValue();
		if (this.rightChild != null) {
			result = "(" + rightChild.toString() + ")";
		}
		return result;
	}
	
	public void setEntry(BinaryTreeEntry entry) {this.entry = entry;}
	public void setParent(BinaryTreeNode parent) {this.parent = parent;}
	public void setLeftChild(BinaryTreeNode leftChild) {this.leftChild = leftChild;}
	public void setRightChild(BinaryTreeNode rightChild) {this.rightChild = rightChild;}

	public BinaryTreeEntry getEntry() {return entry;}
	public BinaryTreeNode getParent() {return parent;}
	public BinaryTreeNode getLeftChild() {return leftChild;}
	public BinaryTreeNode getRightChild() {return rightChild;}
}


