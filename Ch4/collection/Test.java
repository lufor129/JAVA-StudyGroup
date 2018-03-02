package collection;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		ArrayList heros=new ArrayList();
		for(int i=0;i<10;i++) {
			heros.add(new Hero("Hero "+i));
		}
		
		System.out.println(heros.size());
		
//		1.add(int ,Object)插入，注意是0開始算
		Hero sombra=new Hero("Sombra");
		heros.add(2,sombra);
		System.out.println(heros);
		
//		2.contains判斷是否存在，注意，是物件名字，不是name
		System.out.println(heros.contains(sombra));
		
//		3.get獲取指定位置的對象，注意，越界會抱錯
		System.out.println(heros.get(3));
		
//		4.indexOf獲取對象所處位置，沒有會-1
		System.out.println(heros.indexOf(sombra));
		System.out.println(heros.indexOf(new Hero("Hero "+1)));
		
//		5.remove刪除，依下標or物件名
//		不展開了，自己練習
		
//		6.set替換，和add語法依樣，但是是替換
//		不展開了，自己練習
		
//		7.size數組大小(int)
//		不展開了，自己練習
		
//		8.toArray將ArrayList轉為數組
//		toArray可以把一個ArrayList物件轉換為陣列。
//		需要注意的是，如果要轉換為一個Hero陣列，
//		那麼需要傳遞一個Hero陣列類型的物件給toArray()，這樣toArray方法才知道，
//		你希望轉換為哪種類型的陣列，否則只能轉換為Object陣列

		Hero hs[]=(Hero[])heros.toArray(new Hero[] {});
		
		for(Hero h:hs) {
			System.out.print(h.toString());
		}
		System.out.println("\n");
		
//		9.addAll 把另一個容器的所有對象都加進來
		ArrayList anotherHero=new ArrayList();
		System.out.println(anotherHero.size());
		anotherHero.addAll(heros);
		System.out.println(anotherHero);
		
//		10.clean 清空
//		不展開了，自己練習
		
//		補充:
//			ArrayList 是 List 的實踐
		List h=new ArrayList();
		h.add(new Hero("sombra"));
		
//		對JAVA集合有興趣的同學歡迎參考網站
//		https://zhuanlan.zhihu.com/p/24234059
		
	}

}
