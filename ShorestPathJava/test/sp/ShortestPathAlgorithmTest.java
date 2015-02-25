package sp;

import sp.Graph;

import static org.junit.Assert.*;

public class ShortestPathAlgorithmTest {
	
	public Graph generateGraph() {
		
		int[][] neighbours = new int[][] {
			new int[] { 1, 2 }, 
			new int[] { 0, 2, 3, 4 }, 
			new int[] { 3, 4 },
			new int[] { 5 },
			new int[] { 3, 5 },
			new int[] { 3 },
		};
		
		double[][] weights = new double[][] {
			new double[] { 1.0, 2.0 }, 
			new double[] { 2.0, 2.0, 1.0, 4.0 }, 
			new double[] { 1.0, 3.0 },
			new double[] { 2.0 },
			new double[] { 1.0, 6.0 },
			new double[] { 2.0 },
		};
		
		return new Graph(6, 12, neighbours, weights);
	}
	
	public void testAlgorithm(ShortestPathAlgorithm spAlgo) {
		Graph graph = generateGraph();
		spAlgo.init(graph);
		
		double[] distances = new double[6];
		int[] destinations = new int[] { 1, 2, 3, 4 };
		
		double[] distances0 = new double[] { 0.0, 1.0, 2.0, 2.0, 5.0, 4.0 };
		double[] distances1 = new double[] { 2.0, 0.0, 2.0, 1.0, 4.0, 3.0 };
		double[] distances2 = new double[] { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.0, 1.0, 3.0, 3.0 };
		double[] distances3 = new double[] { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.0, Double.POSITIVE_INFINITY, 2.0 };
		double[] distances4 = new double[] { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0, 0.0, 3.0 };
		double[] distances5 = new double[] { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 2.0, Double.POSITIVE_INFINITY, 0.0 };
		
		spAlgo.calculate(0, destinations, distances);
		for (int i = 0; i < 6; ++i) {
			assertEquals(distances0[i], distances[i], 0.00001);
		}
		
		spAlgo.calculate(1, destinations, distances);
		for (int i = 0; i < 6; ++i) {
			assertEquals(distances1[i], distances[i], 0.00001);
		}
		
		spAlgo.calculate(2, destinations, distances);
		for (int i = 0; i < 6; ++i) {
			assertEquals(distances2[i], distances[i], 0.00001);
		}
		
		spAlgo.calculate(3, destinations, distances);
		for (int i = 0; i < 6; ++i) {
			assertEquals(distances3[i], distances[i], 0.00001);
		}
		
		spAlgo.calculate(4, destinations, distances);
		for (int i = 0; i < 6; ++i) {
			assertEquals(distances4[i], distances[i], 0.00001);
		}
		
		spAlgo.calculate(5, destinations, distances);
		for (int i = 0; i < 6; ++i) {
			assertEquals(distances5[i], distances[i], 0.00001);
		}
		
	}
}
