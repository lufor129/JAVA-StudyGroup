package free;

import java.util.Scanner;

public class Facorial {
	
	public int getAddFac(int count) {
		int temp=1;
		int sum=0;
		for(int i=1;i<=count;i++) {
			temp*=i;
			sum+=temp;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int count=sc.nextInt();
		Facorial f=new Facorial();
		
		System.out.println(f.getAddFac(count));
	}

}
