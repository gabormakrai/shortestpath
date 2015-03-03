package sp.spt;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class ShortestPathTreeLIFO implements ShortestPathAlgorithm {

	Graph graph;
	LIFOQueue queue = new LIFOQueue();
	
	@Override
	public void init(Graph graph) {
		this.graph = graph;
	}

	@Override
	public void calculate(int source, int[] destinations, double[] distances) {
		
		for (int i = 0; i < distances.length; ++i) {
			distances[i] = Double.POSITIVE_INFINITY;
		}
		
		distances[source] = 0.0;
		queue.queue(source);
		
		while (queue.size > 0) {
			
			int u = queue.dequeue();
			
			if (graph.neighbours[u] == null) {
				continue;
			}
			
			for (int i = 0; i < graph.neighbours[u].length; ++i) {
				double alt = distances[u] + graph.weights[u][i];
				if (alt < distances[graph.neighbours[u][i]]) {
					distances[graph.neighbours[u][i]] = alt;
					queue.queue(graph.neighbours[u][i]);
				}
			}
		}
	}

}
