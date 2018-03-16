package gui.panel;

import javax.swing.JLabel;

public class SpendPanel {

	public JLabel lMonthSpend = new JLabel("本日消費");
	public JLabel lTodaySpend = new JLabel("今日消費");
	public JLabel lAvgSpendPerDay = new JLabel("日均消費");
	public JLabel lMonthLeft = new JLabel("本月剩餘");
	public JLabel lDayAvgAvailable = new JLabel("日均可用");
	public JLabel lMonthLeftDay = new JLabel("距離月末");

	public JLabel vMonthSpend = new JLabel("￥2300");
	public JLabel vTodaySpend = new JLabel("￥25");
	public JLabel vAvgSpendPerDay = new JLabel("￥120");
	public JLabel vMonthAvailable = new JLabel("￥2084");
	public JLabel vDayAvgAvailable = new JLabel("￥389");
	public JLabel vMonthLeftDay = new JLabel("15天");

	// 單例模式
	private SpendPanel() {
		
	}
	
	private static SpendPanel sppenal=new SpendPanel();
	
	public static SpendPanel getSpendPanel() {
		return sppenal;
	}
}
