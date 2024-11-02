package main.java.file_handling.byte_stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class to check with mark and reset Even checking other ways of reading and
 * writing using byte array
 * 
 * @author piyush.agarwal
 *
 */
public class FileStreamsDemo {

	public static void main(String[] args) {
		int size;
		BufferedInputStream bis = null;
		try (FileInputStream fis = new FileInputStream(Paths.get("JavaBasics/src/main/resources/temp.txt").toString());
			 FileOutputStream fos = new FileOutputStream(Paths.get("JavaBasics/src/main/resources/temp1.txt").toString());
			 FileOutputStream fos2 = new FileOutputStream(Paths.get("JavaBasics/src/main/resources/temp2.txt").toString(), true)) {
			bis = new BufferedInputStream(fis);
			byte b[] = new byte[10];
			int count = 0;
			while ((size = bis.read(b, 0, b.length / 2)) != -1) {
				count++;
				fos.write(b, 0, size);
				System.out.println(new String(b, 0, size));
				System.out.println(bis.available());
				if (count == 3 && bis.markSupported())
					bis.mark(0);
			}
			bis.reset();
			while ((size = bis.read(b)) != -1) {
				fos2.write(b);
			}
		} catch (IOException io) {
			System.out.println("Exception caught:" + io);
		} finally {
			try {
				bis.close();
			} catch (IOException io) {
				System.out.println("Exception caugth: " + io);
			}
		}
	}

}
