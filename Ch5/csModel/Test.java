package csModel;

public class Test {
	public static void main(String[] args) {
		
//		生產者消費者問題是一個非常典型性的執行緒交互的問題。
//
//		1. 使用棧來存放資料
//		1.1 把棧改造為支持執行緒安全
//		1.2 把棧的邊界操作進行處理，當棧裡的資料是0的時候，訪問pull的執行緒就會等待。
//		         當棧裡的資料時10的時候，訪問push的執行緒就會等待
//		2. 提供一個生產者（Producer）執行緒類，生產隨機大寫字元壓入到堆疊
//		3. 提供一個消費者（Consumer）執行緒類，從堆疊中彈出字元並列印到控制台
//		4. 提供一個測試類，使兩個生產者和三個消費者執行緒同時運行

		MyStack<Character> stack=new MyStack<>();
		new ProducerThread(stack, "Producer 1").start();
		new ProducerThread(stack, "Producer 2").start();
		new ProducerThread(stack, "Producer 3").start();
		new ComsumerThread(stack, "Consumer 1").start();
		new ComsumerThread(stack, "Comsumer 2").start();
		
//		問題1: 為何MyStack 的pull &push 已經線程安全了，但出來結果卻不是線程安全? 如何解決?
		
	}

}
