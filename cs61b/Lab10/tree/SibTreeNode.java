package tree;

class SibTreeNode extends TreeNode {

  protected SibTree myTree;
  protected SibTreeNode parent;
  protected SibTreeNode firstChild;
  protected SibTreeNode nextSibling;

  SibTreeNode(SibTree tree, Object item) {
    this.item = item;
    valid = true;
    myTree = tree;
    parent = null;
    firstChild = null;
    nextSibling = null;
  }

  SibTreeNode() {
    valid = false;
  }

  public int children() {
    if (isValidNode()) {
      int count = 0;
      SibTreeNode countNode = firstChild;
      while (countNode != null) {
        count++;
        countNode = countNode.nextSibling;
      }
      return count;
    } else {
      return 0;
    }
  }

  public TreeNode nextSibling() throws InvalidNodeException {
	    if (isValidNode()) {
	      if (nextSibling == null) {
	        return new SibTreeNode();
	      } else {
	        return nextSibling;
	      }
	    } else {
	      throw new InvalidNodeException();
	    }
	  }

  public TreeNode parent() throws InvalidNodeException {
    if (isValidNode()) {
    	if(this.parent==null) {
    		return new SibTreeNode();
    	} else {
    	  return this.parent;	
    	}
    } else {
    	throw new InvalidNodeException();
    }
  }

  public TreeNode child(int c) throws InvalidNodeException {
    if (isValidNode()) {
      if (c < 1) {
        return new SibTreeNode();
      }
      SibTreeNode kid = firstChild;
      while ((kid != null) && (c > 1)) {
        kid = kid.nextSibling;
        c--;
      }
      if (kid == null) {
        return new SibTreeNode();
      } else {
        return kid;
      }
    } else {
      throw new InvalidNodeException();
    }
  }

  public void insertChild(Object item, int c) throws InvalidNodeException {
     if (isValidNode()) {
    	 SibTreeNode newNode = new SibTreeNode (this.myTree,item);
    	 parent = this;
         
    	 if (c<=1) {
    		 newNode.nextSibling = this.firstChild;
    		 this.firstChild = newNode;
    	 } else {
    		 SibTreeNode currentNode = this.firstChild;
    		 if (currentNode == null) {
    			 this.firstChild = newNode;
    		 } else {
    			 while (currentNode.nextSibling != null && c>2) {
    				 currentNode = currentNode.nextSibling;
    				 c--;
    			 }
                //no matter c==2 or c!=2, the following 2 line are the same
    			newNode.nextSibling=currentNode.nextSibling;
    		    currentNode.nextSibling = newNode;
    		 }
    	 }
    	 this.myTree.size++;
     } else {
    	 throw new InvalidNodeException();
     }
  }

  /**
   *  removeLeaf() removes the node at the current position from the tree if
   *  it is a leaf.  Does nothing if `this' has one or more children.  Throws
   *  an exception if `this' is not a valid node.  If 'this' has siblings to
   *  its right, those siblings are all shifted left by one.
   */
  public void removeLeaf() throws InvalidNodeException {
    // FILL IN YOUR SOLUTION TO PART III HERE.
  }

}
