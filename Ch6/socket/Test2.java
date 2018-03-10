package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		// 判斷本網段有多少IP可用
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		String ipRrange = ip.substring(0, ip.lastIndexOf('.'));
		System.out.println("本機地址為: " + ip);
		System.out.println("本網段為: " + ipRrange);

		List<String> ips = Collections.synchronizedList(new ArrayList<>());
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		AtomicInteger number = new AtomicInteger();
		for (int i = 0; i < 255; i++) {
			String testIP = ipRrange + "." + (i + 1);
			threadPool.execute(new Runnable() {
				public void run() {
					boolean reachable = isReachable(testIP);
					if (reachable) {
						System.out.println("找到可連接  " + testIP);
						ips.add(testIP);

						synchronized (number) {
							System.out.println("已完成: " + number.incrementAndGet());
						}
					}else {
						System.out.println(testIP+" 不可連接");
					}
				}
			});
		}
		threadPool.shutdown();
		if (threadPool.awaitTermination(1, TimeUnit.HOURS)) {
			System.out.println("如下的ip可以連接");
			for (String theip : ips) {
				System.out.println(theip);
			}
			System.out.println("共有" + ips.size() + " 個地址");
		}
	}

	private static boolean isReachable(String ip) {
		try {
			boolean reachable=false;
			
			Process p=Runtime.getRuntime().exec("ping -n 1 "+ip);
			BufferedReader br =new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line=null;
			StringBuilder sb=new StringBuilder();
			while((line=br.readLine())!=null) {
				if(line.length()!=0)
					sb.append(line+"\r\n");
			}
			
			reachable =sb.toString().contains("TTL");
			br.close();
			return reachable;
		}catch(IOException e) {
			return false;
		}

	}
}
