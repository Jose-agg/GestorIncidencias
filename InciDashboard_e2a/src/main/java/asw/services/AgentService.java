package asw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import asw.entities.Agent;
import asw.repository.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
	AgentRepository agentRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Agent findByName(String name) {
		return agentRepo.findByNombre(name);
	}
		
	public void addAgent(Agent agent) {
		agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
		agentRepo.save(agent);
	}
	
	public void actualizarAgente(Agent agente)
	{
		agentRepo.save( agente );
	}
	/**
	 * Este metodo se usa para los test de cucumber 
	 * para sacar los operarios que hay en un momento dado en la base de datos y que las pruevas no 
	 * colisionen entre si
	 * @return
	 */
	public int prueba()
	{
		List<Agent> operarios = new ArrayList<Agent>();
		agentRepo.findAll().forEach(operarios::add);
		
		return operarios.size();
	}
}
