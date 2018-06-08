package asw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import asw.services.EtiquetaService;
import asw.services.IncidenceService;
import asw.services.OperadorService;

@Controller
public class EstadisticasController {
	@Autowired
	private IncidenceService inciService;
	
	@Autowired
	private OperadorService operaService;
	
	@Autowired
	private EtiquetaService etiquetaService;
	
	@RequestMapping("/estadisticas")
	public String getStatistics(Model model) {
		model.addAttribute("numeroTotalIncidencias", inciService.getIncidences().size());
		int[] numeroIncidenciasTipo = inciService.cantidadIncidenciasTipo();
		model.addAttribute("numeroTotalIncidenciasAbiertas", numeroIncidenciasTipo[0]);
		model.addAttribute("numeroTotalIncidenciasAnuladas", numeroIncidenciasTipo[1]);
		model.addAttribute("numeroTotalIncidenciasCerradas", numeroIncidenciasTipo[2]);
		model.addAttribute("numeroTotalIncidenciasEnProceso", numeroIncidenciasTipo[3]);
		model.addAttribute("operadorConMasIncidenciasHistoricas", operaService.findOperatorWithMoreIncidnces());
		model.addAttribute("etiquetaMasUsada", etiquetaService.etiquetaMasUtilizada());
	
		
		
		return "estadisticas";
	}

	
}
