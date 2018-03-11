package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);

			System.out.println("正在監聽端口號: 8888");
			// 會抱持等待狀態直到有人連近來
			Socket s = ss.accept();

			System.out.println("有連接 " + s);
			s.close();
			ss.close();
		} catch (IOException e) {

		}
	}

}
