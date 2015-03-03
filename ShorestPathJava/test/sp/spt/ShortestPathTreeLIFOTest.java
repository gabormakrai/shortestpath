package sp.spt;

import org.junit.Test;

import sp.ShortestPathAlgorithmTest;
import sp.spt.ShortestPathTreeLIFO;

public class ShortestPathTreeLIFOTest extends ShortestPathAlgorithmTest {
	
	@Test
	public void test() {
		testAlgorithm(new ShortestPathTreeLIFO());
	}
	
}
