package com.Dijkstra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraSolution {
	
	Map<String, Vertex> nodes;
	List<Edge> edges;
	Set<Vertex> settledNodes;
	Set<Vertex> unSettledNodes;
	Map<String, Integer> distance;  //distance to source node
	
	public DijkstraSolution(Graph graph){
		this.nodes = graph.getVertexes();
		this.edges = graph.getEdges();
	}
	
	public Map<String, Integer> execute(Vertex source){
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<String, Integer>();
		distance.put(source.getName(), 0);
		unSettledNodes.add(source);
		
		while(unSettledNodes.size() > 0){
			Vertex node = getNodeWithLowestDistance(unSettledNodes);
			unSettledNodes.remove(node);
			settledNodes.add(node);
			updateNeighbough(node);
		}
		return distance;
	}
	
	public Vertex getNodeWithLowestDistance(Set<Vertex> vertexes){
		Vertex minimum = null;
		for(Vertex vertex : vertexes){
			if(minimum == null) minimum = vertex;
			else {
				if(getLowestDistance(minimum) > getLowestDistance(vertex)){
					minimum = vertex;
				}
			}
		}
		return minimum;
	}
	
	public int getLowestDistance(Vertex vertex){
		Integer d = distance.get(vertex.getName());
		if (d != null){
			return d;
		}
		return Integer.MAX_VALUE;
	}
	
	
	public void updateNeighbough(Vertex vertex){
		List<Vertex> adjacentNodes = getNeighboughs(vertex);
		for(Vertex dest : adjacentNodes){
			int edgeDistance = getEdgeDistance(vertex, dest);
			int newDistance = getLowestDistance(vertex) + edgeDistance;
			if(newDistance < getLowestDistance(dest)) {
				distance.put(dest.getName(), newDistance);
				unSettledNodes.add(dest);
			}
		}
	}
	
	public List<Vertex> getNeighboughs(Vertex vertex){
		List<Vertex> neighboughs = new ArrayList<Vertex>();
		for(Edge edge :edges){
			if(!settledNodes.contains(edge.getDestination()) 
					&& edge.getSource().equals(vertex)){
				neighboughs.add(edge.getDestination());
			}
		}
		return neighboughs;
	}
	
	public int getEdgeDistance(Vertex node, Vertex target){
		for(Edge edge: edges){
			if( (edge.getSource().equals(node) && edge.getDestination().equals(target)) ||
					(edge.getSource().equals(target) && edge.getDestination().equals(node) )) {
				return edge.getWeight();
			}
		}
		return Integer.MAX_VALUE;
	}
}