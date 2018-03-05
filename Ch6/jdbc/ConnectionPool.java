package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	// 當有多個執行緒，每個執行緒都需要連接資料庫執行SQL語句的話，那麼每個執行緒都會創建一個連接，並且在使用完畢後，關閉連接。
	// 創建連接和關閉連接的過程也是比較消耗時間的，當多執行緒併發的時候，系統就會變得很卡頓。
	// 同時，一個資料庫同時支援的連接總數也是有限的，如果多執行緒併發量很大，那麼資料庫連接的總數就會被消耗光，後續執行緒發起的資料庫連接就會失敗。
	//
	// 與傳統方式不同，連接池在使用之前，就會創建好一定數量的連接。
	// 如果有任何執行緒需要使用連接，那麼就從連接池裡面借用，而不是自己重新創建.
	// 使用完畢後，又把這個連接歸還給連接池供下一次或者其他執行緒使用。
	// 倘若發生多執行緒併發情況，連接池裡的連接被借用光了，那麼其他執行緒就會臨時 等待，直到有連接被 !歸還! 回來，再繼續使用。
	// 整個過程，這些連接都不會被關閉，而是不斷的被迴圈使用，從而節約了啟動和關閉連接的時間。

	// 初始化:
	// 1. ConnectionPool() 構造方法約定了這個連接池一共有多少連接
	// 2. 在init() 初始化方法中，創建了size條連接。
	// 注意，這裡不能使用try-with-resource這種自動關閉連接的方式，因為連接恰恰需要保持不關閉狀態，供後續迴圈使用
	// 3. getConnection， 判斷是否為空，如果是空的就wait等待，否則就借用一條連接出去
	// 4. returnConnection，
	// 在使用完畢後，歸還這個連接到連接池，並且在歸還完畢後，調用notifyAll，通知那些等待的執行緒，有新的連接可以借用了。

	List<Connection> cd = new ArrayList<>();

	int size;

	public ConnectionPool(int size) {
		this.size = size;
		init();
	}

	public void init() {
		try {
			// 這裡恰恰不能使用try-with-resource的方式，因為這些連接都需要是"活"的，不要被自動關閉了
			Class.forName("com.mysql.jdbc.Driver");

			for (int i = 0; i < size; i++) {
				Connection c = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				cd.add(c);
			}

		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	}

	public synchronized Connection getConnection() {
		// 是空的，等待
		while (cd.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		// 不是空的，取出來
		Connection c = cd.remove(0);
		return c;
	}

	public synchronized void returnConnection(Connection c) {
		cd.add(c);
		this.notifyAll();
	}

}
