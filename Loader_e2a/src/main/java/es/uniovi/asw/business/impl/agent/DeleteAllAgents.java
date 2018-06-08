package es.uniovi.asw.business.impl.agent;

import java.util.List;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.BusinessException;
import es.uniovi.asw.persistence.util.Jpa;

public class DeleteAllAgents implements Command {
	
	List<Agent> agents;

	public DeleteAllAgents(List<Agent> agents) {
		this.agents = agents;
	}

	@Override
	public Object execute() throws BusinessException {
		
		for(Agent agent : agents) {
			Agent agentPersistent = Jpa.getManager().find(Agent.class, agent.getID());
			Jpa.getManager().remove(agentPersistent);
		}
		
		return null;
	}
	
}
