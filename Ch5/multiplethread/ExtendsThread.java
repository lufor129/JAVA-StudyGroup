package multiplethread;

public class ExtendsThread extends Thread{
	
//	繼承Thread，並重寫run方法
//	啟動： 實例化，並調用其start方法
	
	private Hero h1;
	private Hero h2;
	
	public ExtendsThread(Hero h1,Hero h2) {
		this.h1=h1;
		this.h2=h2;
	}
	
	//Override
	public void run() {
		while(!h2.isDead()) {
			h1.attackHero(h2);
		}
	}

}
