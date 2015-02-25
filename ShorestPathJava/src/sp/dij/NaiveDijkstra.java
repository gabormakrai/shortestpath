package sp.dij;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class NaiveDijkstra implements ShortestPathAlgorithm {

	Graph graph;
	boolean[] destinationsVisited;
	boolean[] visited;
	
	@Override
	public void init(Graph graph) {
		this.graph = graph;
		destinationsVisited = new boolean[graph.nodes];
		visited = new boolean[graph.nodes];
		for (int i = 0; i < visited.length; ++i) {
			destinationsVisited[i] = false;
			visited[i] = false;
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
		
		for (int i = 0; i < distances.length; ++i) {
			distances[i] = Double.POSITIVE_INFINITY;
		}
		
		distances[source] = 0.0;

		while (destinationsVisitedCount > 0) {
			
			int u = -1;
			double uDistance = Double.POSITIVE_INFINITY;
			for (int i = 0; i < graph.nodes; ++i) {
				if (!visited[i] && uDistance > distances[i]) {
					u = i;
					uDistance = distances[i];
				}
			}
			
			if (u == -1) {
				break;
			}
			
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
				}
			}
		}
	}

}
