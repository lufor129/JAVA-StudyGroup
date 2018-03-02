package method;

public class Test {
	public static void main(String[] args) {
		new Hero(); // 建立一個對象
		Hero h = new Hero(); // 數用一個引用h來指向這對象
		Hero h1 = h;
		Hero h2 = h;
		Hero h3 = h; // h123全部指向同一對象

		Hero s76 = new Hero();
		s76 = new Hero(); // s76引用不同對象

		/*------------------------------*/
		//
		// Weapon Gun =new Weapon();
		// Gun.damage=10;
		// Gun.name="rifle";
		//
		// System.out.println(Gun.name);
		//
		/*------------------------------*/
		//
		// Hero Genji=new Hero("Genji");
		// System.out.println(Genji);
		// Genji.printThis();

		/*-------------類傳參-------------*/

		// s76=new Hero("s76",200,50);
		// Genji=new Hero("Genji",200,70);
		//
		// s76.attackHero(Genji);
		// System.out.println(Genji.hp);
		//

	}
}
