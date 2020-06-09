package com.objetosdos.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.objetosdos.spring.entities.Cliente;
import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.ClienteModel;
import com.objetosdos.spring.repositories.IClienteRepository;
import com.objetosdos.spring.services.IClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IClienteRepository clienteRepo;

	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_INDEX);// carga un string que tiene una direecion en																	// el template.
		mAV.addObject("clientes", clienteService.getAll()); // agrega un objetos
		mAV.addObject("return", ViewRouteHelper.ROUTE);
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_NEW);
		mAV.addObject("cliente", new ClienteModel());
		mAV.addObject("return", ViewRouteHelper.CLIENTE_ROOT);
		return mAV;
	}
	
	@PostMapping("/create")
	public /*RedirectView*/ String create(@Valid @ModelAttribute ("cliente") ClienteModel clienteModel ,BindingResult bindingResult, RedirectAttributes redirectAttrs) { 
		if (bindingResult.hasErrors()) {
			//redirectAttrs
            //.addFlashAttribute("mensaje", "DIRECCION DE MAIL INCORRECTA")
			//.addFlashAttribute("clase", "warning");
			System.out.println("ENTRO AL ERROR");
			return "redirect:/cliente/index";
		}else {
			System.out.println("ENTRO AL ELSE");
			
		}
		
		
		Cliente cli = clienteRepo.findByDni(clienteModel.getDni());
		
				if (cli!=null) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "EL DNI DEL CLIENTE YA EXISTE  ")
                    .addFlashAttribute("clase", "warning");
           
            return "redirect:/cliente/new";
         
           }
		
			clienteService.insertOrUpdate(clienteModel);
			redirectAttrs
            .addFlashAttribute("mensaje", "Agregado correctamente")
            .addFlashAttribute("clase", "success");
		
			return "redirect:/cliente";
	}

	
	@GetMapping("/{id}") // le colocas el valor
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_UPDATE);
		mAV.addObject("cliente",clienteService.findByIdPersona(id));
		mAV.addObject("return", ViewRouteHelper.CLIENTE_ROOT);
		return mAV;
	}
	

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("cliente") ClienteModel clienteModel) {
		clienteService.insertOrUpdate(clienteModel);
		return new RedirectView(ViewRouteHelper.CLIENTE_ROOT);
	}
	
	
	
	@PostMapping("/remove/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		clienteService.remove(id);
		return new RedirectView(ViewRouteHelper.CLIENTE_ROOT);
	}

}
