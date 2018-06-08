package asw.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import asw.entities.Campo;
import asw.entities.Etiqueta;
import asw.entities.Incidencia;
import asw.entities.Location;
import asw.entities.Operator;
import asw.entities.Status;
import asw.repository.CamposRepository;
import asw.repository.EtiquetaRepository;
import asw.repository.IncidenceRepository;
import asw.repository.LocationRepository;

@Service
public class IncidenceService {
	
	@Autowired
	public IncidenceRepository inciRepository;
	
	@Autowired
	public CamposRepository camposRepository;
	
	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	private EtiquetaRepository etRepository;
	
	
	public void addIncidence(Incidencia incidence)
	{
		inciRepository.save( incidence );
	}
	
	public Incidencia getIncidence(Long identificador) {
		return inciRepository.findOne( identificador );
	}
	
	public List<Incidencia> getIncidences() {
		List<Incidencia> incidencias = new ArrayList<Incidencia>();
		inciRepository.findAll().forEach(incidencias::add);
		
		return incidencias;
	}
	
	public void addEtiqueta(Set<Etiqueta> etiquetas) {
		for(Etiqueta e : etiquetas)
			etRepository.save( e );
	}
	
	public void addCampos(Set<Campo> campos) {
		for (Campo c : campos) {
			camposRepository.save( c );
		}
	}
	
	public void addCamposAIncidencia(Incidencia i, Set<Campo> campos) {
		for(Campo c : campos) {
			i.addCampo( c );
			c.setincidencia( i );
		}
	}
	
	public void addEtiquetasAIncidencia(Incidencia i, Set<Etiqueta> etiquetas) {
		for(Etiqueta e : etiquetas){
			i.addEtiqueta( e );
			e.setIncidencia( i );
		}
	}
	

	public Page<Incidencia> getIncidencessForOperator(Pageable pageable, Operator user) {
		Page<Incidencia> inci = new PageImpl<Incidencia>(new LinkedList<Incidencia>());
		inci = inciRepository.findAllByUser(pageable, user);
		return inci;
	} 

	public void addLocation(Location loc) {
		locRepo.save( loc );
	}
	
	public int[] cantidadIncidenciasTipo() {
		int contAbierto = 0;
		int contCerrado = 0;
		int contAnulada = 0;
		int contEnProceso = 0;
		List<Incidencia> incidences = getIncidences();
		for (Incidencia incidence : incidences) {
			if(incidence.getEstado().equals(Status.ABIERTO))
				contAbierto++;
			else if(incidence.getEstado().equals(Status.CERRADO))
				contCerrado++;
			else if(incidence.getEstado().equals(Status.ANULADA))
				contAnulada++;
			else
				contEnProceso++;
		}
		return new int[] { contAbierto, contCerrado, contAnulada, contEnProceso};
	}

	

	public void updateIncidence(Incidencia incidence) {
		inciRepository.save( incidence );
		
	}


}
