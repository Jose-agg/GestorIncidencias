package es.uniovi.asw.business.impl.agent;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.uniovi.asw.business.impl.Command;
import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.util.Jpa;

public class AddAgent implements Command {

	private Agent agent;

	// private BCryptPasswordEncoder bCryptPasswordEncoder = new
	// BCryptPasswordEncoder();

	public AddAgent(Agent agent) {
		this.agent = agent;
	}

	@Override
	public Object execute() {
		String password = agent.getPassword() + agent.getKind() + agent.getNombreUsuario();
		agent.setPassword(String.valueOf(password.hashCode()));
		// agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
		Jpa.getManager().persist(agent);

		return agent;
	}

}
