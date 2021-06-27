package com.srikanth.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
	
	private Map <Vertex, List<Vertex>> adjVertices;
	
	

	public Graph(Map<Vertex, List<Vertex>> adjVertices) {
		
		this.adjVertices = new HashMap<Vertex, List<Vertex>>();
	}
	

	public Graph() {
		this.adjVertices = new HashMap<Vertex, List<Vertex>>();
	}


	public Map <Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(Map <Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}
	
	public void addVertex(String label) {
		adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}
	
	public void removeVertex(String label) {
		Vertex vertex = new Vertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(vertex));
		adjVertices.remove(vertex);
		
	}
	
	public void addEdge(String label1, String label2) {
		Vertex vertex1 = new Vertex(label1);
		Vertex vertex2 = new Vertex(label2);
		
		adjVertices.get(vertex1).add(vertex2);
		adjVertices.get(vertex2).add(vertex1);
		
	}
	
	public void removeEdge(String label1, String label2 ) {
		Vertex vertex1 = new Vertex(label1);
		Vertex vertex2 = new Vertex(label2);
		
		List<Vertex> eV1 = adjVertices.get(vertex1);
		List<Vertex> eV2 = adjVertices.get(vertex2);
		
		if (eV1 != null) {
			eV1.remove(vertex2);
		}

		if (eV2 != null) {
			eV2.remove(vertex1);
		}
	}
	
	public static Graph createGraph() {
	    Graph graph = new Graph();
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    return graph;
	}
	
	public List<Vertex> getAdjVertices(String label) {
	    return adjVertices.get(new Vertex(label));
	}
	
	public Set<String> depthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Vertex v : graph.getAdjVertices(vertex)) {              
	                stack.push(v.getLabel());
	            }
	        }
	    }
	    return visited;
	}
	
	public Set<String> breadthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(root);
	    visited.add(root);
	    while (!queue.isEmpty()) {
	        String vertex = queue.poll();
	        for (Vertex v : graph.getAdjVertices(vertex)) {
	            if (!visited.contains(v.getLabel())) {
	                visited.add(v.getLabel());
	                queue.add(v.getLabel());
	            }
	        }
	    }
	    return visited;
	}
	
	public void printTraversalPath( Set<String> traversalPath) {
		traversalPath.stream().forEach(e -> System.out.print(e + " "));
	}
	
	public void printAdjacentVertices(List<Vertex> adjacentVertices) {
		
		adjacentVertices.stream().forEach(e -> System.out.print(e.getLabel()+ " "));
	}

}
