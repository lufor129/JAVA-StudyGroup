package generics;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
//		不使用泛型帶來的問題
//		ArrayList 預設接受Object類型的物件，所以所有物件都可以放進ArrayList中
//		所以get(0) 返回的類型是Object
//		接著，需要進行強制轉換才可以得到SHero類型或者DHero類型。
//		如果軟體發展人員記憶比較好，能記得哪個是哪個，還是可以的。 但是開發人員會犯錯誤，忘記哪個是哪個
		
//		使用泛型的好處：
//		泛型的用法是在容器後面添加<Type>
//		Type可以是類，抽象類別，介面
//		泛型表示這種容器，只能存放SHero，DHero就放不進去了
		
//		假設容器的泛型是Hero,那麼Hero的子類SHero,DHero都可以放進去 
//		和Hero無關的類型Item還是放不進去。

		
		ArrayList<SHero> sheros=new ArrayList<SHero>();
		
		sheros.add(new SHero());
		
//		sheros.add(new DHero());
		
//		獲取時也不需要轉型了
		
		SHero sh=sheros.get(0);

//		練習:
//			今天想設計一個泛型，"只"可以放入Item和Hero，該怎麼做?
		
//		支援泛型的類
		MyStack<Hero> mheros=new MyStack<>();
		MyStack<Item> mitems=new MyStack<>();
		
//		泛型之間不可隨意轉型
//		例:
		ArrayList<Hero> heros=new ArrayList<>();
//		不可
//		heros=sheros;
	}
}
