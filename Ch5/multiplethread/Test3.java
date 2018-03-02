package multiplethread;

public class Test3 {
	public static void main(String[] args) {
		
		Hero Reaper=new Hero("Reaper",250,50);
		Hero Mei=new Hero("Mei",10000,30);
		Hero Ana=new Hero("Ana",200,40);
		Hero Bastion=new Hero("Bastion",300,80);
		
//		線程同步問題是指多個線程同時修改一個數據時發生的問題
//		假設小美有10000滴血，天使一邊治療，小美一邊被多個英雄攻擊
		
//		也就是說，有多個線程加小美的血，同時也有多個線程扣小美的血
		
//		線程儲存在Array中
		int n=10000;
		Thread addThread[]=new Thread[n];
		Thread reduceThread[]=new Thread[n];
		
//		加血線程儲存進去
		for (int i = 0; i < 10000; i++) {
			Thread t = new Thread() {
				public void run() {
					Mei.heal();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			};
			t.start();
			addThread[i]=t;
		}
		
//		損血
		for (int i = 0; i < 10000; i++) {
			Thread t = new Thread() {
				public void run() {
					Mei.hurt();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			};
			t.start();
			reduceThread[i]=t;
		}
		
//		等待所有線程跑完後主再繼續
		for (Thread t : addThread) {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}

		for (Thread t : reduceThread) {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
		
		//多按幾次，會出現10000以外的數字 (看CPU)
		System.out.println(Mei.hp);
		
//		1. 假設增加執行緒先進入，得到的hp是10000 
//		2. 進行增加運算 
//		3. 正在做增加運算的時候，還沒有來得及修改hp的值，減少執行緒來了 
//		4. 減少執行緒得到的hp的值也是10000 
//		5. 減少執行緒進行減少運算 
//		6. 增加執行緒運算結束，得到值10001，並把這個值賦予hp 
//		7. 減少執行緒也運算結束，得到值9999，並把這個值賦予hp 
//		hp，最後的值就是9999 
//		雖然經歷了兩個執行緒各自增減了一次，本來期望還是原值10000，但是卻得到了一個9999 
//		這個時候的值9999是一個錯誤的值，在業務上又叫做髒資料
		
		
//		總體解決思路是： 在增加執行緒訪問hp期間，其他執行緒不可以訪問hp 
//		1. 增加執行緒獲取到hp的值，並進行運算 
//		2. 在運算期間，減少執行緒試圖來獲取hp的值，但是不被允許 
//		3. 增加執行緒運算結束，並成功修改hp的值為10001 
//		4. 減少執行緒，在增加執行緒做完後，才能訪問hp的值，即10001 
//		5. 減少執行緒運算，並得到新的值10000
		
		/*-------------synchronized-------------*/
//		synchronized 代表當前線程，透過獨佔對象(甚麼對象都行)，有點像搶麥克風，搶到麥克風的才能發言
//		
//		用法:
//		Object someObject =new Object();
//		synchronized(someObject) {
//			內容
//		}
//		當前執行緒獨佔 了物件someObject，如果有其他執行緒試圖佔有物件someObject，就會等待，直到當前執行緒釋放對someObject的佔用。
//		someObject 又叫同步物件，所有的物件，都可以作為同步物件
//		為了達到同步的效果，必須使用同一個同步物件
//		
//		釋放同步物件的方式： synchronized 塊自然結束，或者有異常拋出
		
//		synchronized 的使用可以是搶麥克風，也可以是加在方法上
		
		/*--------------同步死索-------------*/
		
//		1. 執行緒1 首先佔有物件1，接著試圖佔有物件2
//		2. 執行緒2 首先佔有物件2，接著試圖佔有物件1
//		3. 執行緒1 等待中的執行緒2釋放對象2
//		4. 與此同時，執行緒2等待中的執行緒1釋放對象1
		
//		Thread t1=new Thread() {
//			public void run() {
//				synchronized (Reaper) {
//					System.out.println("已獲取 "+Reaper.name);
//					try {
////						讓其他線程有時間進行
//						Thread.sleep(1000);
//					}catch(InterruptedException e) {}
//					
//					synchronized (Bastion) {
//						System.out.println("試圖要 " +Bastion.name);
//					}
//				}
//			}
//		};
//		t1.start();
//		
//		Thread t2=new Thread() {
//			public void run() {
//				synchronized (Bastion) {
//					System.out.println("已獲取 "+Bastion.name);
//					try {
////						讓其他線程有時間進行
//						Thread.sleep(1000);
//					}catch(InterruptedException e) {}
//					
//					synchronized (Reaper) {
//						System.out.println("試圖要 " +Reaper.name);
//					}
//				}
//			}
//		};
//		t2.start();
		
		
//		練習: 
//		讓t1,t2,t3彼此死鎖
//		同步對象分別為 a,b,c

	}
}
