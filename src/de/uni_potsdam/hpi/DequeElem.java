package de.uni_potsdam.hpi;

public class DequeElem {
	Object obj = null;
	DequeElem next = null;
	DequeElem last = null;
	
	public DequeElem(Object e) {
		obj = e;
	}
	
	public void setnext(DequeElem n) {
		this.next = n;
	}
	
	public void setlast(DequeElem l) {
		this.last = l;
	}
	
	public DequeElem getnext(){
		return this.next;
	}

	public DequeElem getlast(){
		return this.last;
	}
	
	public Object getobj() {
		return this.obj;
	}
}