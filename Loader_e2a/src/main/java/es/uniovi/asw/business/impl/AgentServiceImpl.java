package es.uniovi.asw.business.impl;

import java.util.List;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.business.impl.agent.AddAgent;
import es.uniovi.asw.business.impl.agent.DeleteAllAgents;
import es.uniovi.asw.business.impl.agent.FindAllAgents;
import es.uniovi.asw.business.impl.agent.IsAgentInDatabase;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.model.exception.*;

public class AgentServiceImpl implements AgentService {

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void insertAgent(Agent Agent) throws BusinessException {
		executor.execute(new AddAgent( Agent ));
	}
	
	@Override
	public boolean isAgentInDatabase(Agent Agent) throws BusinessException {
		return (Boolean)executor.execute(new IsAgentInDatabase( Agent ));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> findAllAgents() throws BusinessException {
		return (List<Agent>) executor.execute(new FindAllAgents());
	}

	@Override
	public void deleteAllAgents(List<Agent> Agents) throws BusinessException {
		executor.execute(new DeleteAllAgents(Agents));
	}
}
