package multiplethread;

public class Hero {

	String name;
	int hp;
	int damage;

	public Hero(String name, int hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	// 正式進入多線程，多線程的建構只有兩種，但我多教一種好用的延伸

	public void attackHero(Hero h) {
		try {
			// 表示攻擊需要時間，每次攻擊停一秒
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		h.hp -= this.damage;
		System.out.format("%s attack %s ，%s left %d\n", this.name, h.name, h.name, h.hp);

		if (h.isDead()) {
			System.out.println(h.name + " is Dead");
		}
	}

	public boolean isDead() {
		return this.hp > 0 ? false : true;
	}

	//
	 public void hurt() {
	 hp=hp-1;
	 }
	
	 public void heal() {
	 hp=hp+1;
	 }
	//
	//
	// 既然任意物件都可以用來作為同步物件，而所有的執行緒訪問的都是同一個hero對象，索性就使用小美來作為同步對象
	// 進一步的，對於Hero的hurt方法，加上：
	// synchronized (this) {
	// }
	// 表示當期物件為同步物件，即也是Mei為同步物件

	// public void heal() {
	// synchronized(this) {
	// hp=hp+1;
	// }
	// }

	// 同步方法
	// 在hurt前，直接加上synchronized ，其所對應的同步物件，就是this
	// 和heal方法達到的效果是一樣
	// 外部執行緒訪問Mei的方法，就不需要額外使用synchronized 了

//	錯誤範例 :
//	   作業:
//		   想想看為什麼錯了? 
//	public synchronized void hurt() {
//		if (this.isDead()) {
//			try {
//				System.out.println(this.name + " 被打死了!!");
//				this.wait();
//				this.notify();
//			} catch (InterruptedException e) {
//			}
//		}
//		hp = hp - 1;
//		System.out.println(this.name + " 受到攻擊 ，剩下 " + this.hp);
//	}
//
//	public synchronized void heal() {
//		this.hp += 10;
//	}
//
//	public synchronized void recover(Hero h) {
//			System.out.println("英雄不朽");
//
//			while (h.hp < 250) {
//				h.heal();
//				System.out.println(h.name + " 受到了復活，目前有 " + h.hp);
//			}
//			System.out.println(" 復活完成 ，解除無敵狀態");
//			this.notify();
//		}
//	}
	
//	提示；留意wait()和notify() 這兩個方法是什麼物件上的？
	
//	正確
//	public synchronized void hurt() {
//		if(this.isDead()) {
//			try {
//				System.out.println(this.name + " 被打死了!!");
//				this.notify();
//				this.wait();
//			}catch(InterruptedException e) {}		
//		}
//		this.hp=this.hp-1;
//		System.out.println(this.name + " 受到攻擊 ，剩下 " + this.hp);
//	}
//	
//	public void recover(Hero h) {
//		synchronized(h) {
//			if(h.hp>=250) {
//				try {
//					System.out.println(" 復活完成 ，解除無敵狀態");
//					h.notify();
//					h.wait();
//				}catch(InterruptedException e) {}
//			}
//			h.hp+=10;
//			System.out.println(h.name + " 受到了復活，目前有 " + h.hp);
//		}
//	}
	
//	這裡需要強調的是，wait方法和notify方法，
//	並不是Thread執行緒上的方法，它們是Object上的方法。 
//	因為所有的Object都可以被用來作為同步物件，
//	所以準確的講，wait和notify是同步物件上的方法。
//
//	wait()的意思是： 讓佔用了這個同步物件的執行緒，臨時釋放當前的佔用，並且等待。
//	所以調用wait是有前提條件的，一定是在synchronized塊裡，否則就會出錯。
//
//	notify() 的意思是
//	，通知一個等待在這個同步物件上的執行緒，你可以蘇醒過來了，有機會重新佔用當前物件了。
//
//	notifyAll() 的意思是，通知所有的等待在這個同步物件上的執行緒，你們可以蘇醒過來了，有機會重新佔用當前物件了。
	
//	練習1:  假設英雄在復活區，因此被敵方英雄攻擊時都能夠快速回血，(也就是回血速度遠大於減血速度)，請依此設計Hero線程
//	       (250時加血現成等待，等到hp!=250時繼續)
//	
//	效果:
//		Reaper 250 
//		Reaper 249 
//		Reaper 248
//		Reaper 250
//		Reaper 249
//		Reaper 250
//		.....快速跳動
	
//	練習2:
//		依照練習1，將加血線程增至2條，減血線程增至5條
	
	

}
