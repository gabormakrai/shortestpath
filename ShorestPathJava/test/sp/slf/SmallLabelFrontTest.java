package sp.slf;

import org.junit.Test;

import sp.ShortestPathAlgorithmTest;
import sp.slf.SmallLabelFront;

public class SmallLabelFrontTest extends ShortestPathAlgorithmTest {
	
	@Test
	public void test() {
		testAlgorithm(new SmallLabelFront());
	}

}
