package com.srikanth.problems.graph;

public class GraphDriver {

	public static void main(String[] args) {
		
		Graph graph =  Graph.createGraph();
		
		System.out.println("The adjacent vertices for Vertex Bob :");
		graph.printAdjacentVertices(graph.getAdjVertices("Bob"));
		System.out.println();
		
		System.out.println("The Breadth first traversal with  Bob as root :");
		graph.printTraversalPath(graph.breadthFirstTraversal(graph, "Bob"));
		
		System.out.println();
		
		System.out.println("The depth first traversal with  Bob as root :");
		graph.printTraversalPath(graph.depthFirstTraversal(graph, "Bob"));
		

	}

}
