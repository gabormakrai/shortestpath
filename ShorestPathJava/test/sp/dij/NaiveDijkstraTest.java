package sp.dij;

import org.junit.Test;

import sp.ShortestPathAlgorithmTest;
import sp.dij.NaiveDijkstra;

public class NaiveDijkstraTest extends ShortestPathAlgorithmTest {
	
	@Test
	public void test() {
		testAlgorithm(new NaiveDijkstra());
	}
}
