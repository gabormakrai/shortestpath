package sp.spt;

import org.junit.Test;

import static org.junit.Assert.*;

public class LIFOQueueTest {
	
	@Test
	public void test() {
		LIFOQueue queue = new LIFOQueue();
		queue.queue(1);
		queue.queue(2);
		queue.queue(3);
		queue.queue(4);
		queue.queue(5);
		queue.queue(6);
		queue.queue(7);
		queue.queue(8);
		queue.queue(9);
		queue.queue(10);
		
		assertEquals(10, queue.size);
		assertEquals(10, queue.dequeue());
		assertEquals(9, queue.size);
		assertEquals(9, queue.dequeue());		
		assertEquals(8, queue.size);
		assertEquals(8, queue.dequeue());		
		assertEquals(7, queue.size);
		assertEquals(7, queue.dequeue());		
		assertEquals(6, queue.size);
		assertEquals(6, queue.dequeue());		
		assertEquals(5, queue.size);
		assertEquals(5, queue.dequeue());		
		assertEquals(4, queue.size);
		assertEquals(4, queue.dequeue());		
		assertEquals(3, queue.size);
		assertEquals(3, queue.dequeue());		
		assertEquals(2, queue.size);
		assertEquals(2, queue.dequeue());		
		assertEquals(1, queue.size);
		assertEquals(1, queue.dequeue());		
		assertEquals(0, queue.size);
	}
}
