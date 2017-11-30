public Node rotateRight(Node root) {
  if(root.getLeft() ! = null) {
    root = root.getLeft();
    root.getParent().setParent(root);
    if(root.getRight() != null) { 
      root.getParent().setLeft(root.getRight());
      root.getRight.setParent(root.getParent());
    }
    root.setRight(root.getParent());
    root.setParent(null);
  }
  return root;
}
