  public void preorderTraverse2(BinaryTreeNode node) {
	  NodeStack stack = new NodeStack();
	  stack.push(node);
	  while(stack.size > 0) {
		  node = stack.pop();
		  node.printNode();
		  if(node.rightChild !=null) {stack.push(node.rightChild);}
		  if(node.leftChild != null) {stack.push(node.leftChild);}
	  }
  }
