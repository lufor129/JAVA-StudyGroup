package how2interface;

public class Test {

	public static void main(String[] args) {
		// 對象的轉型
		// 通常情況下，參考類型和物件類型是一樣的
		// 接下來要討論的類型轉換的問題，指的是參考類型和物件類型不一致的情況下的轉換問題

		// 1.子轉父(向上) iphone 繼承了手機 ，把iphone當成普通手機使用
		// 合理的

		Hero h = new Hero();
		OHero Genji = new OHero();
		h = Genji;
		// 等同於Hero h=new OHero();

		// 2.父轉子(向下) 不可，要強制轉，把NOKIA3316 當成智慧手機用有點困難

		// Genji=h;
		Genji = (OHero) h;

		// 3.接口向上 可以

		SHero Mercy = new SHero();
		Support s1 = Mercy;
		// 等同
		Support s2 = new SHero();

		// 4.接口向下 要強轉 要是多個接口，則不能轉

		SHero sh = (SHero) s1;

		// 下面會出錯，執行看看 畢竟support不能使用skillattack
		OSHero os = (OSHero) s2;
		os.skillattack();
		os.heal();

	}
}
