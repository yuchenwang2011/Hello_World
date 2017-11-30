public void preorderTraverse(BinaryTreeNode node) {
  if (node == null) {return;}
  System.out.println(node.printNode());
  preorderTraverse(node.getLeftChild());
  preorderTraverse(node.getRightChild());
}

public void preorderTraverseTest() {
  preorderTraverse(root);
}

public String printNode(BinaryTreeNode node) {
  if (node.getEntry == null) {
     return null;
  } 
  return node.getEntry.getKey.toString() + node.getEntry.getValue.toString();
}
