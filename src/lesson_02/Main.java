package lesson_02;

import lesson_01.homework01.Box;
import lesson_01.homework01.Orange;
import lesson_02.database.ConnectionService;
import lesson_02.database.FruitRepository;

import java.sql.Connection;

public class Main {
	public static void main(String[] args) {
		FruitRepository fruitRepository = new FruitRepository();
//		int row = fruitRepository.create(new Box<Orange>());
//		System.out.println(row);

		System.out.println(fruitRepository.findAll());

		ConnectionService.disconnect();
	}
}
