//in this code, i don't know the grammer to use Set, so i used <> as in the book
public class KevenGraphNode {
  private String name;
  private Set<KevenGraphNode> linksToOthers;
  private BaconNumber = -1; 

  public KevenGraphNode(String name) {
     this.name = name;
     linksToOthers = new HashSet<KevenGraphNode>();
  }

  public sameMovieActor(KevenGraphNode node) {
     this.linksToOthers.add(node);
     node.linksToOthers.add(this);
  }

  public int getBaconNumber() {return BaconNumber;}

  //only the bacon node can use this number
  public void calculateBaconNumber() {
    this.BaconNumber = 0;
    Queue<KevenGraphNode> myQueue = new LinkedList<KevenGraphNode>();
    myQueue.add(this);
    currentNode = myQueue.poll();
    while (currentNode ! = null) {
       for (KevenGraphNode node : currentNode.linksToOthers)  {   //I don't know the grammar here either
           if (node.BaconNumber == -1) {
              myQueue.add(node);
              node.BaconNumber = 1 + currentNode.BaconNumber; 
           }
       }
       currentNode = myQueue.poll();
    } 
  } 
}
