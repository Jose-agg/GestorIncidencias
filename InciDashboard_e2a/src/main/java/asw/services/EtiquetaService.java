package asw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.entities.Etiqueta;
import asw.repository.EtiquetaRepository;

@Service
public class EtiquetaService {
	@Autowired
	public EtiquetaRepository etiquetaRepository;
	
	public List<Etiqueta> getEtiquetas(){
		return etiquetaRepository.findAll();
	}
	
	
	public String etiquetaMasUtilizada() {
		return etiquetaRepository.etiquetaMasUtilizada().get(0);
	}
	
}
