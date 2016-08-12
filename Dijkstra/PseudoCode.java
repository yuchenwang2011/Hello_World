//Here is the pseudo code to implement Dijkstra shortest path algorithm
//http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
foreach node, set distance[node] to high;
create a new empty settledNodes;
create a new empty unSettledNodes;

add sourceNode into unSettledNodes;
set distance[sourceNode] = 0;

while(unSettledNodes.size() != empty){
	Node evaluationNode = getNodeWithLowestDistance(unSettledNodes);
	remove evaluationNode from unSettledNodes;
	add evaluationNode into settledNodes;
	updateNeighboughDistances(evaluationNode);
}

getNodeWithLowestDistance(){
	get the node with the lowest distance in the unSettledNodes and return it;
}

updateNeighboughDistances(){
	foreach destinationNode can be reached via edge from evaluationNode AND destinationNode NOT in settledNodes{
		edgeDistance = getDistance(edge(evaluationNode, destinationNode));
		newDistance = distance[evaluationNode] + edgeDistance;
		if(newDistance < distance[destinationNode]) {
			distance[destinationNode] = newDistance;
			add destinationNode unSettledNodes;
		}
	}
}