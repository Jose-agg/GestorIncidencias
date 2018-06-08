package asw.streamKafka.parser;

import asw.entities.Incidencia;

public interface Parser {
	public String parseToIncidence(String data);
	
	public String parseToJSON(Incidencia incidencia);
}
