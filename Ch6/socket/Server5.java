package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Server5 {
	private static List<String> CannotUnderstand = new ArrayList<String>();
	static {
		CannotUnderstand.add("聽不懂!!");
		CannotUnderstand.add("說人話");
		CannotUnderstand.add("大聲點");
		CannotUnderstand.add("老子再忙，一邊玩去");
		CannotUnderstand.add("再說一遍?");
	}

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("監聽端口號 8888中");
			Socket s = ss.accept();

			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			while (true) {
				String message = dis.readUTF();
				System.out.println(message);

				// 好聰明的寫法
				List<Dictionary> ds = new DictionaryDAO().query(message);
				String response = null;
				if (ds.isEmpty()) {
					Collections.shuffle(CannotUnderstand);
					response = CannotUnderstand.get(0);
				} else {
					Collections.shuffle(ds);
					response = ds.get(0).response;
				}
				dos.writeUTF(response);
			}
		} catch (IOException e) {

		}

	}

}
