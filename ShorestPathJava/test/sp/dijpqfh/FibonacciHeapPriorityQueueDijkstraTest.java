package sp.dijpqfh;

import org.junit.Test;

import sp.ShortestPathAlgorithmTest;

public class FibonacciHeapPriorityQueueDijkstraTest extends ShortestPathAlgorithmTest {
	
	@Test
	public void test() {
		testAlgorithm(new FibonacciHeapPriorityQueueDijkstra());
	}
}
