package csModel;

public class ProducerThread extends Thread{
	private MyStack<Character> stack;
	
	public ProducerThread(MyStack<Character> stack,String name) {
		super(name);
		this.stack=stack;
	}
	
	public void run() {
		while(true) {
			char c=randomChar();
			stack.push(c);
			System.out.println(this.getName() + " 投入 "+c);		
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {}
		}
	}
	
	public char randomChar() {
		return (char) (Math.random()*('Z'+1-'A')+'A');
	}

}
