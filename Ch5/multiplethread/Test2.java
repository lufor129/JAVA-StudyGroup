package multiplethread;

public class Test2 {
	public static void main(String[] args) {
		
		
		Hero Reaper=new Hero("Reaper",250,50);
		Hero Mei=new Hero("Mei",250,30);
		Hero Ana=new Hero("Ana",200,40);
		Hero Bastion=new Hero("Bastion",300,80);

		// 這邊來講解線程的方法，注意!!!是線程的方法，不是物件的方法

		// 1.sleep()
		// 暫停 幾毫秒，會拋出中斷異常
//		Thread t1= new Thread(){
//            public void run(){
//                int seconds =0;
//                while(true){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    System.out.println("已經玩了OverWatch "+seconds++ +" 秒。");
//                }              
//            }
//        };
//        t1.start();
		
//		2.join()
//		加入到當前線程
//		
//		Thread t2=new Thread() {
//			public void run() {
//				while(!Bastion.isDead()) {
//					Mei.attackHero(Bastion);
//				}
//			}
//		};
		
//		t2.start();
//		代碼執行到這裡，一直是main執行緒在運行
		
//		try {
//			//t2執行緒加入到main執行緒中來，只有t2執行緒運行結束，才會繼續往下走
//			t2.join();
//		}catch(InterruptedException e) {}
//		
		
//		Thread t1=new Thread() {
//			public void run() {
//				while(!Ana.isDead()) 
//					Reaper.attackHero(Ana);
//			}
//		};
//		
//		t1.start();
		
		//會觀察到小美把壁壘殺掉後，才運行t2執行緒
		
		
//		 3. 優先及
//		 當執行緒處於競爭關係的時候，優先順序高的執行緒會有更大的幾率獲得CPU資源  1~10
//		Mei.damage=1;
//		Reaper.damage=1;
		
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
//		t1.setPriority(Thread.MAX_PRIORITY);
//		t2.setPriority(Thread.MIN_PRIORITY);
//		
//		t1.start();
//		t2.start();
		
		
//		練習:
//			天使大招需要充能，每五秒完一個大招，每次使用大招可以復活兩個人，使用完繼續充能
		
//		效果:
//			天使大招充能 開始
//			大招充了 1秒
//			大招充了 2秒
//			大招充了 3秒
//			大招充了 4秒
//			大招充了 5秒
//			大招充能完畢: 英雄不朽
//			復活一名隊友
//			復活兩名隊友
//			天使大招充能 開始
//			大招充了 1秒
//			大招充了 2秒
			

	}

}
