package de.uni_potsdam.hpi;

public class LinkedDeque implements Deque {
	private int cap;
	private int siz;
	private DequeElem watcher = new DequeElem("WATCHER");
	
	public LinkedDeque(int c) {
		cap = c;
		watcher.setnext(watcher);
		watcher.setlast(watcher);
	}
	
	public int capacity() {
		return cap;
	}
	
	public int size() {
		return siz;
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
	
	public void clear() {
		watcher.setlast(watcher);
		watcher.setnext(watcher);;
	}
	
	private void addF(Object e) throws DequeFull {
		if (size() < cap) {
			DequeElem del = new DequeElem(e);
			del.setlast(watcher);
			del.setnext(watcher.getnext());
			(watcher.getnext()).setlast(del);
			watcher.setnext(del);
			siz++;
		} else {
			throw new DequeFull();
		}
	} 

	private void addL(Object e) throws DequeFull {
		if (size() < cap) {
			DequeElem del = new DequeElem(e);
			del.setnext(watcher);
			del.setlast(watcher.getlast());
			(watcher.getlast()).setnext(del);
			watcher.setlast(del);
			siz++;
		} else {
			throw new DequeFull();
		}
	} 

	private Object rmvF() throws DequeEmpty {
		if (this.size() != 0) {
			Object temp = (watcher.getnext()).getobj();
			watcher.setnext((watcher.getnext()).getnext());
			(watcher.getnext()).setlast(watcher);
			siz--;
			return temp;
		} else {
			throw new DequeEmpty();
		}
	}
	
	private Object rmvL() throws DequeEmpty {
		if (size() != 0) {
			Object temp = (watcher.getlast()).getobj();
			watcher.setlast((watcher.getlast()).getlast());
			(watcher.getlast()).setnext(watcher);
			siz--;
			return temp;			
		} else {
			throw new DequeEmpty();
		}
	}
}