package free;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Node {
	
	Integer data;
	Node rightNode;
	Node leftNode;

	public void add(Integer d) {
		if(null==this.data) {
			this.data=d;
		}else {
			if(d-this.data<=0) {
				if(null==leftNode)
					leftNode=new Node();
				leftNode.add(d);
			}
			else {
				if(null==rightNode)
					rightNode=new Node();
				rightNode.add(d);
			}
		}
	}
	
	public List travel() {
		List value=new ArrayList();
		
		if(null!=leftNode)
			value.addAll(leftNode.travel());
		
		value.add(data);
		
		if(null!=rightNode)
			value.addAll(rightNode.travel());
		
		return value;
	}
	public static void main(String[] args) {
		int randoms[]=new int[10];
		Random r=new Random();
		for(int i=0;i<10;i++) {
			randoms[i]=r.nextInt(100);
			System.out.print(randoms[i]+" ");
		}
		
		System.out.println();
		Node N=new Node();
		for(int number:randoms)
			N.add(number);
		System.out.println(N.travel());
	}

}
