package de.uni_potsdam.hpi;
import static org.junit.Assert.*;
import org.junit.*; 

public class LinkedDequeTest {
	LinkedDeque q = new LinkedDeque(7);
	Object o = "object";
	
	@Test
	public void testOne() throws Exception {
		q.addLast(o);
		assertEquals(o, q.removeFirst());
	}
	
	@Test
	public void testLast() throws Exception {
		q.addLast(o);
		assertEquals(o, q.removeLast());
	}
	
	@Test
	public void testFirst() throws Exception {
		q.addFirst(o);
		assertEquals(o, q.removeFirst());
	}
	
	@Test
	public void testNull() throws Exception {
		for (int i = 0; i <= 6; i++)
			q.addLast(null);
		q.addLast(o);
		for (int i = 0; i <= 6; i++)
			assertEquals(q.removeFirst(), null);
		assertEquals(q.removeFirst(), o);
	}
	
	@Test
	public void testClear() throws Exception {
		q.clear();
		assertEquals(q.size(), 0);
	}
	
	@Test(expected = DequeEmpty.class)
	public void testEmpty() throws Exception {
		q.clear();
		q.removeLast();
	}
	
	@Test(expected = DequeFull.class)
	public void testFull() throws Exception {
		q.clear();
		for (int i = 0; i < q.capacity(); i++)
			q.addLast(null);
		q.addLast(o);
	}
}