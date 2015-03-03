package sp.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DequeueTest {
	
	@Test
	public void test() {
		Dequeue deq = new Dequeue();
		deq.queueQ1(1);
		deq.queueQ1(2);
		deq.queueQ1(3);
		deq.queueQ1(4);
		deq.queueQ1(5);
		deq.queueQ1(6);
		deq.queueQ2(1);
		deq.queueQ2(2);
		deq.queueQ2(3);
		deq.queueQ2(4);
		deq.queueQ2(5);
		deq.queueQ2(6);
		
		assertEquals(12, deq.size);
		assertEquals(6, deq.dequeue());
		assertEquals(11, deq.size);
		assertEquals(5, deq.dequeue());
		assertEquals(10, deq.size);
		assertEquals(4, deq.dequeue());
		assertEquals(9, deq.size);
		assertEquals(3, deq.dequeue());
		assertEquals(8, deq.size);
		assertEquals(2, deq.dequeue());
		assertEquals(7, deq.size);
		
		deq.queueQ1(5);
		
		assertEquals(8, deq.size);
		assertEquals(5, deq.dequeue());
		assertEquals(7, deq.size);
		assertEquals(1, deq.dequeue());
		
		assertEquals(6, deq.size);
		assertEquals(1, deq.dequeue());
		assertEquals(5, deq.size);
		assertEquals(2, deq.dequeue());
		assertEquals(4, deq.size);
		assertEquals(3, deq.dequeue());
		assertEquals(3, deq.size);
		assertEquals(4, deq.dequeue());
		assertEquals(2, deq.size);
		
		deq.queueQ1(10);
		deq.queueQ2(100);
		deq.queueQ2(101);
		
		assertEquals(5, deq.size);
		assertEquals(10, deq.dequeue());
		assertEquals(4, deq.size);
		assertEquals(5, deq.dequeue());
		assertEquals(3, deq.size);
		assertEquals(6, deq.dequeue());
		assertEquals(2, deq.size);
		assertEquals(100, deq.dequeue());
		assertEquals(1, deq.size);
		assertEquals(101, deq.dequeue());
		assertEquals(0, deq.size);
	}
}
