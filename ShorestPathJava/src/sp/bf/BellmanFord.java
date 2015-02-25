package sp.bf;

import sp.Graph;
import sp.ShortestPathAlgorithm;

public class BellmanFord implements ShortestPathAlgorithm{

	Graph graph;
	
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
		
		for (int i = 0; i < graph.nodes; ++i) {
			boolean changes = false;
			for (int j = 0; j < graph.nodes; ++j) {
				if (graph.neighbours[j] == null) {
					continue;
				}
				for (int k = 0; k < graph.neighbours[j].length; ++k) {
					double alt = distances[j] + graph.weights[j][k];
					if (alt < distances[graph.neighbours[j][k]]) {
						distances[graph.neighbours[j][k]] = alt;
						changes = true;
					}
				}
			}
			if (!changes) {
				break;
			}
		}
	}

}
