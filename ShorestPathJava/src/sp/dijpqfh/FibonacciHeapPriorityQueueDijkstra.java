package sp.dijpqfh;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class FibonacciHeapPriorityQueueDijkstra implements ShortestPathAlgorithm {
	Graph graph;
	boolean[] destinationsVisited;
	boolean[] visited;
	FibonacciHeap heap;
	FibonacciHeapNode[] nodes;
	boolean[] inTheHeap;
	
	@Override
	public void init(Graph graph) {
		this.graph = graph;
		destinationsVisited = new boolean[graph.nodes];
		visited = new boolean[graph.nodes];
		for (int i = 0; i < visited.length; ++i) {
			destinationsVisited[i] = false;
			visited[i] = false;
		}
		heap = new FibonacciHeap();
		nodes = new FibonacciHeapNode[graph.nodes];
		for (int i = 0; i < nodes.length; ++i) {
			nodes[i] = new FibonacciHeapNode(Double.POSITIVE_INFINITY, i);
		}
		inTheHeap = new boolean[graph.nodes];
		for (int i = 0; i < inTheHeap.length; ++i) {
			inTheHeap[i] = false;
		}
	}

	@Override
	public void calculate(int source, int[] destinations, double[] distances) {
		
		for (int i = 0; i < visited.length; ++i) {
			visited[i] = false;
			destinationsVisited[i] = false;
		}
		
		int destinationsVisitedCount = destinations.length;
		
		for (int i = 0; i < destinations.length; ++i) {
			destinationsVisited[destinations[i]] = true;
		}
		
		heap.clear();
		
		for (int i = 0; i < distances.length; ++i) {
			distances[i] = Double.POSITIVE_INFINITY;
			nodes[i].reset();
		}
		
		for (int i = 0; i < inTheHeap.length; ++i) {
			inTheHeap[i] = false;
		}		
		
		distances[source] = 0.0;
		nodes[source].key = 0.0;
		
		heap.insert(nodes[source]);
		inTheHeap[source] = true;
				
		while (destinationsVisitedCount > 0) {
			
			if (heap.size() == 0) {
				break;
			}

			FibonacciHeapNode minNode = heap.extractMin();
			int u = minNode.value;
			inTheHeap[u] = false;
			
			visited[u] = true;
			if (destinationsVisited[u]) {
				--destinationsVisitedCount;
			}

			if (graph.neighbours[u] == null) {
				continue;
			}
			
			for (int i = 0; i < graph.neighbours[u].length; ++i) {
				double alt = distances[u] + graph.weights[u][i];
				int neighbour = graph.neighbours[u][i]; 
				if (distances[neighbour] > alt) {
					distances[neighbour] = alt;
					if (!inTheHeap[neighbour]) {
						nodes[neighbour].key = alt;
						heap.insert(nodes[neighbour]);
						inTheHeap[neighbour] = true;
					} else {
						heap.decreaseKey(nodes[neighbour], alt);
					}
				}
			}
		}
	}

}
