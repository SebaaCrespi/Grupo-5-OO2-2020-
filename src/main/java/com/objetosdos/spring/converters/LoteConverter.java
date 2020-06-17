package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.models.LoteModel;

@Component
public class LoteConverter {
	
	
	 public Lote modelToEntity(LoteModel lotemodel) {
	        return new Lote(
	            lotemodel.getIdLote(),
	            lotemodel.getProducto(),
	            lotemodel.getTalle(),
	            lotemodel.getCantidadActual(),
	            lotemodel.getCantidadInicial(),
	            lotemodel.getFechaIngreso(),
	            lotemodel.getSucursal(),
	            lotemodel.getPedido()
	            
	        );
		}
		public LoteModel entityToModel(Lote lote) {
			return new LoteModel(
					lote.getIdLote(),
					lote.getProducto(),
					lote.getTalle(),
					lote.getCantidadInicial(),
					lote.getCantidadActual(),
					lote.getFechaIngreso(),
					lote.getSucursal(),
					lote.getPedido()
		            
	        );
		}
	

}
