package lesson_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
	private static Connection connection;

	private ConnectionService () {

	}

	public static Connection getConnection () {
		if(connection != null) {
			return connection;
		} else {
			try {
				// Class.forName("")
				connection = DriverManager.getConnection("jdbc.:mysql://localhost:3306/warehouse", "admin", "Admin!@#");
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return connection;
	}

	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
