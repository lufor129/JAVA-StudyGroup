package petrestaurant;

public class Small2 {

	// 當狗和貓來我的店之前，我是不知道他們到底是什麼，
	// 但是當他們來到我的店，我就知道一個要貓糧食，一個要狗糧食。
	// 因為他們都實現了 我這個介面，都可以買。
	// 下面這個類相當於一個接待顧客的類，即店小二，
	// 他接待所有實現了我這個寵物店介面的動物，
	// 傳進來一個PetRestaurant 類型的寵物，注意，這個PetRestaurant 是介面

	public void buyfood(PetRestaurant pet) {
		pet.buy();
	}

	public static void main(String[] args) {
		// 實例化貓狗
		PetRestaurant dog = new PetDog();
		PetRestaurant cat = new PetCat();

		// 實例化店小二
		Small2 s2 = new Small2();
		s2.buyfood(dog);
		s2.buyfood(cat);

		// 你知道嗎，整個過程我這個店主其實根本不知道來的到底是貓是狗還是其他什麼，
		// 我只要有一個店小二，把這些來的不知什麼動物都全部交給店小二，店小二就知道怎麼去賣了，
		// 因為這些狗啊貓啊都實現了我這個寵物店的介面，而店小二就負責接待所有實現了我這個介面的動物。
		// 這就有一個好處，假如明天來了一頭小豬，只要它實現了我這個介面，我只管交給店小二處理就OK了，
		// 我這個店小二根本不需要變化，我這個店主也只需要產生實體一下這個動物就OK
		// 你想，假如沒有介面，會怎麼辦?
		// 來一個貓，我要去創造一個貓，還要產生實體，
		// 來一隻狗，我要創建一隻狗，同樣要產生實體，
		// 還要配備專門的店小二去接待，就會相當麻煩。

		// 作者：梅雲羅
		// 連結：https://www.zhihu.com/question/20111251/answer/14760353

	}

}
