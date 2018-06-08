package asw.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import asw.entities.Operator;
import asw.repository.OperatorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperatorRepository operatorRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void addOperator(Operator operator) {
		operator.setPassword(bCryptPasswordEncoder.encode(operator.getPassword()));
		operatorRepository.save(operator);
	}
	
	public List<Operator> findAllOperators() {
		List<Operator> operarios = new ArrayList<Operator>();
		operatorRepository.findAll().forEach(operarios::add);
		return operarios;
	}
	
	public void actualizarOperario(Operator op) {
		operatorRepository.save( op );
	}
	
	public Operator obtainOperatorForIncidence() {
		RolesService rs = new RolesService();
		List<Operator> list = operatorRepository.findAll();
		Collections.sort(list, new Comparator<Operator>() {
		    @Override
		    public int compare(Operator o1, Operator o2) {
		        return o1.getNumeroIncidencias() - o2.getNumeroIncidencias();
		    }
		});
		for (Operator operator : list) {
			if(operator.getRole().equals(rs.getRoles()[0])) 
				return operator;
		}
		return null;
	}
	
	public Operator getOperatorByName(String name) {
		return operatorRepository.findByUser(name); 
	}
	
	/**
	 * Este metodo se utiliza para encontrar el operador al que se le va a asignar
	 * una incidencia en funcion de el numero de incidencias que tine cada uno
	 * @return OperadorAsignado
	 */
	public Operator findOperatorWithMoreIncidnces() {
		List<Operator> operadores = findAllOperators();
		Operator elegido = operadores.get(0);
		int numeroIncidenciasElegido = elegido.getNumeroIncidencias();
		for (Operator op : operadores) {
			if(op.getNumeroIncidencias() > numeroIncidenciasElegido) {
				elegido = op;
				numeroIncidenciasElegido = elegido.getNumeroIncidencias();
			}
		}
		return elegido;
	}
	

}
