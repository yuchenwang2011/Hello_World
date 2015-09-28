public class BinaryTreeNode {
	private BinaryTreeEntry entry;
	private BinaryTreeNode parent;
	private BinaryTreeNode leftChild,rightChild;
	
	BinaryTreeNode(BinaryTreeNode entry, BinaryTreeNode parent, 
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
}


