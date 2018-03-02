package how2interface;

public class OHero extends Hero implements Offense{
	
	public void skillattack() {
		System.out.println("放出技能");
	}
	
//	Override
	public void attack() {
		System.out.println("強而有力的攻擊");
	}
	
	public OHero() {
//		super("name");
		System.out.println("OHero 的建構式");
	}
	
	public void superattack() {
		super.attack();
	}
	

	
	
	

}
