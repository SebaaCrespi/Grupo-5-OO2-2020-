package com.objetosdos.spring.helper;

public class ViewRouteHelper {
	
	//HOME
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";
	
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
	public final static String LOCAL_ID="sucursal/view";

	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String PERSONA_ROOT = "/persona";
	public final static String CLIENTE_ROOT ="/cliente";
	public final static String GERENTE_ROOT = "/gerente";
	public final static String EMPLEADO_ROOT = "/empleado";
	public final static String LOCAL_ROOT = "/sucursal";
	public final static String VENDEDOR_ROOT = "/vendedor";
}
