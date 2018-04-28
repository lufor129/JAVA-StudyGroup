package how2interface;

public class Test4 {
	public static void main(String[] agrs) {

		/*-------abstract修飾 -------------*/
		// 像是extends和implements的結合，不展開了 (考試會考，看書)
		// 注意 寫抽象方法 要在 抽象類中 ，抽象類是無法實例化的

		/*------匿名類 和 本地類-----------------*/
		// 我記得課本沒有，但我覺得很重要，在多現程也需要用到

		// 匿名類指的是在聲明一個類的同時產生實體它，使代碼更加簡潔精練
		// 通常情況下，要使用一個介面或者抽象類別，都必須創建一個子類
		//
		// 有的時候，為了快速使用，直接產生實體一個抽象類別，並“當場”實現其抽象方法。
		// 既然實現了抽象方法，那麼就是一個新的類，只是這個類，沒有命名。
		// 這樣的類，叫做匿名類

		Hero h = new Hero() {
			// Override
			public void attack() {
				System.out.println("去去武器走  O-(///￣皿￣)⊃━☆゜★█▇▆▅▄▃▂＿　");
			}
		};

		h.attack();

		// 本地類:
		// 本地類可以理解為有名字的匿名類
		// 本地類和匿名類一樣，直接聲明在代碼塊裡面，可以是主方法，for迴圈裡等等地方

		class SomeHero extends Hero {
			public void attack() {
				System.out.println("(∩^o^)⊃━☆ﾟ.*･｡");
			}
		}

		// 有自訂的類名
		SomeHero sh = new SomeHero();
		sh.attack();
		
//		有回家作業 practice1請務必要做

	}

}
