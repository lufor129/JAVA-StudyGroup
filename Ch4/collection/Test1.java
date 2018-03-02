package collection;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
	public static void main(String[] args) {

		// 與ArrayList一樣，LinkedList也實現了List介面，諸如add,remove,contains等等方法。
		// 詳細使用，請參考 ArrayList 常用方法，在此不作贅述。
		//
		// 接下來要講的是LinkedList的一些特別的地方

		// 除了實現了List介面外，LinkedList還實現了雙向鏈表結構Deque，可以很方便的在頭尾插入刪除資料，是鍊表的一種
		// 什麼是鏈表結構: 而鏈表就相當於佛珠，每個珠子，只連接前一個和後一個，不用關心除此之外的其他佛珠在哪裡。

		// LinkedList是一個雙向鏈表結構的list
		LinkedList<Hero> ll = new LinkedList<Hero>();

		// 所以可以很方便的在頭部和尾部插入資料
		// 在最後插入新的英雄
		ll.addLast(new Hero("hero1"));
		ll.addLast(new Hero("hero2"));
		ll.addLast(new Hero("hero3"));
		System.out.println(ll);

		// 在最前面插入新的英雄
		ll.addFirst(new Hero("heroX"));
		System.out.println(ll);

		// 查看最前面的英雄
		System.out.println(ll.getFirst());
		// 查看最後面的英雄
		System.out.println(ll.getLast());

		// 查看不會導致英雄被刪除
		System.out.println(ll);
		// 取出最前面的英雄
		System.out.println(ll.removeFirst());

		// 取出最後面的英雄
		System.out.println(ll.removeLast());

		// 取出會導致英雄被刪除
		System.out.println(ll);

		// LinkedList 除了實現了List和Deque外，還實現了Queue介面(駐列)。
		// Queue是先進先出駐列 FIFO，常用方法：
		// offer 在最後添加元素
		// poll 取出第一個元素
		// peek 查看第一個元素

		// Queue代表FIFO 先進先出的駐列
		Queue<Hero> q = new LinkedList<Hero>();

		// 加在佇駐的最後面
		System.out.print("初始化駐列：\t");
		q.offer(new Hero("Hero1"));
		q.offer(new Hero("Hero2"));
		q.offer(new Hero("Hero3"));
		q.offer(new Hero("Hero4"));

		System.out.println(q);
		System.out.print("把第一個元素取poll()出來:\t");
		// 取出第一個Hero，FIFO 先進先出
		Hero h = q.poll();
		System.out.println(h);
		System.out.print("取出第一個元素之後的駐列:\t");
		System.out.println(q);

		// 把第一個拿出來看一看，但是不取出來
		h = q.peek();
		System.out.print("查看peek()第一個元素:\t");
		System.out.println(h);
		System.out.print("查看並不會導致第一個元素被取出來:\t");
		System.out.println(q);

		// 此外，LinkedList也實現了Stack(先進後出)
		// 我們試試看用LinkedList實縣自己專屬的Stack吧~~
		
		MyStack ms=new MyStack();
		for(int i=0;i<10;i++) {
			ms.push(new Hero("Hero "+i));
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(ms.pull().name);
		}

	}

}
