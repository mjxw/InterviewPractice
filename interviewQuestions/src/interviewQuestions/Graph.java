package interviewQuestions;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {	
	private int V; //# of vertices
	private LinkedList<Integer> adj[];
	
	public Graph(int v) {
		V = v; 
		adj = new LinkedList[v]; // array of linkedlist aka adjacency list 
		
		for(int i = 0; i < v; i++) { // creating a linkedlist at each array index
			adj[i] = new LinkedList();
		}
	}
	
	private void addEdgeDirected(int v, int w) {
		adj[v].add(w);
	}
	
	private void addEdgeUndirected(Graph g, int src, int dest) {
		adj[src].addFirst(dest);
		adj[dest].addFirst(src);
	}
	
	private void printGraph(Graph g) {
		for (int v = 0; v < g.V; v++) {
			System.out.println("Adjacency list of vertex: " + v);
			System.out.print("Head");
			for (Integer pcrawl: g.adj[v]) {
				System.out.print(" -> " + pcrawl);
			}
			System.out.println();
		}
	}
	
	private void BFS(int s) {
		boolean visited[] = new boolean[V]; // boolean array of visited nodes
		LinkedList<Integer> q = new LinkedList<Integer>(); // queue for BFS
		
		// Mark current Node and enqueue it 
		visited[s] = true;
		q.add(s);
		
		while (q.size() != 0) {
			s = q.poll();
			System.out.print(s + " ");
			
			Iterator<Integer> iter = adj[s].listIterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
	}
	
	private void DFS(int v) {
		boolean visited[] = new boolean[V];
		
		DFSUtil(v, visited);
	}
	
	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> iter = adj[v].listIterator();
		while (iter.hasNext()) {
			int n = iter.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			} 
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdgeDirected(0, 1);
        g.addEdgeDirected(0, 2);
        g.addEdgeDirected(1, 2);
        g.addEdgeDirected(2, 0);
        g.addEdgeDirected(2, 3);
        g.addEdgeDirected(3, 3);
        
//        g.printGraph(g);
        
//        g.BFS(2);
        
        g.DFS(2);
		
		
		// undirected graph
//        Graph graph = new Graph(5);
//        graph.addEdgeUndirected(graph, 0, 1);
//        graph.addEdgeUndirected(graph, 0, 4);
//        graph.addEdgeUndirected(graph, 1, 2);
//        graph.addEdgeUndirected(graph, 1, 3);
//        graph.addEdgeUndirected(graph, 1, 4);
//        graph.addEdgeUndirected(graph, 2, 3);
//        graph.addEdgeUndirected(graph, 3, 4);
        
//        graph.printGraph(graph);
	}
}
