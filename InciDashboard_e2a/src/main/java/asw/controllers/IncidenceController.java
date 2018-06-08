package asw.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asw.entities.Incidencia;
import asw.entities.Operator;
import asw.entities.Status;
import asw.services.IncidenceService;
import asw.services.OperadorService;

@Controller
public class IncidenceController {
	
	@Autowired
	private OperadorService operadorService;
	
	@Autowired
	private IncidenceService inciService;
	
	@RequestMapping(value = "/incidencias/list")
	public String indicencias(Model model, Pageable pageable, Principal principal) {
		Operator operador = operadorService.getOperatorByName( principal.getName());
		Page<Incidencia> incidences = new PageImpl<Incidencia>(new LinkedList<Incidencia>());
		incidences = inciService.getIncidencessForOperator(pageable, operador);
		model.addAttribute("incidenceList", incidences.getContent());
		model.addAttribute("page", incidences);
		return "incidencias/list";
	}
	
	@RequestMapping("/incidencias/details/{id}")
	public String getDetail(Model model, @PathVariable Long id) {
		model.addAttribute("incidencia", inciService.getIncidence(id));
		return "incidencias/details";
	}
	
	@RequestMapping(value = "/incidencias/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		List<Status> status = Arrays.asList(Status.values());
		model.addAttribute("incidencia", inciService.getIncidence(id));
		model.addAttribute("estadoList", status);
		return "incidencias/edit";
	}

	@RequestMapping(value = "/incidencias/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute Incidencia inci) {
		Incidencia original = inciService.getIncidence(id);
		original.setComentarioOperario(inci.getComentarioOperario());
		original.setEstado(inci.getEstado());
		inciService.addIncidence(original);
		return "redirect:/incidencias/details/" + id;
	}
}
