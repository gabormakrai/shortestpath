package sp.dijpqbh;

import org.junit.Test;

import sp.ShortestPathAlgorithmTest;

public class BinaryHeapPriorityQueueDijkstraTest extends ShortestPathAlgorithmTest {
	
	@Test
	public void test() {
		testAlgorithm(new BinaryHeapPriorityQueueDijkstra());
	}
}
