package collection;

import java.util.LinkedList;

public class MyStack implements Stack{
	
	LinkedList<Hero> heros=new LinkedList<Hero>();
	
	public void push(Hero h) {
		heros.addLast(h);
	}
	
	public Hero pull() {
		return heros.removeLast();
	}
	
	public Hero peek() {
		return heros.getLast();
	}


	
}
