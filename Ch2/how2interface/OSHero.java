package how2interface;

public class OSHero extends Hero implements Offense,Support{
//	有會加血，又有攻擊技能的英雄(例如:士兵76)
	
//	繼承了Hero也繼承了name,hp....
//	實現了Offense,Suppot接口後必須實現接口內的方法(heal、skillattack)
	
	public void heal() {
		System.out.println("過來治療一下");
	}
	
	public void skillattack() {
		System.out.println("(╬ﾟдﾟ)▄︻┻┳═一 弌弌弌弌弌弌弌弌弌弌⊃");
	}
	
	public void attack() {
		System.out.println("༼ つ ◕_◕ ༽つ");
	}

}
