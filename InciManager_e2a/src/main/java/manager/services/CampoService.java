package manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.entities.Campo;
import manager.repository.CamposRepository;

@Service
public class CampoService {

	@Autowired
	private CamposRepository campoRepository;
	
	public List<Campo> obtenerCampos(Long id){
		return campoRepository.findByIncidenciaId(id);
	}
	
}
