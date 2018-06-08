package es.uniovi.asw.model.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
	
	public static void write(String fileName, String message) throws IOException {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(fileName, true));
		    writer.println(message);
		} catch (IOException e) {
		   throw e;
		} finally {
			writer.close();
		}
	}
}
