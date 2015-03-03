package sp.dp;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class DEsopoPapeDeque implements ShortestPathAlgorithm {
	
	Graph graph;
	Dequeue deQueue = new Dequeue();
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
		deQueue.queueQ2(source);
		
		while (deQueue.size > 0) {
			
			int u = deQueue.dequeue();
			nodeInQ[u] = true;
			
			if (graph.neighbours[u] == null) {
				continue;
			}
			
			for (int i = 0; i < graph.neighbours[u].length; ++i) {
				double alt = distances[u] + graph.weights[u][i];
				if (alt < distances[graph.neighbours[u][i]]) {
					distances[graph.neighbours[u][i]] = alt;
					if (nodeInQ[graph.neighbours[u][i]]) {
						deQueue.queueQ1(graph.neighbours[u][i]);
					} else {
						deQueue.queueQ2(graph.neighbours[u][i]);
					}
				}
			}
		}
		
	}
}
