package sp;

/**
 * 
 * Graph class contains a graph in adjecency list format
 * 
 * @author Gabor Makrai
 *
 */
public class Graph {

	public final double[][] weights;
	
	public final int[][] neighbours;
	
	public final int nodes;
	
	public final int arcs;
	
	public Graph(int nodes, int arcs, int[][] neighbours, double[][] weights) {
		this.nodes = nodes;
		this.arcs = arcs;
		this.neighbours = neighbours;
		this.weights = weights;
	}
}
