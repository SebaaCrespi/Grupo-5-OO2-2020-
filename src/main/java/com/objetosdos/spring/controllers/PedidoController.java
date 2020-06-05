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
import com.objetosdos.spring.models.PedidoModel;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.IPedidoService;
import com.objetosdos.spring.services.IProductoService;
import com.objetosdos.spring.services.ISucursalService;
import com.objetosdos.spring.services.IVendedorService;
import com.objetosdos.spring.services.IVentaService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private IPedidoService pedidoService;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IVendedorService vendedorService;
	
	
	@GetMapping("")
	public ModelAndView index(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		
		mAV.addObject("pedido", pedidoService.getAll());
		//mAV.addObject("venta",ventaService.getAll());
		//mAV.addObject("producto",productoService.getAll());
		mAV.addObject("vendedorAuxiliar",vendedorService.getAll()); // SI LO SACO NO ME TIRA ERROR EL INDEX
		mAV.addObject("return", ViewRouteHelper.ROUTE);
	    return mAV;
	}
	@GetMapping("/new")
	public ModelAndView newPedido(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_NEW);
		mAV.addObject("pedido", new PedidoModel());
		mAV.addObject("producto", productoService.getAll());
		mAV.addObject("vendedor", vendedorService.getAll());
		//mAV.addObject("venta", ventaService.getAll());
		mAV.addObject("return", ViewRouteHelper.PEDIDO_ROOT);
		return mAV;
	}   
	
	
	@GetMapping("/{id}")
	public ModelAndView pedido(@PathVariable("id") int id){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_ID);
		mAV.addObject("pedido", pedidoService.findById(id));
		mAV.addObject("producto", productoService.getAll());
		mAV.addObject("vendedor",vendedorService.getAll());
		mAV.addObject("return", ViewRouteHelper.PEDIDO_ROOT);
		return mAV;
	}
	
	@PostMapping("/remove/{id}")
	public RedirectView remove(@PathVariable("id") int id) {
		pedidoService.delete(id);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	
}
	
	
	@PostMapping("/create")
	public RedirectView savePedido(@ModelAttribute("pedido") PedidoModel pedidoModel){
		pedidoService.insertOrUpdate(pedidoModel);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	

	}
	  
}
