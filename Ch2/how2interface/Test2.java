package how2interface;

public class Test2 {

	public void launch(Hero hero) {
		hero.attack();
	}

	public static void main(String[] args) {

		// Override，節約了開發時間，並可使用多態

		OHero tracer = new OHero();
		tracer.attack();

		// 多態、多形 Polymorphism
		Hero h1 = new OHero();
		Hero h2 = new Hero();
		Hero h3 = new OSHero();
		Hero h4 = new SHero();
		// h1.attack();
		// h2.attack();
		// h3.attack();

		// 要實現類的多態，需要如下條件
		// 1. 父類（介面）引用指向子類物件
		// 2. 調用的方法有重寫

		// 如果不使用多態，第三方調用要為每一個類設計方法
		// 如:Test2要
		// void launch(Hero h);
		// void launch(SHero sh);
		// void launch(OHero oh);
		// void launch(OSHero osh);

		// 使用了多態，只需寫一個 void launch(Hero hero);
		// 調用:

		// Test2 t2=new Test2();
		// t2.launch(h1);
		// t2.launch(h2);
		// t2.launch(h3);
		// t2.launch(h4);
	}

}
