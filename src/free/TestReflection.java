package free;

public class TestReflection {
	public static void main(String[] args) throws InterruptedException{
		Thread t1=new Thread() {
			public void run() {
				TestReflection.method1();
			}
		};
		t1.setName("第一個線程");
		t1.start();
		
		Thread t2=new Thread() {
			public void run() {
				TestReflection.method2();
			}
		};
		t2.setName("第二個線程");
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("要第一個執行完才會執行第二個線程");
	}
	
	public static void method1() {
		synchronized(TestReflection.class) {
//			對method1來說同步對象是TestReflection類對象
//			印出當前對象名稱
			System.out.println(Thread.currentThread().getName());
			try {
				System.out.println("執行五秒");
				Thread.sleep(5000);
			}catch(InterruptedException e) {
				
			}
		}
	}
	
	public static synchronized void method2() {
//		和method1同樣的效果，用TestReflection作為同步對象
		System.out.println(Thread.currentThread().getName());
		try {
			System.out.println("執行五秒");
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			
		}
	}
}
