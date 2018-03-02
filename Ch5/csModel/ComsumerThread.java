package csModel;

public class ComsumerThread extends Thread{
	private MyStack<Character> stack;
	
	public ComsumerThread(MyStack<Character> stack,String name) {
		super(name);
		this.stack=stack;
	}
	
	public char randomChar() {
		return (char) (Math.random()*('Z'+1-'A')+'A');
	}
	
	public void run() {
		while(true) {
			char c=stack.Pull();
			System.out.println(this.getName()+" 彈出  "+c);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {}
		}
	}
}
