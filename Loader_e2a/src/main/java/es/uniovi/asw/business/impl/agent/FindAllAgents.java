package es.uniovi.asw.business.impl.agent;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.AgentFinder;

public class FindAllAgents implements Command {
	
	public List<Agent> execute() {
		return AgentFinder.findAll();	
	}
}
