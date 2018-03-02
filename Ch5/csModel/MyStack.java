package csModel;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyStack<T> {
	
	LinkedList<T> values =new LinkedList<T>();
	
	public synchronized void push(T t) {
		while(values.size()>=10) {
			try {
				this.wait();
			}catch(InterruptedException e) {}
		}
		this.notifyAll();
		values.addLast(t);
	}
	
	public synchronized T Pull() {
		while(values.isEmpty()) {
			try {
				this.wait();
			}catch(InterruptedException e) {}
		}
		this.notifyAll();
		return values.removeLast();
	}
	
	public T peek() {
		return values.getLast();
	}

}
