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
import com.objetosdos.spring.models.PedidoModel;
import com.objetosdos.spring.models.VendedorModel;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.IPedidoService;
import com.objetosdos.spring.services.IVendedorService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private IPedidoService pedidoService;
	@Autowired
	private ILoteService loteService;
	@Autowired
	private IVendedorService vendedorService;
	
	
	@GetMapping("")
	public ModelAndView index(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		mAV.addObject("pedido", pedidoService.getAll());
		//mAV.addObject("venta",ventaService.getAll());
		mAV.addObject("producto",loteService.getAll());
		mAV.addObject("vendedorAuxiliar",vendedorService.getAll()); // SI LO SACO NO ME TIRA ERROR EL INDEX
		mAV.addObject("return", ViewRouteHelper.ROUTE);
	    return mAV;
	}
	@GetMapping("/new")
	public ModelAndView newPedido(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_NEW);
		mAV.addObject("pedido", new PedidoModel());
		mAV.addObject("lotes", loteService.getAll());
		mAV.addObject("vendedor", vendedorService.getAll());
		//mAV.addObject("venta", ventaService.getAll());
		mAV.addObject("return", ViewRouteHelper.PEDIDO_ROOT);
		return mAV;
	} 	
	
	@GetMapping("/{id}")
	public ModelAndView pedido(@PathVariable("id") int id){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_ID);
		mAV.addObject("pedido", pedidoService.findById(id));
		mAV.addObject("producto", loteService.getAll());
		mAV.addObject("vendedor",vendedorService.getAll());
		//mAV.addObject("venta",ventaService.getAll());
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
		VendedorModel v = null;
		pedidoModel.setVendedorAuxiliar(v);
		System.out.println(pedidoModel);
		/*pedidoService.insertOrUpdate(pedidoModel);*/
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}

	@PostMapping("/create/{idSucursal}")
	public RedirectView crearPedidoDesdeSucursal(
		@ModelAttribute("pedido") PedidoModel pedidoModel,
		@PathVariable("idSucursal") int idSucursal
		){
		pedidoModel.setAceptado(true);
		System.out.println(pedidoModel.getSucursal());
		pedidoService.insertOrUpdate(pedidoModel);
		return new  RedirectView ("/"+ViewRouteHelper.LOCAL_STOCK+"/"+idSucursal);
	}
	@PostMapping("/create/solicitud/{idSucursalSolicitada}")
	public RedirectView crearSolicitudDeStock(
		@PathVariable("idSucursalActual") int idSucursalActual,
		@PathVariable("idSucursalSolicitada") int idSucursalSolicitada
		){
		
		return new  RedirectView ("/"+ViewRouteHelper.LOCAL_STOCK+"/"+idSucursalActual);
	}

}
