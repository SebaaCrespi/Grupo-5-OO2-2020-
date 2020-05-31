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

import java.util.List;

import com.objetosdos.spring.helper.ViewRouteHelper;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.SucursalModel;
import com.objetosdos.spring.services.IGerenteService;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.ISucursalService;


@Controller
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	private ISucursalService sucursalServices;
	@Autowired
	private IGerenteService gerenteServices;
	@Autowired
	private ILoteService loteServices;

	
	
	//public final static String LOCAL_INDEX="local/index";
	@GetMapping("")
	public ModelAndView index(){
	    ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_INDEX);
		mAV.addObject("sucursal", sucursalServices.getAll());
		mAV.addObject("return", ViewRouteHelper.ROUTE);
	    return mAV;
	}
	@GetMapping("/new")
	public ModelAndView newSucursal(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_NEW);
		mAV.addObject("sucursal", new SucursalModel());
		mAV.addObject("gerentes", gerenteServices.getAll());// para que vaya a buscar los gerentes que hay y los muestre
		mAV.addObject("return", ViewRouteHelper.LOCAL_ROOT);
		return mAV;
	}
	
	@PostMapping("/save")
	public RedirectView saveSucursal(
		@ModelAttribute("sucursal") SucursalModel sucursalModel){
		sucursalServices.insertOrUpdate(sucursalModel);
		return new RedirectView(ViewRouteHelper.LOCAL_ROOT);
	}
	
	//public final static String LOCAL_ID="local/view";
	@GetMapping("/{id}")
	public ModelAndView sucursal(@PathVariable("id") int id){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_STOCK);
		List<LoteModel> lstLotes = loteServices.getLotes(id);
		mAV.addObject("idSucursal", id);
		mAV.addObject("ubicacion", sucursalServices.findById(id).getUbicacion());
		mAV.addObject("marcas", loteServices.getAllMarca());
        mAV.addObject("lotes", lstLotes );
		mAV.addObject("return", ViewRouteHelper.LOCAL_ROOT);
		return mAV;
	}

	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id){
		sucursalServices.delete(id);
		return new RedirectView(ViewRouteHelper.LOCAL_ROOT);
	}
	
	@GetMapping("/filter/{marca}")
	public ModelAndView traerDescripcion(@PathVariable("marca") String marca){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_DESC_OPTION);
		mAV.addObject("descripcion",loteServices.getAllDescripcion(marca));
		return mAV;
	}

	@GetMapping("/filter/{marca}/{desc}")
	public ModelAndView traerTalle(@PathVariable("marca") String marca,@PathVariable("desc") String desc ){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_TALLE_OPTION);
		mAV.addObject("talles",loteServices.getAllTalle(marca,desc));
		return mAV;
	}

	@GetMapping("/filter/{id}/{marca}/{desc}/{talle}")
	public ModelAndView filter(@PathVariable("id") int id, @PathVariable("marca") String marca, @PathVariable("desc") String desc, @PathVariable("talle") String talle){
		LoteModel lote = loteServices.getBusquedaProductoEnSucursal(id, marca, desc, talle);
		ModelAndView mAV = new ModelAndView();
		SucursalModel sucursalActual =  sucursalServices.findById(id);
		if(lote == null){
			lote = loteServices.getLoteDeSucursalMasCercana(loteServices.getBusquedaProducto(marca, desc, talle),sucursalActual);
			if(lote == null){
				mAV.setViewName(ViewRouteHelper.LOCAL_WITHOUT_STOCK);
			}
			else{
				mAV.setViewName(ViewRouteHelper.LOCAL_LOTE_IN_OTHER_SUCURSAL);
				mAV.addObject("idSucursal", id);
				mAV.addObject("ubicacion", sucursalServices.findById(lote.getSucursal().getId()).getUbicacion());
				mAV.addObject("distancia", sucursalServices.calcularDistancia(sucursalActual.getUbicacion().getLatitud(),sucursalActual.getUbicacion().getLongitud(),lote.getSucursal().getUbicacion().getLatitud(),lote.getSucursal().getUbicacion().getLongitud()));
			}
		}
		else{
			//mostrar la vista del lote encontrado para generar pedido en sucursal actual
			mAV.setViewName(ViewRouteHelper.LOCAL_WITH_STOCK);
		}
		mAV.addObject("lote", lote);
		return mAV;
	}
}
