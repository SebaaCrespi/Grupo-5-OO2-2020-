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
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.IProductoService;
import com.objetosdos.spring.services.ISucursalService;

@Controller
@RequestMapping("/lote")
public class LoteController {
	@Autowired
	private ILoteService loteService;
	@Autowired
	private ISucursalService sucursalService;
	@Autowired
	private IProductoService productoService;

	@GetMapping("")
	public ModelAndView index(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_INDEX);
		//ModelAndView mAVS = new ModelAndView(ViewRouteHelper.LOCAL_INDEX);
		mAV.addObject("lote", loteService.getAll());
		mAV.addObject("sucursal",sucursalService.getAll());
		mAV.addObject("producto",productoService.getAll());
		mAV.addObject("return", ViewRouteHelper.ROUTE);
	    return mAV;
	}
	@GetMapping("/new")
	public ModelAndView newLote(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_NEW);
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("sucursal", sucursalService.getAll());
		mAV.addObject("producto", productoService.getAll());
		mAV.addObject("return", ViewRouteHelper.LOTE_ROOT);
		return mAV;
	}    
	@GetMapping("/{id}")
	public ModelAndView lote(@PathVariable("id") int id){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_ID);
		mAV.addObject("lote", loteService.findById(id));
		//mAV.addObject("sucursal", sucursalService.findById(id));
		mAV.addObject("sucursal", sucursalService.getAll());
		mAV.addObject("producto",productoService.getAll());
		mAV.addObject("return", ViewRouteHelper.LOTE_ROOT);
		return mAV;
	}	
	@PostMapping("/remove/{id}")
	public RedirectView remove(@PathVariable("id") int id) {
		loteService.delete(id);
		return new RedirectView(ViewRouteHelper.LOTE_ROOT);
	} 
	@PostMapping("/save")
	public RedirectView saveVendedor(@ModelAttribute("lote") LoteModel loteModel){
		loteService.insertOrUpdate(loteModel);
		return new RedirectView(ViewRouteHelper.LOTE_ROOT);
	

	}
	  
}



