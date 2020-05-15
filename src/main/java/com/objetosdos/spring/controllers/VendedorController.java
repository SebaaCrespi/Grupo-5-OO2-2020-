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
import com.objetosdos.spring.models.VendedorModel;
import com.objetosdos.spring.services.IVendedorService;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
    private IVendedorService vendedorService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_INDEX);
        mAV.addObject("vendedor", vendedorService.getAll());
        return mAV;
    }
    @GetMapping("/new")
    public ModelAndView newVendedor(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_NEW);
        mAV.addObject("vendedor", new VendedorModel());
        return mAV;
    }
    @PostMapping("/save")
    public RedirectView saveVendedor(@ModelAttribute("vendedor") VendedorModel vendedorModel){
    	vendedorService.insertOrUpdate(vendedorModel);
        return new RedirectView(ViewRouteHelper.VENDEDOR_ROOT);
    }
    @GetMapping("/{id}")
    public ModelAndView gerente(@PathVariable("id") int id){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_ID);
        mAV.addObject("vendedor", vendedorService.findByIdPersona(id));
        return mAV;
    }
	
    @PostMapping("/remove/{id}")
	public RedirectView remove(@PathVariable("id") int id) {
		vendedorService.remove(id);
		return new RedirectView(ViewRouteHelper.VENDEDOR_ROOT);
	}
	

}
