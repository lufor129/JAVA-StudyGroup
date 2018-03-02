package how2package;

public class Winston {
	// 單例化
	// 這邊是進階題，考試不會考(大概吧)
	// 是封裝和靜態的應用，有空可以看看
	//
	// 在2017.12 OW出過一個BOSS戰模式
	// 五個小美去擊殺一個猩猩，只要猩猩死了就贏了
	// 要如何全場只出現一個猩猩?

	private static int hp = 5000;
	private static String name = "Winston";

	// 私有化建構式，使外界無法訪問
	private Winston() {

	}

	// 準備靜態屬性，用於指向實例化對象，但暫時指向null
	private static Winston Boss;

	public static Winston getWinston() {
		// 第一次訪問指向null時，實例化一個對象
		if (Boss == null) {
			Boss = new Winston();
		}
		return Boss;
	}

}
