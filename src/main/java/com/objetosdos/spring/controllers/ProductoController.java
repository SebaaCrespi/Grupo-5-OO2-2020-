package com.objetosdos.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.ProductoModel;
import com.objetosdos.spring.services.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired 
	private IProductoService productoService;
	
	  @GetMapping("")
	    public ModelAndView index(){
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
	        mAV.addObject("producto", productoService.getAll());
	        return mAV;
	    }
	
	  @GetMapping("/new")
    public ModelAndView newProducto(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_NEW);
        mAV.addObject("producto", new ProductoModel());
        return mAV;
    }
	  
	  @PostMapping("/save")
	    public RedirectView saveGerente(@ModelAttribute("producto") ProductoModel productoModel){
	       productoService.insertOrUpdate(productoModel);
	        return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
	    }
	  
}
