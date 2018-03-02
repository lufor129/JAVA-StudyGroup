package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Test3 {
	public static void main(String[] args) {
//		關於HashCode我自己也還在研究，不敢亂教人，就不寫了，看課本吧!!!
//		這邊講Collection和Collections
//		Collection是介面，是所有集合之父
//		Collections是類，有許多static 可供使用
		
//		下面介紹幾個好用的Collections方法
		
		List<Integer> col=new ArrayList<>();
		
//		放入0~9
		for(int i=0;i<10;i++) {
			col.add(i);
		}
		
		System.out.println(col);
		
//		1.reverse反轉
		Collections.reverse(col);
		System.out.println(col);
		
//		2.shuffle洗牌
		Collections.shuffle(col);
		System.out.println(col);
		
//		3.sort排序
		Collections.sort(col);
		System.out.println(col);
		
//		4.swap交換
		Collections.swap(col, 2, 3);
		System.out.println(col);
		
//		5.rotate滾動
		Collections.rotate(col, 4);
		System.out.println(col);
		
//		練習:
//		首先初始化一個List,長度是10，值是0-9。
//		然後不斷的shuffle，直到前3位出現
//		3 1 4
//
//		shuffle 1000,000 次，統計出現的概率

	}

}
