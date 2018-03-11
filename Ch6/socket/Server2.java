package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	// 一旦建立了連接就可以開始通信了
	// 客戶端打開輸出流，伺服端打開輸入流
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(8888);
			
			Socket s=ss.accept();
			InputStream is=s.getInputStream();
			
			int message=is.read();
			System.out.println(message);
			is.close();
			ss.close();
		}catch(IOException e) {
			
		}
	}

}
