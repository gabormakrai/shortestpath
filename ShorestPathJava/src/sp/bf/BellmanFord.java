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
		
		// TODO Auto-generated method stub
//		function BellmanFord(list vertices, list edges, vertex source)
//		   ::distance[],predecessor[]
//
//		   // This implementation takes in a graph, represented as
//		   // lists of vertices and edges, and fills two arrays
//		   // (distance and predecessor) with shortest-path
//		   // (less cost/distance/metric) information
//
//		   // Step 1: initialize graph
//		   for each vertex v in vertices:
//		       if v is source then distance[v] := 0
//		       else distance[v] := inf
//		       predecessor[v] := null
//
//		   // Step 2: relax edges repeatedly
//		   for i from 1 to size(vertices)-1:
//		       for each edge (u, v) with weight w in edges:
//		           if distance[u] + w < distance[v]:
//		               distance[v] := distance[u] + w
//		               predecessor[v] := u
//
//		   // Step 3: check for negative-weight cycles
//		   for each edge (u, v) with weight w in edges:
//		       if distance[u] + w < distance[v]:
//		           error "Graph contains a negative-weight cycle"
//		   return distance[], predecessor[]		
	}

}
