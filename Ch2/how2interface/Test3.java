package how2interface;

public class Test3 {

	public static void main(String[] args) {

		// super 的講解
		// 產生實體一個OHero(), 其構造方法會被調用
		// 其父類的構造方法也會被調用
		// 並且是父類構造方法先調用， 
		// 子類構造方法會默認調用父類的 無參 的構造方法 (父有兩個時也是默認調用無參)
		// 多個父建構時至少會調用一個，默認為默認父建構 "public Hero()"

		new OHero();

		// 要調用有參，使用super
		// new OHero();

		// 此外 由於多態 也可利用super調用父的方法
		// new OHero().superattack();

		// 進階題: 要是Hero只有一個建構 public Hero(String name);
		// 會使 Hero 默認public Hero(); 消失
		// 但OHero系統默認優先訪問public Hero()導致錯誤 請問要如何調用避免錯誤?
		// 提示: super("")

		/*-----------------Object----------*/

		// 在聲明一個類時，默認繼承Object
		// public class Hero extends Object
		// 因此你多了很多可以使用的方法

		// 1.toString 用來Override
		// System.out.println(new SHero().toString());

		// 2.equal 判斷是否相同，同樣用來多態 (==判斷是否指向同一對象)
		Hero h1 = new Hero();
		h1.hp = 200;
		Hero h2 = new Hero();
		h2.hp = 300;
		Hero h3 = new Hero();
		h3.hp = 200;
		Hero h4 = h1;

		System.out.println(h1.equals(h2));
		System.out.println(h1.equals(h3));
		System.out.println(h1 == h2);
		System.out.println(h1 == h4);

		// 3.getClass物件的類
		System.out.println(new Hero().getClass());

		// 4.其他很重要的 wait(),notify(),notifyAll() 等多線程再講

		/*--------------final修飾-----------------*/
		// 就是字面意思，最終
		// final修飾類 ，代表無法被繼承
		// final修飾方法，代表無法被重寫
		// final修飾變量，代表只能進行賦值一次 (常量: 譬如:技能數量，血量上限 在遊戲中是不變的)
		// final修飾引用，代表只有一次指向對象的機會
		

	}

}
