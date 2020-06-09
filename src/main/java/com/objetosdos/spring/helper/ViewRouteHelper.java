package com.objetosdos.spring.helper;

public class ViewRouteHelper {
	
	//HOME
	public final static String INDEX = "home/index";
	
	//PERSONA
	public final static String PERSON_INDEX="persona/index";
	public final static String PERSON_NEW="persona/new";
	public final static String PERSON_UPDATE="persona/update";

	//CLIENTE
	public final static String CLIENTE_INDEX="cliente/index";
	public final static String CLIENTE_NEW="cliente/new";
	public final static String CLIENTE_UPDATE="cliente/update";
	public final static String CLIENTE_REMOVE="cliente/remove";

	//EMPLEADO
	public final static String EMPLEADO_INDEX="empleado/index";
	public final static String EMPLEADO_NEW="empleado/new";
	
	//GERENTE
	public final static String GERENTE_INDEX="gerente/index";
	public final static String GERENTE_NEW="gerente/new";
	public final static String GERENTE_REMOVE="gerente/remove";
	public final static String GERENTE_ID="gerente/view";


	//VENDEDOR
	public final static String VENDEDOR_INDEX="vendedor/index";
	public final static String VENDEDOR_NEW="vendedor/new";
	public final static String VENDEDOR_UPDATE="vendedor/update";
	public final static String VENDEDOR_REMOVE="vendedor/remove";
	public final static String VENDEDOR_ID="vendedor/view";

	//SUCURSAL
	public final static String LOCAL_INDEX="sucursal/index";
	public final static String LOCAL_NEW="sucursal/new";
	public final static String LOCAL_ID="sucursal/id";
	public final static String LOCAL_STOCK="sucursal/stock";
	public final static String LOCAL_DESC_OPTION="sucursal/descOption";
	public final static String LOCAL_TALLE_OPTION="sucursal/talleOption";
	public final static String LOCAL_WITH_STOCK="sucursal/resultFilterWithStock";
	public final static String LOCAL_WITHOUT_STOCK="sucursal/resultFilterWithOutStock";
	public final static String LOCAL_LOTE_IN_OTHER_SUCURSAL ="sucursal/resultFilterOtherSucursal";
	public final static String LOCAL_VIEW = "sucursal/view";
	
	//VENDEDOR
	public final static String LOTE_INDEX="lote/index";
	public final static String LOTE_NEW="lote/new";
	public final static String LOTE_UPDATE="lote/update";
	public final static String LOTE_REMOVE="lote/remove";
	public final static String LOTE_ID="lote/view";
			
	//PRODUCTO
	public final static String PRODUCTO_INDEX="producto/index";
	public final static String PRODUCTO_NEW="producto/new";
	public final static String PRODUCTO_ID="producto/view";

	//VENTA
	public final static String VENTA_INDEX = "venta/index";
    public final static String VENTA_NEW = "venta/new";
    public final static String VENTA_ID = "venta/view";
    
  //PEDIDO
  	public final static String PEDIDO_INDEX = "pedido/index";
    public final static String PEDIDO_NEW = "pedido/new";
    public final static String PEDIDO_ID = "pedido/update";
	/**** Redirects ****/
	public final static String ROUTE = "/";
	public final static String PERSONA_ROOT = "/persona";
	public final static String CLIENTE_ROOT ="/cliente";
	public final static String GERENTE_ROOT = "/gerente";
	public final static String EMPLEADO_ROOT = "/empleado";
	public final static String LOCAL_ROOT = "/sucursal";
	public final static String VENDEDOR_ROOT = "/vendedor";
	public final static String LOTE_ROOT = "/lote";
	public final static String PRODUCTO_ROOT = "/producto";
	public final static String VENTA_ROOT = "/venta";
	public final static String PEDIDO_ROOT = "/pedido";
	
}