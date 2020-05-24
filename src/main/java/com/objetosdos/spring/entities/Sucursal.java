package com.objetosdos.spring.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL) // SI SALE MERGE ME SALE ERROR EN CREAR
    @JoinColumn(name = "iddireccion", nullable = true)
	private Direccion ubicacion;

	private long telefono;
	
	@OneToOne//(cascade = CascadeType.MERGE) //con all me falla // CON REFRESH ME DEJA USAR MAS DE UN GETENTE PARA EL MISMO // CON MERGE ME DEJA
	@JoinColumn(name = "idgerente", unique=true) // se coloca en la  base com idgerente -- unique para que no se repita el gerente en la sucursal.
	private Gerente gerente;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sucursal") // una sucursal tiene muchos vendedores
	private Set<Vendedor> lstVendedores= new HashSet<Vendedor>();  //SE MODIFICOOOO
	
	
	
	public Sucursal() {
		

		
	}
	

	/*--------------------------------------------------*/

	public Sucursal(int id, Direccion ubicacion, long telefono, Gerente gerente) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.gerente = gerente;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Direccion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Direccion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public Set<Vendedor> getLstVendedores() {
		return lstVendedores;
	}
	public void setLstVendedores(Set<Vendedor> lstVendedores) {
		this.lstVendedores = lstVendedores;
	}

/*
	public List<Vendedor> getLstVendedores() {
		return lstVendedores;         SE MODIFICO
	}


	public void setLstVendedores(List<Vendedor> lstVendedores) {
		this.lstVendedores = lstVendedores;
	}
*/
	
	
	

	/** 
	 *
	 * Metodos con la lista de vendedores. Agregar, traer, modificar y eliminar
	 * 
	 */
	
	/*
	public boolean agregarVendedor(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico) throws Exception{
		if(this.traerVendedor(dni) != null) throw new Exception("El vendedor que se quiere agregar ya esta en el sistema.");
		return lstVendedores.add(new Vendedor(idPersona,nombre,apellido, fechaNacimiento, dni, horasPorJornada, sueldoBasico, this));  
	}
	
	*/
	
	/*--------------------------------------------------*/
	
	/*
	
	public Vendedor traerVendedor(long dni) {
		int indice=0;
		Vendedor v = null;
		while(indice < this.getLstVendedores().size() && v == null) {
			if(dni == lstVendedores.get(indice).getDni()) {
				v = lstVendedores.get(indice);
			}
			indice++;
		}
		return v;
	}
	
	*/
	/*--------------------------------------------------*/
/*	
	public void modificarVendedor(String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico, float plus) throws Exception{
	if(this.traerVendedor(dni) == null) throw new Exception("Error: El vendedor no existe");
		
		this.traerVendedor(dni).setApellido(apellido);
		this.traerVendedor(dni).setFechaNacimiento(fechaNacimiento);
		this.traerVendedor(dni).setHorasPorJornada(horasPorJornada);
		this.traerVendedor(dni).setNombre(nombre);
		this.traerVendedor(dni).setDni(dni);
		this.traerVendedor(dni).setPlus(plus);
		this.traerVendedor(dni).setSueldoBasico(sueldoBasico);
	}
*/
	/*--------------------------------------------------*/
/*
	public boolean eliminarVendedor(long dni) throws Exception{
		
		if(this.traerVendedor(dni) != null) throw new Exception("El vendedor que se quiere eliminar no esta en el sistema.");
	
		return lstVendedores.remove(this.traerVendedor(dni));
		
		}
*/		
	
	
	/*--------------------------------------------------*/
	
	
	/*--------------------------------------------------*/

	
	/*--------------------------------------------------*/

	/*--------------------------------------------------*/

	/*--------------------------------------------------*/
	
	/*--------------------------------------------------*/
	

	
	/*--------------------------------------------------*/

	
	/*--------------------------------------------------*/

/*
	//MUESTRA LA INFO DE CADA VENDEDOR APLICANDO EL PLUS EN EL SUELFO BASICO.
	public List<String> cierreDelMes(){
		List<String> cierre = new ArrayList<String>();
		
		for(int i=0; i<lstVendedores.size(); i++) {
			cierre.add("Sueldo total del vendedor " + lstVendedores.get(i).getNombre()+ " "+lstVendedores.get(i).getApellido() + ": "+
					(String.valueOf(lstVendedores.get(i).getSueldoBasico() + lstVendedores.get(i).getPlus()))
					+ "\n");
		}
		
		return cierre;
		
		*/
	}
	


