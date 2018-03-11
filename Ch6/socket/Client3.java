package socket;

import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.net.UnknownHostException;

public class Client3 {
	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8888);
			
			System.out.println("請輸入字串 !!");
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			Scanner sc=new Scanner(System.in);
			String str=sc.next();
			dos.writeUTF(str);
			
			dos.close();
			s.close();
		}catch(UnknownHostException e) {
			
		}catch(IOException e) {
			
		}
	}
}
