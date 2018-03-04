package jdbc;

import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) {
		
		EasyJDBC ej=new EasyJDBC();
		ArrayList<Hero> al=ej.search();
		for(int i=0;i<al.size();i++) {
			Hero h=al.get(i);
			System.out.println(h.name);
		}
	}
}
