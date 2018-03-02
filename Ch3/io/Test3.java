package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;


import org.omg.Messaging.SyncScopeHelper;

public class Test3 {

	public static void main(String[] args) {

		/*-----------緩存流-------------*/
		// 以介質是硬碟為例，位元組流和字元流的弊端：
		// 在每一次讀寫的時候，都會訪問硬碟。 如果讀寫的頻率比較高的時候，其性能表現不佳。
		//
		// 為了解決以上弊端，採用緩存流。
		// 緩存流在讀取的時候，會一次性讀較多的資料到緩存中，以後每一次的讀取，都是在緩存中訪問，直到緩存中的資料讀取完畢，再到硬碟中區讀取。
		//
		// 就好比吃飯，不用緩存就是每吃一口都到鍋裡去鏟。用緩存就是先把飯盛到碗裡，碗裡的吃完了，再到鍋裡去鏟
		//
		// 緩存流在寫入資料的時候，會先把資料寫入到緩存區，直到緩存區達到一定的量，才把這些資料，一起寫入到硬碟中去。
		// 按照這種操作模式，就不會像位元組流，字元流那樣每寫一個位元組都訪問硬碟，從而減少了IO操作，提供較高效率。

		// 緩存字元輸入流 BufferedReader 可以一次讀取一行資料

		File f = new File("CCCP.txt");

		// 緩存流需要建立在一個存在的流上(節點流與處理流)
		try (
				FileReader fr = new FileReader(f);
//				防止數據被清空
				FileWriter fw = new FileWriter(f,true);
				BufferedReader br = new BufferedReader(fr);
//				BufferedWriter bw = new BufferedWriter(fw);
				) {
			while (true) {
				// 一次讀一行
				String line = br.readLine();
				if (null == line)
					break;
				System.out.println(line);
			}
//			bw.write("\n\n這個笑話不好笑!!");
		} catch (IOException e) {

		}
		/*----------對象流------------*/
//		物件流指的是可以直接把一個物件以流的形式傳輸給其他的介質，比如硬碟 
//
//		一個物件以流的形式進行傳輸，叫做序列化。 該物件所對應的類，必須是實現Serializable介面
		
		Hero tracer=new Hero("tracer",150);
		
		File f2=new File("Hero.txt");
		
//		對象流建立在字節流之上
//		try(
////			先建OUT再建IN因為OUT會把文件覆蓋
//			FileOutputStream fos=new FileOutputStream(f2);
//			ObjectOutputStream oos=new ObjectOutputStream(fos);
//			FileInputStream fis=new FileInputStream(f2);
//			ObjectInputStream ois=new ObjectInputStream(fis);
//				){
//			oos.writeObject(tracer);
//			Hero h2=(Hero)ois.readObject();
//			System.out.println(h2.name);
//			System.out.println(h2.hp);
//		}catch(IOException aa) {
//			
//		}catch(ClassNotFoundException e) {
//			
//		}
//		
//		多物件序列化
//		多物件時可以先建立集合，再把集合序列化
		
		ArrayList<Hero> al=new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			al.add(new Hero("Hero "+i));
		}
		
		try(
				FileOutputStream fos=new FileOutputStream(f2);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				FileInputStream fis=new FileInputStream(f2);
				ObjectInputStream ois=new ObjectInputStream(fis);
					){
			oos.writeObject(al);
			ArrayList al2=(ArrayList<Hero>)ois.readObject();
			for(int i=0;i<al2.size();i++) {
				Hero h=(Hero)al2.get(i);
				System.out.println(h.name);
			}
			
		}catch(IOException a) {
			
		}catch(ClassNotFoundException e) {
			
		}
		
	}

}
