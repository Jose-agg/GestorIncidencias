package es.uniovi.asw.business.impl.agent;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.AgentFinder;

public class IsAgentInDatabase implements Command {

	private Agent agent;

	public IsAgentInDatabase(Agent agent) {
		this.agent = agent;
	}

	public Object execute() {
		return AgentFinder.isInDatabase(agent);
	}
}
