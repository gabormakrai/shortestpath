package sp;

/**
 * 
 * ShortestPathAlgorithm interfaces
 * 
 * @author Gabor Makrai
 *
 */
public interface ShortestPathAlgorithm {
	/**
	 * 
	 * Initialise the algorithm with the given graph
	 * 
	 * @param graph
	 */
	public void init(Graph graph);
	
	/**
	 * 
	 * Calculate the shortest path's distances from the source to all the distances
	 * 
	 * @param source source node's id
	 * @param destinations destination nodes' id
	 * @param distances the array contains all the distances
	 */
	public void calculate(int source, int[] destinations, double[] distances);
}
