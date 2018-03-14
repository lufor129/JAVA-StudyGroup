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
	}
	
}
