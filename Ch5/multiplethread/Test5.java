package multiplethread;

public class Test5 {
	public static void main(String[] args) {
		
//		線程池期末考必考阿!!!!
//		大家背也要把它背下來!!!!
		
		ThreadPool TP = new ThreadPool();

		// 等待所有線程打開
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		// 給5個任務
		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				public void run() {
					System.out.println("Hello world");
					// 這裡可以是各種任務
					// 打印文件
					// 讀取資料
					// 做排序
					// 用Helloworld 做例子
				}
			};

			// 添加任務，每秒添加一個
			TP.add(task);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

		// 測試:
		// 測試內容，給予任務的速度不斷加快，以此來展示效果

//		int sleeptime = 1000;
//
//		while (true) {
//			TP.add(new Runnable() {
//				public void run() {
//					// 所要執行的任務
//					try {
//						// 線程每完成一個任務需要1秒鐘
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//					}
//				}
//			});
//			// 送任務間次不斷減小
//			try {
//				Thread.sleep(sleeptime);
//				if (sleeptime > 0) {
//					sleeptime -= 50;
//				}
//			} catch (InterruptedException e) {
//			}
//		}
		
//		謝謝大家，祝大家All pass
	}

}
