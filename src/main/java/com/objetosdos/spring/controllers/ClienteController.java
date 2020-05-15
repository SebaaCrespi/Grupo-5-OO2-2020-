package com.objetosdos.spring.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.ClienteModel;
import com.objetosdos.spring.models.PersonaModel;
import com.objetosdos.spring.services.IClienteService;
import com.objetosdos.spring.services.IPersonaService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IPersonaService personaService;
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_INDEX);// carga un string que tiene una direecion en																	// el template.
		mAV.addObject("clientes", clienteService.getAll()); // agrega un objetos
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_NEW);
		mAV.addObject("cliente", new ClienteModel());
		
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("cliente") ClienteModel clienteModel) { //
		clienteService.insertOrUpdate(clienteModel);
		
		return new RedirectView(ViewRouteHelper.CLIENTE_ROOT);
	}

	
	@GetMapping("/{id}") // le colocas el valor
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_UPDATE);
		mAV.addObject("cliente",clienteService.findByIdPersona(id));
		return mAV;
	}
	

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("cliente") ClienteModel clienteModel) {
		clienteService.insertOrUpdate(clienteModel);
		return new RedirectView(ViewRouteHelper.CLIENTE_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		clienteService.remove(id);
		return new RedirectView(ViewRouteHelper.CLIENTE_ROOT);
	}

}