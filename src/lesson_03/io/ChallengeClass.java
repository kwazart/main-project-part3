package lesson_03.io;

import com.mysql.cj.util.StringUtils;

import java.io.*;

public class ChallengeClass {
	public static void main(String[] args) {
//		File file = new File("src/lesson_03/io/lorem.txt");
//
//		long start = System.currentTimeMillis();
//		int read = readFisWithoutBuffer(file);
//		long finish = System.currentTimeMillis();
//		System.out.println("Не используя буфер, прочитано: " + read + " за " + (finish - start) + " мс");
//
//		start = System.currentTimeMillis();
//		read = readFisWithBuffer(file);
//		finish = System.currentTimeMillis();
//		System.out.println("Используя буфер, прочитано: " + read + " за " + (finish - start) + " мс");
//
//		start = System.currentTimeMillis();
//		read = readFisWithBufferedStream(file);
//		finish = System.currentTimeMillis();
//		System.out.println("Используя BufferedStream, прочитано: " + read + " за " + (finish - start) + " мс");
//
//		start = System.currentTimeMillis();
//		read = readFisWithBufferedReader(file);
//		finish = System.currentTimeMillis();
//		System.out.println("Используя BufferedReader, прочитано: " + read + " за " + (finish - start) + " мс");

		writeWithBufferedWriter("some line");
	}

	private static int readFisWithoutBuffer(File file) {
		StringBuilder sb = new StringBuilder();
		try (FileInputStream fis = new FileInputStream(file)){
			int b;
			while ((b = fis.read()) != -1) {
				sb.append((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.length();
	}

	private static int readFisWithBuffer(File file) {
		StringBuilder sb = new StringBuilder();
		byte[] buffer = new byte[8 * 1024];

		try (FileInputStream fis = new FileInputStream(file)) {
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				sb.append(StringUtils.toString(buffer));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.length();
	}

	private static int readFisWithBufferedStream(File file) {
		StringBuilder sb = new StringBuilder();
		try (FileInputStream fis = new FileInputStream(file)) {
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c;
			while ((c = bis.read()) != -1) {
				sb.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.length();
	}

	private static int readFisWithBufferedReader(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.length();
	}

	public static void writeWithBufferedWriter(String value) {
		File file = new File("src/lesson_03/io/test2.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
			bw.write("START LINE");
			bw.newLine();
			bw.write(value);
			bw.newLine();
			bw.write("END LINE");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
