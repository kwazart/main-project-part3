package lesson_02.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionService {

	private static Connection connection;

	private ConnectionService() {
	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				//		Class.forName("")
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/warehouse", "admin", "Admin!@#");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
