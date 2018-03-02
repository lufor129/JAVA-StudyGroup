package exception;

public class Hero {
	
//	在Hero的attack方法中，當發現敵方英雄的血量為0的時候，拋出該異常
//	1. 創建一個HeroIsDeadException實例
//	2. 通過throw 拋出該異常
//	3. 當前方法通過 throws 拋出該異常
//
//	在外部調用attack方法的時候，就需要進行捕捉，並且捕捉的時候，可以通過e.getMessage() 獲取當時出錯的具體原因
	
	public String name;
	public float hp;
	
	public Hero(String name,int hp) {
		this.name=name;
		this.hp=hp;
	}
	
	public void attackHero(Hero h) throws HeroIsDeadException{
		if(h.hp==0) {
			throw new HeroIsDeadException(h.name+ " 已經死了，不要打她了");
		}
	}
	
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		Hero Mei=new Hero("Mei",250);
		Hero Orisa=new Hero("Orisa",0);
		
		try {
			Mei.attackHero(Orisa);
		}catch(HeroIsDeadException e) {
			System.out.println("異常原因: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
//	練習: practice2


}
