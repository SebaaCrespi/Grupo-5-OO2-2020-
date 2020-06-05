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

import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.ProductoModel;
import com.objetosdos.spring.repositories.IProductoRepository;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService productoServices;
	@Autowired
	private IProductoRepository productoRepository;
	
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
	public String saveProducto(@Valid @ModelAttribute ("producto") ProductoModel productoModel ,BindingResult bindingResult, RedirectAttributes redirectAttrs) {
		//@ModelAttribute("direccion") DireccionModel direccionModel){
		//sucursalModel.setUbicacion(direccionServices.insertOrUpdate(direccionModel));
		
		Producto pro =productoRepository.findByDescripcion(productoModel.getDescripcion());
		if (pro!=null) {
			redirectAttrs
            .addFlashAttribute("mensaje", "El modelo ya existe")
            .addFlashAttribute("clase", "warning");
   System.out.println("ENTRO AL METODO IF DE CONTROLLER");
				return "redirect:/producto/new";
			
		}
		
		
		productoServices.insertOrUpdate(productoModel);
		
		return "redirect:/producto";
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
