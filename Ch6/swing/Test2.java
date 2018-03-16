package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test2 {
	public static void main(String[] args) {
		// 監聽，使用到awt(abstract window toolkit)
		// ActionLisener聽取ActionEvent
		JFrame f = new JFrame("OW");
		f.setSize(1000, 700);
		f.setLocation(580, 200);
		f.setLayout(null);

		final JLabel l = new JLabel();

		ImageIcon i = new ImageIcon("Ana.jpg");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

		JButton b = new JButton("隱藏圖片");
		b.setBounds(800, 200, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.setVisible(false);
			}
		});

		f.add(l);
		f.add(b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
