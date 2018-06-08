package es.uniovi.asw.persistence;

import java.util.List;

import es.uniovi.asw.model.Agent;
import es.uniovi.asw.persistence.util.Jpa;

public class AgentFinder {

	public static boolean isInDatabase(Agent agent) {
		List<Agent> lista = Jpa
				.getManager()
				.createQuery("select a from Agent a where a.id = ?1 or a.nombreUsuario = ?2 or a.dni=?3",
						Agent.class).setParameter(1, agent.getID())
									.setParameter(2, agent.getNombreUsuario())
									.setParameter(3, agent.getDni())
				.getResultList();
		if (lista.size() > 0) {
			return new Boolean(true);
		} else {
			return new Boolean(false);
		}
	}

	public static List<Agent> findAll() {
		return Jpa.getManager()
				.createQuery("select a from Agent a", Agent.class)
				.getResultList();
	}
}
