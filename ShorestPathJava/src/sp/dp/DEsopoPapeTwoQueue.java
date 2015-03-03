package sp.dp;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class DEsopoPapeTwoQueue implements ShortestPathAlgorithm {
	
	Graph graph;
	TwoQueue twoQueue = new TwoQueue();
	boolean[] nodeInQ;
	
	@Override
	public void init(Graph graph) {
		this.graph = graph;
		nodeInQ = new boolean[graph.nodes];
	}

	@Override
	public void calculate(int source, int[] destinations, double[] distances) {
		for (int i = 0; i < distances.length; ++i) {
			distances[i] = Double.POSITIVE_INFINITY;
		}
		
		distances[source] = 0.0;
		twoQueue.queueQ2(source);
		
		while (twoQueue.size > 0) {
			
			int u = twoQueue.dequeue();
			nodeInQ[u] = true;
			
			if (graph.neighbours[u] == null) {
				continue;
			}
			
			for (int i = 0; i < graph.neighbours[u].length; ++i) {
				double alt = distances[u] + graph.weights[u][i];
				if (alt < distances[graph.neighbours[u][i]]) {
					distances[graph.neighbours[u][i]] = alt;
					if (nodeInQ[graph.neighbours[u][i]]) {
						twoQueue.queueQ1(graph.neighbours[u][i]);
					} else {
						twoQueue.queueQ2(graph.neighbours[u][i]);
					}
				}
			}
		}
		
	}
}
