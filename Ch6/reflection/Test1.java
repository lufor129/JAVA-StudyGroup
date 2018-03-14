package reflection;

//其實同個包可以不用import 
import reflection.Hero;

public class Test1 {

	public static void main(String[] args) {
		// 之前說過類(靜態)方法、屬性 static 現在來說說類物件
		// 類物件概念： 所有的類，都存在一個類物件，這個類物件用於提供類本身的資訊，比如有幾種構造方法， 有多少屬性，有哪些普通方法。
		//
		// 在理解類物件之前，先說我們熟悉的物件之間的區別：
		// s76和sombra都是Hero對象，他們的區別在於，各自有不同的名稱，血量，傷害值。
		//
		// 然後說說類之間的區別
		// Hero和Item都是類，他們的區別在於有不同的方法，不同的屬性。
		//
		// 類物件，就是用於描述這種類，都有什麼屬性，什麼方法的
		//
		// 獲取類物件有3種方式Class
		// 1. Class.forName
		// 2. Hero.class
		// 3. new Hero().getClass()
		//
		// 在一個JVM中，一種類，只會有一個類物件存在。所以以上三種方式取出來的類物件，都是一樣的。

		try {
			Class Class1 = Class.forName("reflection.Hero");
			Class Class2 = Hero.class;
			// 實例化一個後取出
			Class Class3 = new Hero().getClass();
			System.out.println(Class1);
			// 一個類只會有單例一個類對象存在
			// ==是否指向同一物件，equals為比較兩物件是否有相同類型的類別後比較其內容是否相同
			// System.out.println(Class1==Class2);
			// System.out.println(Class2==Class3);
			
			// 獲取類物件的時候，會導致類屬性被初始化
			// 無論什麼途徑獲取類物件，都會導致靜態屬性被初始化，而且只會執行一次。
			// （除了直接使用 Class c = Hero.class 這種方式，這種方式不會導致靜態屬性被初始化）

		} catch (ClassNotFoundException e) {

		}

	}

}
