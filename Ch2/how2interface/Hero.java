package how2interface;

public class Hero {
	
	public String name;
	public int hp;
	public int damage;
	public float speed;
	
	public void attack() {
		System.out.println("普通攻擊");
	}
	
	public Hero() {
		System.out.println("Hero 的建構式");
	}
	
	public Hero(String name) {
		System.out.println(name);
	}
	
	public boolean equals(Object o) {
//		如果o的class是Hero
		if(o instanceof Hero) {
//			電腦無法判段 o是否為 Hero要加上這段
			Hero h=(Hero)o;
			return this.hp == h.hp;
		}
		return false;
	}

}
