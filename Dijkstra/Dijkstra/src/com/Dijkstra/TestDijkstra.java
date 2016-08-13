package com.Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDijkstra {
	
	public static void main(String[] args){
		String testStart = args[0];
		String testEnd = args[1];
		
		HashMap<String, Vertex> vertexes = new HashMap<String, Vertex>();
		List<Edge> edges = new ArrayList<Edge>();
		
		String filePath = "C:\\Stations.csv";
		String line = "";
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(filePath));
			while((line = reader.readLine()) != null){
				String[] station = line.split(",");
				String start = station[0];
				String end = station[1];
				int distance = Integer.valueOf(station[2]);
				//System.out.println(Arrays.asList(line));
				Vertex startVertex = new Vertex(start);
				Vertex endVertex = new Vertex(end);
				Edge edge = new Edge(startVertex, endVertex, distance);
			    vertexes.put(start, startVertex);
			    vertexes.put(end, endVertex);
			    edges.add(edge);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	    Graph graph = new Graph(vertexes, edges);
	    getResult(graph, args, vertexes, edges, testStart, testEnd);
	}
	
	public static void getResult(Graph graph, String[] args, Map<String, Vertex> vertexes, List<Edge> edges, String start, String end){
	    DijkstraSolution dj = new DijkstraSolution(graph);
	    if (vertexes.containsKey(start) && vertexes.containsKey(end)) {
	    	Vertex source = vertexes.get(start);
	    	Vertex destination = vertexes.get(end);
	    	Map<String, Integer> distances = dj.execute(source);
	    		int distance = distances.get(destination.getName());
	    		System.out.println("Distance between " + start 
	    			+ " and " + end + " is: " + distance);
	    	
	    } else { 	
	    	System.out.println("Station names doen't exist.");
	    }
	}
}
