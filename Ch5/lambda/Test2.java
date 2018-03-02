package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test2 {
	public static void main(String[] args) {

		// 聚合操作

		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(400) + 200, r.nextInt(100)));
		}

		// 一般遍歷方式
		for (Hero h : heros) {
			if(h.hp>200 && h.damage<50)
			System.out.println(h.name);
		}
		
		System.out.println("----------------");
		// 使用聚合
		heros
		.stream()
		.filter(h -> h.hp > 200 && h.damage < 50)
		.forEach(h -> System.out.println(h.name));
		
//		要瞭解聚合操作，首先要建立Stream和管道的概念
//		Stream是一系列的元素，就像是生產線上的罐頭一樣，一串串的出來。
//		管道指的是一系列的聚合操作。
//
//		管道又分3個部分
//		管道源：在這個例子裡，源是一個List
//		中間操作： 每個中間操作，又會返回一個Stream，比如.filter()又返回一個Stream。
//		結束操作：當這個操作執行後，流就被使用“光”了，無法再被操作。所以這必定是流的最後一個操作。 
//		結束操作不會返回Stream，但是會返回int、float、String、 Collection或者像forEach，什麼都不返回
//		結束操作才進行真正的遍歷行為，在遍歷的時候，才會去進行中間操作的相關判斷。
		
		
//		1.管道源
//		只要是Collection都可以使用Collection.stream()
//		Array[] 用Arrays.stream()
		
		Hero hs[]=heros.toArray(new Hero[heros.size()]);
		Arrays.stream(hs).forEach(h->System.out.println(h.name));
		
		
//		2.中間操作
//		中間操作比較多，主要分兩類
//		對元素進行篩選 和 轉換為其他形式的流
//		對元素進行篩選：
//		filter 匹配
//		distinct 去除重複(根據equals判斷)
//		sorted 自然排序
//		sorted(Comparator<T>) 指定排序
//		limit 保留
//		skip 忽略
//		轉換為其他形式的流
//		mapToDouble 轉換為double的流
//		map 轉換為任意類型的流 
		
		
//		3.結束操作
//		當進行結束操作後，流就被使用“光”了，無法再被操作。
//		所以這必定是流的最後一個操作。 結束操作不會返回Stream，但是會返回int、float、String、 Collection或者像forEach，什麼都不返回,。
//		結束操作才真正進行遍歷行為，前面的中間操作也在這個時候，才真正的執行。
//		常見結束操作如下：
//		forEach() 遍歷每個元素
//		toArray() 轉換為陣列
//		min(Comparator<T>) 取最小的元素
//		max(Comparator<T>) 取最大的元素
//		count() 總數
//		findFirst() 第一個元素
		
//		範例: 把hp第三高的英雄打印出來
		
		Hero third=heros.
				   stream().
				   sorted((h1,h2)->h1.hp>h2.hp?1:-1).
				   skip(2).
				   findFirst().
				   get();
		
		System.out.println(third.toString());
		

	}

}
