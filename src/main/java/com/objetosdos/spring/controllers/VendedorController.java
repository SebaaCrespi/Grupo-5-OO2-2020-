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

import com.objetosdos.spring.entities.Vendedor;
import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.VendedorModel;
import com.objetosdos.spring.repositories.IVendedorRepository;
import com.objetosdos.spring.services.ISucursalService;
import com.objetosdos.spring.services.IVendedorService;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
    private IVendedorService vendedorService;
	
	@Autowired
    private IVendedorRepository vendedorRepository;
	
	@Autowired
    private ISucursalService sucursalService;
	

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_INDEX);
        //ModelAndView mAVS = new ModelAndView(ViewRouteHelper.LOCAL_INDEX);
        mAV.addObject("vendedor", vendedorService.getAll());
        mAV.addObject("sucursal", sucursalService.getAll());
        mAV.addObject("return", ViewRouteHelper.ROUTE);
        return mAV;
    }
    @GetMapping("/new")
    public ModelAndView newVendedor(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_NEW);
        mAV.addObject("vendedor", new VendedorModel());
        mAV.addObject("sucursal", sucursalService.getAll());
        mAV.addObject("return", ViewRouteHelper.VENDEDOR_ROOT);
         
        return mAV;
    }
    @PostMapping("/save")
    public String saveVendedor(@Valid @ModelAttribute ("vendedor") VendedorModel vendedorModel ,BindingResult bindingResult, RedirectAttributes redirectAttrs){
    	
    	Vendedor vendor = vendedorRepository.findByDni(vendedorModel.getDni());
		
		if (vendor!=null) {
    redirectAttrs
            .addFlashAttribute("mensaje", "EL DNI DEL VENDEDOR YA EXISTE  ")
            .addFlashAttribute("clase", "warning");
   
    return "redirect:/vendedor/new";
		}
    
    		vendedorService.insertOrUpdate(vendedorModel);
            //return (ViewRouteHelper.VENDEDOR_ROOT);
    		return "redirect:/vendedor";

    	
    }
    @GetMapping("/{id}")
    public ModelAndView vendedor(@PathVariable("id") int id){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENDEDOR_ID);
        mAV.addObject("vendedor", vendedorService.findByIdPersona(id));
        //mAV.addObject("sucursal", sucursalService.findById(id));
        //mAV.addObject("direccion", direccionService.getAll());
        mAV.addObject("sucursal", sucursalService.getAll());
        mAV.addObject("return", ViewRouteHelper.VENDEDOR_ROOT);
        
        return mAV;
    }
	
    @PostMapping("/remove/{id}")
    
	public RedirectView remove(@PathVariable("id") int id) {
		vendedorService.remove(id);
		return new RedirectView(ViewRouteHelper.VENDEDOR_ROOT);
	}
	

}
