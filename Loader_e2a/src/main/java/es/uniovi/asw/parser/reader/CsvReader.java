package es.uniovi.asw.parser.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import com.opencsv.CSVReader;

public class CsvReader {

	public HashMap<Integer, String> leerCSV(String rutaFichero) throws IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		//final String FICHERO_URL = "src/test/resources/TiposAgentes.csv";
		final String FICHERO_URL = rutaFichero;
		
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(FICHERO_URL));
			String[] nextLine = null;

			while ((nextLine = reader.readNext()) != null) {
				System.out.println(Arrays.toString(nextLine));
				map.put(Integer.parseInt(nextLine[0]), nextLine[1]);
			}

		} catch (IOException e) {
			System.out.println("El fichero no esta en el path correspondiente.");
		} finally {
			if (null != reader) {
				reader.close();
			}
		}

		return map;
	}

	

}
