package com.objetosdos.spring.helper;

public class ViewRouteHelper {
	
	//HOME
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";
	
	//PERSONA
	public final static String PERSON_INDEX="persona/index";
	public final static String PERSON_NEW="persona/new";
	public final static String PERSON_UPDATE="persona/update";

	//EMPLEADO
	public final static String EMPLEADO_INDEX="empleado/index";
	public final static String EMPLEADO_NEW="empleado/new";
	
	//GERENTE
	public final static String GERENTE_INDEX="gerente/index";
	public final static String GERENTE_NEW="gerente/new";
	public final static String GERENTE_UPDATE="gerente/update";
	public final static String GERENTE_REMOVE="gerente/remove";
	public final static String GERENTE_ID="gerente/view";


	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String PERSONA_ROOT = "/persona";
	public final static String GERENTE_ROOT = "/gerente";
	public final static String EMPLEADO_ROOT = "/empleado";
}
