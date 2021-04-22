package lesson_03.io;

import java.io.*;

public class Main {
	public static void main(String[] args) {
//		doByteArrayStreamDemo();
		doDataStreamDemo();
	}

	static void doDataStreamDemo() {
		File file = new File("src/lesson_03/io/test.txt");
		doDataOutPutStream(file, "Hello!"); // write
		doDataInputStream(file); // read
	}

	private static void doDataOutPutStream(File file, String value) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file, true))) {
			dos.writeUTF(value);
			dos.writeInt(1234);
			dos.writeDouble(1.86);
			dos.writeBoolean(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void doDataInputStream(File file) {
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
			System.out.println(dis.readUTF());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	// НАЧИНАЕМ ТУТ
	public static void doByteArrayStreamDemo() {
		byte[] bytes = doByteArrayOutputStreamDemo("Hello-hello!");
		doByteArrayInputStreamDemo(bytes);
	}

	static void doByteArrayInputStreamDemo(byte[] bytes) {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
			int b;
			while ((b = bais.read()) != -1) {
				System.out.print((char) b + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static byte[] doByteArrayOutputStreamDemo(String value) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			baos.write(value.getBytes());
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
