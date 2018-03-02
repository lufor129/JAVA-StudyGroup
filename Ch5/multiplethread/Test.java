package multiplethread;

public class Test {
	public static void main(String[] args) {
		
//		鬥陣是6vs6的遊戲，因此會同時有兩個以上的英雄發動攻擊
		Hero Reaper=new Hero("Reaper",250,50);
		Hero Mei=new Hero("Mei",250,30);
		Hero Ana=new Hero("Ana",200,40);
		Hero Bastion=new Hero("Bastion",300,80);
		
//		不使用多線程
//		while(!Ana.isDead()) {
//			Reaper.attackHero(Ana);
//		}
//		
//		while(!Bastion.isDead()) {
//			Mei.attackHero(Bastion);
//		}
		
//		正式進入多線程，多線程的建構只有兩種，但我多教一種好用的延伸
//		1.extends Thread
//		2.implements Runnable
//		3.匿名類
		
//		1.
//		ExtendsThread et1=new ExtendsThread(Reaper, Ana);
//		et1.start();
//		ExtendsThread et2=new ExtendsThread(Mei, Bastion);
//		et2.start();
		
//		2.
//		ImplementsThread實現了 Runnable的接口，所以有run 方法，但沒有啟動run 的start方法
//		start 方法在 Thread 中，若沒有繼承Thread 是沒有start() 的
//		所以望見Thread對象的時候，把Runnable接口傳入作為建構，才能起動線程
		
//		ImplementsThread it1=new ImplementsThread(Reaper,Ana);
//		new Thread(it1).start();
//		ImplementsThread it2=new ImplementsThread(Mei, Bastion);
//		new Thread(it2).start();
		
		
//		3.
//		匿名類直接繼承並重寫Thread
		
//		Thread t1=new Thread() {
//			public void run() {
//				while(!Ana.isDead()) 
//					Reaper.attackHero(Ana);
//			}
//		};
//		
//		Thread t2=new Thread() {
//			public void run() {
//				while(!Bastion.isDead()) {
//					Mei.attackHero(Bastion);
//				}
//			}
//		};
//		
//		t1.start();
//		t2.start();
		
	}
}
