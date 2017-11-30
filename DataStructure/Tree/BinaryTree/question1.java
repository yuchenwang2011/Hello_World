public int getHeight(BinaryTreeNode node) {
  if (node == null) {
     return 0;
  } else {
     int height1 = getHeight(node.leftChild());
     int height2 = getHeight(node.rightChild());
     return 1 + Math.max(height1, height2);
  }
}
