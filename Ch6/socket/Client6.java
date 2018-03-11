package socket;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class Client6 {
	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8888);
			new SendThread(s).start();
			new RecieveThread(s).start();
		}catch(IOException e) {
			
		}
	}
}
