package lesson_02.database;

import lesson_01.homework01.Box;
import lesson_01.homework01.Fruit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// CRUD - create, read, update, delete
public class FruitRepository<T extends Box<? extends Fruit>> {

	public int create(T box) {
		Connection connection = ConnectionService.getConnection();
		int result = -1;
		try {
			connection.setAutoCommit(false);

			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO boxes (name, type, weight) VALUES (?, ?, ?)"
			);

			float weight = 0;
			if (box.getFruits().size() > 0) {
				weight = box.getFruits().get(0).getWeight() * box.getFruits().size();
			}

			statement.setString(1, "box2");
			statement.setInt(2, 2);
			statement.setFloat(3, weight);

			result = statement.executeUpdate();

			connection.commit();
			statement.close();
		} catch (SQLException e) {
			ConnectionService.rollback(connection);
			e.printStackTrace();
		}
		return result;
	}

	public List<Fruit> findAll() {
		List<Fruit> fruits = new ArrayList<>();
		Connection connection = ConnectionService.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT * FROM fruits WHERE name LIKE ?;"
			);

			statement.setString(1, "app%");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				fruits.add(
						new Fruit(
								rs.getInt(1),
								rs.getString("name")
						)
				);
			}

			statement.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fruits;
	}
}
