package com.Dijkstra;

public class Edge {
	private Vertex source;
	private Vertex destination;
	private int weight;
	
	public Edge(Vertex source, Vertex destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString(){
		return source.getName() + " -> " + destination.getName();
	}
}
