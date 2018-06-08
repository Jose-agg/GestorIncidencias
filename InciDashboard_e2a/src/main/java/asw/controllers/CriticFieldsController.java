package asw.controllers;

import java.util.LinkedList;

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

import asw.entities.CamposCriticos;
import asw.services.CamposCriticosService;

@Controller
public class CriticFieldsController {
	
	@Autowired
	private CamposCriticosService critiService;
	
	@RequestMapping(value="/campos")
	public String mostrar(Model model, Pageable pageable) {
		Page<CamposCriticos> campos = new PageImpl<CamposCriticos>(new LinkedList<CamposCriticos>());
		campos=critiService.getAll(pageable);
		model.addAttribute("criticList", campos.getContent());
		model.addAttribute("page", campos);
		return "criticos/list";
		
	}
	
	@RequestMapping(value = "/campos/modificar/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("campo", critiService.getCampo( id ));
		return "criticos/editFields";
	}
	
	@RequestMapping(value = "/campos/modificar/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @ModelAttribute CamposCriticos cc) {
		CamposCriticos ccModificar = critiService.getCampo( id );
		ccModificar.setValor(cc.getValor());
		critiService.addCampos( ccModificar );
		return "redirect:/campos";
	}
}
