package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Vendedor;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.VendedorModel;

public interface IVendedorService {
	
	 	public List<Vendedor> getAll();
	    
	    public VendedorModel insertOrUpdate(VendedorModel vendedorModel);

	    public VendedorModel findByIdPersona(int id);
	    
	    public boolean remove(int id);
	    
	    public List<VendedorModel> getVendedoresPorSucursal(int idSucursal);

}
