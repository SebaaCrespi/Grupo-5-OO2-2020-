package com.objetosdos.spring.controllers;

import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.GerenteModel;
import com.objetosdos.spring.services.IGerenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
/* se puede hacer un generics para todos los crud */
@Controller
@RequestMapping("/gerente")
public class GerenteController {
    @Autowired
    private IGerenteService gerenteService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_INDEX);
        mAV.addObject("gerente", gerenteService.getAll());
        return mAV;
    }
    @GetMapping("new")
    public ModelAndView newGerente(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_NEW);
        mAV.addObject("gerente", new GerenteModel());
        return mAV;
    }
    @PostMapping("/save")
    public RedirectView saveGerente(@ModelAttribute("gerente") GerenteModel gerenteModel){
        gerenteService.insertOrUpdate(gerenteModel);
        return new RedirectView(ViewRouteHelper.GERENTE_ROOT);
    }
    @GetMapping("/{id}")
    public ModelAndView gerente(@PathVariable("id") int id){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.GERENTE_ID);
        mAV.addObject("gerente", gerenteService.findById(id));
        return mAV;
    }
    @GetMapping("/remove/{id}")
    public RedirectView removeGerente(@PathVariable("id") int id){
        gerenteService.delete(id);
        return new RedirectView(ViewRouteHelper.GERENTE_ROOT);
    }
   

}