package how2package;

public class Test {

	public static void main(String[] args) {
		Hero Mccree = new Hero("Mccree");
		Hero Reaper = new Hero("Reaper");

		Mccree.copyright = "Blizzard Entertainment";

		System.out.println(Mccree.copyright);
		// System.out.println(Reaper.copyright);

		// 如果一個屬性，每個英雄都不一樣，比如name，這樣的屬性就應該設計為物件屬性，因為它是跟著物件走的，每個物件的name都是不同的
		//
		// 如果一個屬性，所有的英雄都共用，都是一樣的，那麼就應該設計為類屬性。
		// 比如血量上限，所有的英雄的血量上限都是 600，不會因為英雄不同，而取不同的值。 這樣的屬性，就適合設計為類屬性

		/*-------調用靜態方法------------*/
		
		// 1.Mccree.battleWin();
		// 2.Hero.battleWin();
		// 建議用2 更符合特性

		// Hero.battleWin();
	}

}
