package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Vendedor;
import com.objetosdos.spring.models.VendedorModel;

@Component
public class VendedorConverter {

	
	    public Vendedor modelToEntity(VendedorModel vendedormodel) {
	        return new Vendedor(
	        		vendedormodel.getIdPersona(),
	        		vendedormodel.getNombre(),
	        		vendedormodel.getApellido(),
	        		vendedormodel.getFechaNacimiento(),
	        		vendedormodel.getDni(),
	        		vendedormodel.getHorasPorJornada(),
	        		vendedormodel.getSueldoBasico(),
	        		vendedormodel.getSucursal()
	        		
	        	
	        );
		}
		public VendedorModel entityToModel(Vendedor vendedor) {
			return new VendedorModel(
					vendedor.getIdPersona(),
					vendedor.getNombre(),
					vendedor.getApellido(),
					vendedor.getFechaNacimiento(),
					vendedor.getDni(),
					vendedor.getHorasPorJornada(),
					vendedor.getSueldoBasico(),
					vendedor.getSucursal()
					
			
					
	        );
		}
	}


