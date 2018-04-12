package free;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int i, j;
		Scanner sc=new Scanner(System.in);
		System.out.println("歡迎!!");
		System.out.println("請輸入x值");
		i=sc.nextInt();
		
		System.out.println("請輸入y值");
		j=sc.nextInt();
		
		int counti=1;
		int countj=1;
		
		while(counti<=i) {
			countj=1;
			while(countj<=j) {
				System.out.print(counti+"*"+countj+"="+counti*countj+"\t");
				countj++;
			}
			System.out.println();
			counti++;
		}
	}

}
