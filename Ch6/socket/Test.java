package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws UnknownHostException,IOException {
		// 獲得本機IP地址
		InetAddress host = InetAddress.getLocalHost();
		System.out.println(host.getHostAddress());

		// 使用Runtime.getRuntime().exec()可以運行一個Windows的exe程序
		// 用這個來運行ping
		
		Process p=Runtime.getRuntime().exec("ping "+"140.127.220.26");
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream(),("Big5")));
		String line=null;
		StringBuilder sb=new StringBuilder();
		while((line=br.readLine())!=null) {
			if(line.length()!=0)
				sb.append(line+"\r\n");
		}
		
		System.out.println(sb.toString());
	}
}
