package com.objetosdos.spring.controllers;


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
import com.objetosdos.spring.models.PersonaModel;
import com.objetosdos.spring.services.IPersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	

	@Autowired
	private IPersonaService personaService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_INDEX);// carga un string que tiene una direecion en
																			// el template.
		mAV.addObject("persons", personaService.getAll()); // agrega un objetos
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_NEW);
		mAV.addObject("persona", new PersonaModel());
		return mAV;
	}
	
	


	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("persona") PersonaModel personModel) { //
		personaService.insertOrUpdate(personModel);
		return new RedirectView(ViewRouteHelper.PERSONA_ROOT);
	}

	
	@GetMapping("/{id}") // le colocas el valor
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		mAV.addObject("persona", personaService.findByIdPersona(id));
		return mAV;
	}
	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("persona") PersonaModel personModel,int idPersona) { //
		System.out.println(idPersona);
		personaService.insertOrUpdate(personModel);
		return new RedirectView(ViewRouteHelper.PERSONA_ROOT);
	}

	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		personaService.remove(id);
		return new RedirectView(ViewRouteHelper.PERSONA_ROOT);
	}
	
	@GetMapping("/nombre/{name}")
	public ModelAndView getByName(@PathVariable("name") String nombre) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		mAV.addObject("persona", personaService.findByNombre(nombre));
		return mAV;
	}
	
}
