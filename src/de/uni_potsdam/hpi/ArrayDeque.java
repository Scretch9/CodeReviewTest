package de.uni_potsdam.hpi;

public class ArrayDeque implements Deque {
	private int cap;
	private int first = 0;
	private int last = -1;
	private Object[] dq = null;
	
	public ArrayDeque(int c) {
		this.cap = c;
		this.dq = new Object[cap];
	}
	
	public int capacity() {
		return this.cap;
	}
	
	public int size() {
		return ((this.last - this.first) % this.cap + 1);
	}
	
	public void addFirst(Object e) throws DequeFull {
		try {
			addF(e);
		} catch (DequeFull d) {
			System.out.println(d.getMessage());
		}
	}
	
	public void addLast(Object e) throws DequeFull {
		try {
			addL(e);
		} catch (DequeFull d) {
			System.out.println(d.getMessage());
		}
	}
	
	public Object removeFirst() throws DequeEmpty {
		Object temp = null;
		try {
			temp = rmvF();
		} catch (DequeEmpty d) {
			System.out.println(d.getMessage());
		}
		return temp;
	}
	
	public Object removeLast() throws DequeEmpty {
		Object temp = null;
		try {
			temp = rmvL();
		} catch (DequeEmpty d) {
			System.out.println(d.getMessage());
		}
		return temp;
	}
	
	public void clear() { //alte Elemente werden nicht gelöscht sondern beim hinzufügen neuer Überschrieben
		this.first = 0;
		this.last = -1;
	}
	
	private void addF(Object e) throws DequeFull {
		if (this.size() < this.cap) {
			dq[(this.first - 1) % this.cap] = e;
			first = (first - 1) % this.cap;
		} else {
			throw new DequeFull();
		}
	} 

	private void addL(Object e) throws DequeFull {
		if (this.size() < this.cap) {
			dq[(this.last + 1) % this.cap] = e;
			this.last = (this.last + 1) % this.cap;
		} else {
			throw new DequeFull();
		}
	} 

	private Object rmvF() throws DequeEmpty {
		if (this.size() != 0) {
			Object temp = this.dq[first];
			this.dq[first] = null;
			this.first = (this.first + 1) % this.cap;
			return temp;
		} else {
			throw new DequeEmpty();
		}
	}
	
	private Object rmvL() throws DequeEmpty {
		if (this.size() != 0) {
			Object temp = dq[last];
			dq[this.last] = null;
			this.last = (this.last - 1) % this.cap;
			return temp;			
		} else {
			throw new DequeEmpty();
		}
	}
}