package dict;

class BinaryTreeNode {

  Entry entry;
  BinaryTreeNode parent;
  BinaryTreeNode leftChild, rightChild;

  BinaryTreeNode(Entry entry, BinaryTreeNode parent,
    BinaryTreeNode left, BinaryTreeNode right) {
    this.entry = entry;
    this.parent = parent;
    leftChild = left;
    rightChild = right;
}
  
  BinaryTreeNode(Entry entry) {
    this(entry, null, null, null);
  }

  BinaryTreeNode(Entry entry, BinaryTreeNode parent) {
    this(entry, parent, null, null);
  }
  
  public String toString() {
    String s = "";
    if (leftChild != null) {
      s = "(" + leftChild.toString() + ")";
    }
    s = s + entry.key().toString() + entry.value();
    if (rightChild != null) {
      s = s + "(" + rightChild.toString() + ")";
    }
    return s;
  }
}
