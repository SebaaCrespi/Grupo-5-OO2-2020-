package com.objetosdos.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.services.IClienteService;
import com.objetosdos.spring.services.IVendedorService;
import com.objetosdos.spring.services.IVentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IVendedorService vendedorService;
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_INDEX);
		mAV.addObject("venta", ventaService.getAll());
		mAV.addObject("return" , ViewRouteHelper.ROUTE);
		return mAV;
	}
	
	@GetMapping("new/{id_sucursal}")
	public ModelAndView newVenta(@PathVariable("id_sucursal") int id_sucursal) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_NEW);
		return mAV;
	}
	
	@GetMapping("/new/{id_sucursal}/{id_vendedor}")
	public ModelAndView newVenta(@PathVariable("id_sucursal") int id_sucursal, @PathVariable("id_vendedor") int id_vendedor) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.VENTA_NEW);
		return mAV;
	}
	
	
	/*@GetMapping("/new")
	public ModelAndView newSucursal(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_NEW);
		mAV.addObject("sucursal", new SucursalModel());
		//mAV.addObject("direccion", new DireccionModel());
		mAV.addObject("gerentes", gerenteServices.getAll());// para que vaya a buscar los gerentes que hay y los muestre
		//mAV.addObject("direccion", direccionServices.getAll());//si lo coloco no funciona rl new
		mAV.addObject("return", ViewRouteHelper.LOCAL_ROOT);
		return mAV;
	}
	
	@PostMapping("/save")
	public RedirectView saveSucursal(
		@ModelAttribute("sucursal") SucursalModel sucursalModel) {
		//@ModelAttribute("direccion") DireccionModel direccionModel){
		//sucursalModel.setUbicacion(direccionServices.insertOrUpdate(direccionModel));
		sucursalServices.insertOrUpdate(sucursalModel);
		
		
		return new RedirectView(ViewRouteHelper.LOCAL_ROOT);
	}*/
	

	
}
