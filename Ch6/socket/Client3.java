package socket;

import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.net.UnknownHostException;

public class Client3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Socket s=new Socket("127.0.0.1",8888);
			
			System.out.println("請輸入字串 !!");
			String message=sc.nextLine();
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF(message);
			
			dos.close();
			os.close();
			s.close();
		}catch(UnknownHostException e) {
			
		}catch(IOException e) {
			
		}
	}
}
