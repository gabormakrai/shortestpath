package sp.dijpqbh;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class BinaryHeapPriorityQueueDijkstra implements ShortestPathAlgorithm {

	Graph graph;
	boolean[] destinationsVisited;
	boolean[] visited;
	BinaryHeap heap;
	
	@Override
	public void init(Graph graph) {
		this.graph = graph;
		destinationsVisited = new boolean[graph.nodes];
		visited = new boolean[graph.nodes];
		for (int i = 0; i < visited.length; ++i) {
			destinationsVisited[i] = false;
			visited[i] = false;
		}
		heap = new BinaryHeap(graph.nodes);		
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
		
		for (int i = 0; i < distances.length; ++i) {
			distances[i] = Double.POSITIVE_INFINITY;
		}
		
		distances[source] = 0.0;
		
		heap.init(source);
		
		while (destinationsVisitedCount > 0) {
			
			if (heap.size == 0) {
				break;
			}
			
			int u = heap.extractMin();
			
			visited[u] = true;
			if (destinationsVisited[u]) {
				--destinationsVisitedCount;
			}

			if (graph.neighbours[u] == null) {
				continue;
			}
			
			for (int i = 0; i < graph.neighbours[u].length; ++i) {
				double alt = distances[u] + graph.weights[u][i];
				if (distances[graph.neighbours[u][i]] > alt) {
					distances[graph.neighbours[u][i]] = alt;
					heap.decreaseKey(graph.neighbours[u][i], alt);
				}
			}
		}
	}


}
