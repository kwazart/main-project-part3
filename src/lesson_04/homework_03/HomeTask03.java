package lesson_04.homework_03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomeTask03 {
	public static void main(String[] args) {
//		readLastLines(3);
		readLastLinesRAF(3);
	}

	private static void readLastLines(int n) {
		File file = new File("src/lesson_04/homework_03/test");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			List<String> lines = new ArrayList<>();
			String line;

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			for (int i = lines.size() - 1; i > lines.size() - n - 1 ; i--) {
				System.out.println(lines.get(i));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readLastLinesRAF(int n) {
		File file = new File("src/lesson_04/homework_03/test");
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "r");

			long length = file.length() - 1;
			int readLines = 0;
			StringBuilder sb = new StringBuilder();

			for (long i = length; i >= 0; i--) {
				raf.seek(i);
				char c = (char) raf.read();

				if (c == '\n') {
					readLines++;
					if (readLines == n) {
						break;
					}
				}

				sb.append(c);
			}

			System.out.println(sb.reverse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
