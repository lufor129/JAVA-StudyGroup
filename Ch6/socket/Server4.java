package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server4 {
	public static void main(String[] args) {
		try {
//			1.	next()一定要讀取到有效字元後才可以結束輸入，對輸入有效字元之前遇到的空白鍵、Tab鍵或Enter鍵等結束符，next()方法會自動將其去掉，只有在輸入有效字元之後，next()方法才將其後輸入的空白鍵、Tab鍵或Enter鍵等視為分隔符號或結束符。
//			2.	 簡單地說，next()查找並返回來自此掃描器的下一個完整標記。完整標記的前後是與分隔模式匹配的輸入資訊，所以next方法不能得到帶空格的字串。
//			3.	nextLine()方法的結束符只是Enter鍵，即nextLine()方法返回的是Enter鍵之前的所有字元，它是可以得到帶空格的字串的。

			ServerSocket ss=new ServerSocket(8888);
			Socket s=ss.accept();
			
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			
			while(true) {
				String meg=dis.readUTF();
				System.out.println("收到客戶端\n"+meg);
				Scanner sc=new Scanner(System.in);
				String str=sc.next();
				dos.writeUTF(str);
			}
			
		}catch(IOException e) {
			
		}
	}

}
