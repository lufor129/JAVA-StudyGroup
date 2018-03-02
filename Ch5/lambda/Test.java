package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(400) + 200, r.nextInt(100)));
		}

		System.out.println(heros);
		System.out.println("--------------------");
		// 1.普通方法 想要Tank hp>200,damage<50
		filter(heros);

		// 2.匿名方法
		HeroChecker checker = new HeroChecker() {
			public boolean testHero(Hero hero) {
				return (hero.hp > 200 && hero.damage < 50);
			}
		};

		// 把匿名類傳入
		filter(heros, checker);

		// 3.lambda方式傳入方法
		filter(heros, h -> h.hp > 200 && h.damage < 50);

		// 下面講解匿名類到lambda的過程 (參考自
		// http://how2j.cn/k/lambda/lambda-lamdba-tutorials/697.html#nowhere)

		// 匿名類的正常寫法
		HeroChecker c1 = new HeroChecker() {
			@Override
			public boolean testHero(Hero h) {
				return (h.hp > 100 && h.damage < 50);
			}
		};
		// 把new HeroChcekcer，方法名，方法返回類型資訊去掉
		// 只保留方法參數和方法體
		// 參數和方法體之間加上符號 ->
		HeroChecker c2 = (Hero h) -> {
			return h.hp > 100 && h.damage < 50;
		};

		// 把return和{}去掉
		HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;

		// 把 參數類型和圓括號去掉
		HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;

		// 把c4作為參數傳遞進去
		filter(heros, c4);

		// 直接把運算式傳遞進去
		filter(heros, h -> h.hp > 100 && h.damage < 50);

		// lambda可看作是匿名類的最終簡化版
		
//		既然lambda是方法的傳入，那麼也可以將靜態方法，和對象方法作為變數傳入
		
//		1.靜態方法傳入
		filter(heros,Test::AtestHero);
		
//		2.動態方法傳入
//		動態方法傳入需要對象
		Test t=new Test();
		filter(heros,t::BtestHero);
		

	}

	public static void filter(List<Hero> heros) {
		for (Hero hero : heros) {
			if (hero.hp > 200 && hero.damage < 50) {
				System.out.println(hero);
			}
		}
	}

	// 將方法傳入
	public static void filter(List<Hero> heros, HeroChecker checker) {
		for (Hero hero : heros) {
			if (checker.testHero(hero))
				System.out.println(hero);
		}
	}
	
	public boolean BtestHero(Hero hero) {
		return hero.hp > 200 && hero.damage < 50;
	}
	
	public static boolean AtestHero(Hero hero) {
		return hero.hp > 200 && hero.damage < 50;
	}

}
