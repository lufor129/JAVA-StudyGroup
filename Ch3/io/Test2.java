package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) {

		// 什麼是流(Stream)，流就是一系列的資料
		// 當不同的介質之間有資料交互的時候，JAVA就使用流來實現。
		// 資料來源可以是檔，還可以是資料庫，網路甚至是其他的程式
		//
		// 比如讀取檔的資料到程式中，站在程式的角度來看，就叫做輸入流

		// 字節流與字符流 (台灣: 位元組流與字元 byte/character)
		
		// 1.位元組流
		// InputStream位元組輸入流
		// OutputStream位元組輸出流
		// 用於以位元組的形式讀取和寫入資料

		// InputStream是位元組輸入流，同時也是抽象類別，只提供方法聲明，不提供方法的具體實現。
		// FileInputStream 是InputStream子類，以FileInputStream 為例進行檔讀取

		File f1 = new File("C:\\Users\\PC-Henry\\eclipse-workspace\\Ch3\\OverWatch.txt");
		
		/*
		 *重要!!建立輸出流時會自動把文件清空
		 */
		// 自動關掉
		try /* (FileOutputStream fos = new FileOutputStream(f1)) */ {
			// 準備文件，內容是AB(ASCII 中是65 66)
			File f = new File("OverWatch.txt");
			// 建立位元組流在File上
			FileInputStream fis = new FileInputStream(f);

			byte[] data = { 88, 89 };
			byte[] study = new byte[(int) f.length()];
			// 讀取
			fis.read(study);
			// 寫入
			// fos.write(data);

			for (byte b : study) {
				System.out.println(b);
			}

			// 用完後要關掉
			fis.close();

		} catch (IOException e) {
		}

		// 注意的是FileOutputStream一旦打開會覆蓋所有資料，就算沒有write也依樣
		// 關掉流可以在 try()中，try內，finally關掉

		/*----------字符流(字元流)------------------*/

		// Reader字元輸入流
		// Writer字元輸出流
		// 專門用於字元的形式讀取和寫入資料

		// FileReader 是Reader子類，以FileReader 為例進行檔讀取
//		
//		File f2=new File("OW.txt");
//		try (FileReader fr=new FileReader(f2)){
//			
//			char[] r=new char[(int)f2.length()];
//			fr.read(r);
//			System.out.print(r);
//		}catch(IOException e) {}
//		
	}
}
