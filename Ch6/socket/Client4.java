package socket;

import java.io.IOException;
import java.net.UnknownHostException;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Client4 {
	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8888);
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			InputStream is=s.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			
			while(true) {
				Scanner sc=new Scanner(System.in);
				String str=sc.next();
				dos.writeUTF(str);
				String message=dis.readUTF();
				System.out.println("收到伺服器訊息 \n"+message);
			}
		}catch(UnknownHostException e) {
			
		}catch(IOException e){
			
		}
	}

}
