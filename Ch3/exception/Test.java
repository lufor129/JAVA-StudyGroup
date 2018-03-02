package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) {

		// 所謂的異常:
		// 就是導致程式的正常流程被中斷的事件，可能有很多原因

		// 異常分： 可查異常，運行時異常和錯誤3種
		// 其中，運行時異常和錯誤又叫非可查異常
		// 可查異常即必須進行處理的異常，要麼try catch住,要麼往外拋，誰調用，誰處理，比如 FileNotFoundException
		// 如果不處理，編譯器，就不讓你通過(因此很好察覺)

		// 錯誤:指系統級別錯誤，通長是內存用光了 OutOfMemoryError，這邊不會學

		// 異常處理: try catch finally throws

		// 例子
		// 1.將可能拋出FileNotFoundException 檔不存在異常的代碼放在try裡
		// 2.如果檔存在，就會順序往下執行，並且不執行catch塊中的代碼
		// 3.如果檔不存在，try 裡的代碼會立即終止，程式流程會運行到對應的catch塊中
		// 4.e.printStackTrace();
		// 會列印出方法的調用痕跡，如此例，會列印出異常開始於TestException的第16行，這樣就便於定位和分析到底哪裡出了異常
		// (通常我是不打啦~)

		File f = new File("OW.txt");
		//
		// try {
		// System.out.println("試圖打開");
		// new FileInputStream(f);
		// System.out.println("success");
		// }catch(FileNotFoundException e) {
		// System.out.println("fail");
		// e.printStackTrace();
		// }finally {
		// System.out.println("finally 是無論有沒有出現異常都會執行的");
		// }
		//
		// 父類可以捕捉子類的異常，也就是你也可以改成
		// catch(Excepiton e) {}

		// 同時多個異常捕捉
		// 1.直接加 catch
		// try {
		//
		// }catch(FileNotFoundExcepiton e) {}
		// catch(PhraseException e ) {}

		// 2.統一放在catch
		// try {
		//
		// }catch(FileNotFoundException | PharseExcepiton e) {}

		// throws
		// throw 和 throws 會把異常拋給最近的那個人處理

		Test.method1();
		
//		throws與throw這兩個關鍵字接近，不過意義不一樣，有如下區別：
//		1. throws 出現在方法聲明上，而throw通常都出現在方法體內。
//		2. throws 表示出現異常的一種可能性，並不一定會發生這些異常；
//		throw則是拋出了異常，執行throw則一定拋出了某個異常物件


	}

	private static void method1() {
		try {
			method2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		method2();
	}

	private static void method2() throws FileNotFoundException {

		File f = new File("OW.txt");

		System.out.println("試圖打開 OW.txt");
		
//		要是不存在則拋出
		if(!f.exists()) {
			throw new FileNotFoundException();
		}
		
		// 錯誤拋給method1處理
		new FileInputStream(f);
		System.out.println("成功打開");

	}

}
