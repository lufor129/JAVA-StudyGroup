package swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		// swing是JAVA自帶的輕量級GUI，通常不必學的太深入

		// 主窗體
		JFrame f = new JFrame("OverWatch");

		// 主窗體大小(寬，高)
		f.setSize(400, 300);

		// 窗體設置位置(x,y)
		f.setLocation(200, 200);

		// 主窗口物件設定為絕對定位
		f.setLayout(null);

		// 按鈕物件
		JButton b = new JButton("just a botton");

		// 設定按鈕參數(x,y,寬,高)
		b.setBounds(50, 50, 200, 30);

		// 按鈕b放入f
		f.add(b);

		// 關閉窗口時退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 窗口可見
		f.setVisible(true);
	}

}
