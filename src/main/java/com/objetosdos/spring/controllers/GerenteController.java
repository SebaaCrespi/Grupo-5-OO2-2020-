package com.objetosdos.spring.controllers;

import com.objetosdos.spring.entities.Gerente;
import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.GerenteModel;
import com.objetosdos.spring.models.VendedorModel;
import com.objetosdos.spring.repositories.IGerenteRepository;
import com.objetosdos.spring.services.IGerenteService;

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
/* se puede hacer un generics para todos los crud */
@Controller
@RequestMapping("/gerente")
public class GerenteController {
    @Autowired
    private IGerenteService gerenteService;
    @Autowired
    private IGerenteRepository gerenteRepository;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_INDEX);
        mAV.addObject("gerente", gerenteService.getAll());
        mAV.addObject("return", ViewRouteHelper.EMPLEADO_ROOT);
        return mAV;
    }
    @GetMapping("new")
    public ModelAndView newGerente(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_NEW);
        mAV.addObject("gerente", new GerenteModel());
        mAV.addObject("return", ViewRouteHelper.GERENTE_ROOT);
        return mAV;
    }
    @PostMapping("/save")
    public String saveGerente(@Valid @ModelAttribute ("gerente") GerenteModel gerenteModel ,BindingResult bindingResult, RedirectAttributes redirectAttrs){
    	Gerente gerent = gerenteRepository.findByDni(gerenteModel.getDni());
		
		if (gerent!=null) {
    redirectAttrs
            .addFlashAttribute("mensaje", "EL DNI DEL GERENTE YA EXISTE  ")
            .addFlashAttribute("clase", "warning");
   
    return "redirect:/gerente/new";
		}
    	
    	gerenteService.insertOrUpdate(gerenteModel);

        return "redirect:/gerente";
    }
    @GetMapping("/{id}")
    public ModelAndView gerente(@PathVariable("id") int id){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_ID);
        mAV.addObject("gerente", gerenteService.findById(id));
        mAV.addObject("return", ViewRouteHelper.GERENTE_ROOT);
        return mAV;
    }
    @GetMapping("/remove/{id}")
    public RedirectView deleteGerente(@PathVariable("id") int id){
        gerenteService.delete(id);
        return new RedirectView(ViewRouteHelper.GERENTE_ROOT);
    }
   
    
    @PostMapping("/update")
  	public RedirectView update(@ModelAttribute("vendedor") GerenteModel gerenteModel) {
  		gerenteService.insertOrUpdate(gerenteModel);
  		return new RedirectView(ViewRouteHelper.GERENTE_ROOT);
  	}

}