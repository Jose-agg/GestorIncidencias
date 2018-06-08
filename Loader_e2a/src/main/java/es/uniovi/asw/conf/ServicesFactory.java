package es.uniovi.asw.conf;

import es.uniovi.asw.business.AgentService;
import es.uniovi.asw.business.impl.AgentServiceImpl;

public class ServicesFactory {

	public static AgentService getAgentService() {
		return new AgentServiceImpl();
	}
}
