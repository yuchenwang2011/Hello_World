public BinaryTreeNode getCommonAncestor(BinaryTreeNode root, int A, int B) {
  while(root != null) {
    int value = root.getKey();
    if (value < A.getValue() && value < B.getValue()) {
       root = root.getRightChild();
    } elseif (value > A.getValue() && value > B.getValue()) {
       root = root.getLeftChild();
    } else {
       return root;
    }
  }
  return null;
}
