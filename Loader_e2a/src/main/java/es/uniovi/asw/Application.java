package es.uniovi.asw;

import java.io.IOException;


import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.parser.ReadList;
import es.uniovi.asw.parser.reader.Loader;

public class Application {

	/**
	 * @param args
	 * 				args[0] -> "excel"
	 * 				args[1] -> <ruta fichero excel>
	 * 				args[2] -> <ruta fichero csv>
	 */
	public static void main(String... args) {
		try {
			if (args.length <= 2)
				throw new IllegalArgumentException("Error en el número de parámetros.");
			
			new Application().run( args );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(String... parametros) throws IOException,
			BusinessException {
		String formato = parametros[0]; // "excel"
		String filePathExcel = parametros[1]; // "src/test/resources/xxx.xlsx"
		String filePathCSV = parametros[2]; // "src/test/resources/yyy.csv"
		
		ReadList loader = new Loader( formato, filePathExcel, filePathCSV );
		loader.readList();	
	}

}
