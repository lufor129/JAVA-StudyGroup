package gui.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.panel.SpendPanel;

public class MainFrame {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setSize(500,450);
		f.setTitle("一本糊塗帳");
		f.setLocationRelativeTo(null);
		f.setVisible(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar tb=new JToolBar();
		JButton bSpend = new JButton("消費一覽");
        JButton bRecord = new JButton("記一筆");
        JButton bCategory = new JButton("消費分類");
        JButton bReport = new JButton("月消費報表");
        JButton bConfig = new JButton("設置");
        JButton bBackup = new JButton("備份");
        JButton bRecover = new JButton("恢復數據");
 
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        f.setLayout(new BorderLayout());
        f.add(tb,BorderLayout.NORTH);
        f.add(new JPanel(), BorderLayout.CENTER);
        
        f.setVisible(true);
        
        SpendPanel sppanel=SpendPanel.getSpendPanel();
        
        
        bSpend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sppanel.vMonthSpend.setText("3333");
        	}
        });
        bRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bConfig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bBackup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bRecover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
       
	}

}
