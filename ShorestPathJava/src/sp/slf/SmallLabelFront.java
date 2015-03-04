package sp.slf;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class SmallLabelFront implements ShortestPathAlgorithm {
	
	Graph graph;
	TwoQueue queue = new TwoQueue();
	
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
		queue.queueQ1(source);
		
		while (queue.size > 0) {
			
			int u = queue.dequeue();
			
			if (graph.neighbours[u] == null) {
				continue;
			}
			
			for (int i = 0; i < graph.neighbours[u].length; ++i) {
				int neighbour = graph.neighbours[u][i];
				double alt = distances[u] + graph.weights[u][i];
				if (alt < distances[neighbour]) {
					distances[neighbour] = alt;
					int first = queue.first();
					if (distances[first] < alt) {
						queue.queueQ2(neighbour);	
					} else {
						queue.queueQ1(neighbour);	
					}
				}
			}
		}
	}

}
