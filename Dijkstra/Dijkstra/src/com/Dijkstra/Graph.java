package com.Dijkstra;

import java.util.List;
import java.util.Map;

public class Graph {
	private Map<String, Vertex> vertexes;
	private List<Edge> edges;
	
	public Graph(Map<String, Vertex> vertexes, List<Edge> edges){
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public Map<String, Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(Map<String, Vertex> vertexes) {
		this.vertexes = vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
}
