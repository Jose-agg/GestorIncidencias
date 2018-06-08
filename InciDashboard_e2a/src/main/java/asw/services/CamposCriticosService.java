package asw.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import asw.entities.CamposCriticos;

import asw.repository.CamposCriticosRepository;

@Service
public class CamposCriticosService {
	
	@Autowired
	private CamposCriticosRepository ccRepository;
	
	public void addCampoCritico(CamposCriticos cc) {
		ccRepository.save( cc );
	}
	/**
	 * Los campos criticos se usan para saber si una incidencia es o no 
	 * critica
	 * @param pageable
	 * @return
	 */
	public Page<CamposCriticos> getAll(Pageable pageable){
		Page<CamposCriticos> campos = new PageImpl<CamposCriticos>(new LinkedList<CamposCriticos>());
		campos=ccRepository.findAll(pageable);
		return campos;
	}
	
	public CamposCriticos findByClave(String clave){
		CamposCriticos campo = ccRepository.findByClave(clave);
		return campo;
	}
	
	public CamposCriticos getCampo(Long identificador) {
		return ccRepository.findOne( identificador );
	}
	
	public void addCampos(CamposCriticos cc)
	{
		ccRepository.save(cc);
	}

	
}
