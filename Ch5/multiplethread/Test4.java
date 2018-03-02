package multiplethread;

public class Test4 {
	public static void main(String[] args) {
		
		/*-----------交互------------*/
		// ***交互使用的不是Thread上的方法，而是Object 上的方法

		// 情境:
		// 天使復活人時會有一段無敵時間，現在Reaper一邊被天使加血，一邊被攻擊。
		// 當Reaper.hp=0時，天使會復活Reaper，此時沒有人能夠傷害的了Reaper，
		// 直到Reaper的血恢復到完，才能再次被攻擊。

		Hero Reaper = new Hero("Reaper", 250, 10);
		Hero Mercy = new Hero("Mercy", 200, 5);

		Thread att = new Thread() {
			public void run() {
				while (true) {
					Reaper.hurt();
					try {
						Thread.sleep(10);
					}catch(InterruptedException e) {}
				}
			}
		};
		
		att.start();
		
		Thread recover=new Thread() {
			public void run() {
				while(true) {
//					Mercy.recover(Reaper);
					try {
						Thread.sleep(10);
					}catch(InterruptedException e) {}
				}
			}
		};
		
		recover.start();
	}

}
