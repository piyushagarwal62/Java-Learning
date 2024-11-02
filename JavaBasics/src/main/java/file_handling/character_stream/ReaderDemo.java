package main.java.file_handling.character_stream;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class ReaderDemo {

	public static void main(String[] args) {
		try(FileReader fr = new FileReader(Paths.get("JavaBasics/src/main/resources/temp.txt").toString());
			FileWriter fw = new FileWriter(Paths.get("JavaBasics/src/main/resources/temp4.txt").toString())){
			BufferedReader br = new BufferedReader(new CharArrayReader("Hello All, welcome!!".toCharArray()));
			
			String line = null;
			while((line = br.readLine()) != null){
				fw.write(line);
			}
		}catch(IOException io){
			System.out.println("IO Error" + io);
		}
	}
}
