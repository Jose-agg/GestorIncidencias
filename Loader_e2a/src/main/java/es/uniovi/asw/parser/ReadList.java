package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;

public interface ReadList 
{
	public void readList() throws IOException, BusinessException;
	
	public List<Agent> readAgents(String formato, String filePathExcel) throws IOException, BusinessException;
}
