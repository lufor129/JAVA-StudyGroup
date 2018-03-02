package generics;

import java.util.LinkedList;

//支援泛型的類
public class MyStack<T>{
	
	LinkedList<T> heros=new LinkedList<>();
	
	public void push(T h) {
		heros.addLast(h);
	}
	
	public T pull() {
		return heros.removeLast();
	}
	
	public T peek() {
		return heros.getLast();
	}


	
}
