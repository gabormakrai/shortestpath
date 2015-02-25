package sp.bf;

import org.junit.Test;

import sp.ShortestPathAlgorithmTest;

public class BellmanFordTest extends ShortestPathAlgorithmTest {
	
	@Test
	public void test() {
		testAlgorithm(new BellmanFord());
	}
}
