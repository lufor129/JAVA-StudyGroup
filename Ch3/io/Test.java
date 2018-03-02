package io;

import java.io.File;
import java.util.Date;

public class Test {
	public static void main(String[] args) {

		File f = new File("OverWatch.txt");
		System.out.println(f.exists());

		// io是一個...要背的東西，可能是你們這學期會接觸到的最龐大的東西
		// 包含了io，字節、字符、UniCode、轉碼、加密、解密、密碼學
		// 更加深入可以去資工系選修，但需要預先知識 離散數學、線性代數

		// 對想更精進的同學 參考文獻: JAVA-IO硬骨頭也能變軟
		// 已私訊作者獲得授權做教學用

		// 輸入輸出是基於文件，(輸入從文件讀取，輸出寫入到文件中)
		// 而File 對象有三種建立方式(是File對象，不是真的建了一個文件)

		// 1.相對位置
		File f1 = new File("OverWatch.txt");
		System.out.println(f1.getAbsolutePath());
		System.out.println(f1.exists());
		// 2.絕對位置
		File f2 = new File("C:/Users/PC-Henry/eclipse-workplace/JAVA-School/Ch3/OverWatch.txt");
		System.out.println(f2.getAbsolutePath());
		System.out.println(f2.exists());
		// 3.以f1作為父目錄底下建立
		File f3 = new File(f1, "OW.txt");
		System.out.println(f3.getAbsolutePath());
		System.out.println(f3.exists());

		/*------ 文件常用方法--------------------*/
		// 看看參考參考就好

		System.out.println("當前文件是：" + f);

		// 檔是否存在
		System.out.println("判斷是否存在：" + f.exists());

		// 是否是資料夾
		System.out.println("判斷是否是資料夾：" + f.isDirectory());

		// 是否是檔（非資料夾）
		System.out.println("判斷是否是檔：" + f.isFile());

		// 文件長度
		System.out.println("獲取文件的長度：" + f.length());

		// 檔最後修改時間
		long time = f.lastModified();
		Date d = new Date(time);
		System.out.println("獲取檔的最後修改時間：" + d);
		// 設置檔修改時間為1970.1.1 08:00:00(每秒+1)
		f.setLastModified(0);

		// 檔重命名
		File f4 = new File("OW.txt");
		f.renameTo(f4);
		System.out.println("把OverWatch.txt改名成了OW.txt");

		System.out.println("注意： 需要確實存在一個OverWatch.txt,\r\n才可以看到對應的檔長度、修改時間等資訊");

		// 以字串陣列的形式，返回當前資料夾下的所有檔（不包含子檔及子資料夾）
		f.list();

		// 以檔陣列的形式，返回當前資料夾下的所有檔（不包含子檔及子資料夾）
		File[] fs = f.listFiles();

		// 以字串形式返回獲取所在資料夾
		f.getParent();

		// 以檔形式返回獲取所在資料夾
		f.getParentFile();

		// 創建資料夾，如果父資料夾Ch3不存在，創建就無效
		f.mkdir();

		// 創建資料夾，如果父資料夾Ch3不存在，就會創建父資料夾
		f.mkdirs();

		// 創建一個空檔,如果父資料夾Ch3不存在，就會拋出異常
		// f.createNewFile();

		// 所以創建一個空檔之前，通常都會創建父目錄
		f.getParentFile().mkdirs();

		// 列出所有的盤符c: d: e: 等等
		f.listRoots();

		// 刪除文件
		f.delete();

		// JVM結束的時候，刪除檔，常用於暫存檔案的刪除
		f.deleteOnExit();

	}
}
