package dict;

class Tree234Node {

  int keys;
  int key1;
  int key2;
  int key3;
  Tree234Node parent;
  Tree234Node child1;
  Tree234Node child2;
  Tree234Node child3;
  Tree234Node child4;

  Tree234Node(Tree234Node p, int key) {
    keys = 1;
    key1 = key;
    parent = p;
    child1 = null;
    child2 = null;
    child3 = null;
    child4 = null;
  }

  public String toString() {
    String s = "";
    if (child1 != null) {
      s = "(" + child1.toString() + ")";
    }
    s = s + key1;

    if (child2 != null) {
      s = s + "(" + child2.toString() + ")";
    } else if (keys > 1) {
      s = s + " ";
    }
    if (keys > 1) {
      s = s + key2;
      if (child3 != null) {
        s = s + "(" + child3.toString() + ")";
      } else if (keys > 2) {
        s = s + " ";
      }
    }
    if (keys > 2) {
      s = s + key3;
      if (child4 != null) {
        s = s + "(" + child4.toString() + ")";
      }
    }
    return s;
  }

  public void printSubtree(int spaces) {
    if (child4 != null) {
      child4.printSubtree(spaces + 5);
    }
    if (keys == 3) {
      for (int i = 0; i < spaces; i++) {
        System.out.print(" ");
      }
      System.out.println(key3);
    }

    if (child3 != null) {
      child3.printSubtree(spaces + 5);
    }
    if (keys > 1) {
      for (int i = 0; i < spaces; i++) {
        System.out.print(" ");
      }
      System.out.println(key2);
    }

    if (child2 != null) {
      child2.printSubtree(spaces + 5);
    }
    for (int i = 0; i < spaces; i++) {
      System.out.print(" ");
    }
    System.out.println(key1);

    if (child1 != null) {
      child1.printSubtree(spaces + 5);
    }
  }
}
