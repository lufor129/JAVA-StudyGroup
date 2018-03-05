package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionPool {
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPool(3);
		// 創建100個現成
		for (int i = 0; i < 100; i++) {
			new WorkingThread("working thread" + i, cp).start();
		}
	}
}

class WorkingThread extends Thread {
	private ConnectionPool cp;

	public WorkingThread(String name, ConnectionPool cp) {
		super(name);
		this.cp = cp;
	}

	public void run() {
		// 取出鏈接，並根據鏈結創建statement
		Connection c = cp.getConnection();
		System.out.println(this.getName() + ":\t 獲取了一條連接");
		try (Statement s = c.createStatement();) {
			Thread.sleep(1000);
			s.execute("select * from hero");
		} catch (SQLException | InterruptedException e) {
		}
		// 歸還鏈結
		cp.returnConnection(c);
	}

}
