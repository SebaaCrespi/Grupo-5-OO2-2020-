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
import com.objetosdos.spring.models.ProductoModel;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoServices;
	
	@Autowired
	private ILoteService loteServices;
	
	
	
	
	//public final static String LOCAL_INDEX="local/index";
	@GetMapping("")
	public ModelAndView index(){
	    ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
		mAV.addObject("producto", productoServices.getAll());
		mAV.addObject("return", ViewRouteHelper.ROUTE);
	    return mAV;
	}
	 
	//public final static String LOCAL_NEW="local/new";
	@GetMapping("/new")
	public ModelAndView newProducto(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_NEW);
		mAV.addObject("producto", new ProductoModel());
		mAV.addObject("return", ViewRouteHelper.PRODUCTO_ROOT);
		return mAV;
	}
	
	@PostMapping("/save")
	public RedirectView saveProducto(
		@ModelAttribute("producto") ProductoModel productoModel) {
		//@ModelAttribute("direccion") DireccionModel direccionModel){
		//sucursalModel.setUbicacion(direccionServices.insertOrUpdate(direccionModel));
		productoServices.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
	}
	
	//public final static String LOCAL_ID="local/view";
	@GetMapping("/{id}")
	public ModelAndView sucursal(@PathVariable("id") int id){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_ID);
		mAV.addObject("producto", productoServices.findByIdProducto(id));
		
		mAV.addObject("lote", loteServices.getAll());
		mAV.addObject("return", ViewRouteHelper.PRODUCTO_ROOT);
		return mAV;
	}
	
	
	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id){
		productoServices.delete(id);
		return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
	}
	
	

}
