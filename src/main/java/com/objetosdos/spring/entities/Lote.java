package com.objetosdos.spring.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Lote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idLote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idproducto", nullable=true) // En la tala vendedor se relaciona con idsucursal la sucursal
		private Producto producto;
		private String talle;
		@Override
		public String toString() {
			return "Lote [idLote=" + idLote + ", producto=" + producto + ", talle=" + talle + ", cantidadActual="
					+ cantidadActual + ", cantidadInicial=" + cantidadInicial + ", fechaIngreso=" + fechaIngreso
					+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", sucursal=" + sucursal + "]";
		}


		private int cantidadActual;
		private int cantidadInicial;
		private LocalDate fechaIngreso;
		
		@CreationTimestamp
		private LocalDateTime createdAt;
		
		@UpdateTimestamp
		private LocalDateTime updatedAt;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="idsucursal", nullable=true) // En la tala vendedor se relaciona con idsucursal la sucursal
		private Sucursal sucursal;
		
		@OneToMany(mappedBy = "lote") // como esta en la entidad pedido lote--producto.
		private List<Pedido> pedido; //agregado.
		
	public Lote () {
		
	}
	public Lote(int idLote,Producto producto, String talle,int cantidadActual, int cantidadInicial, LocalDate fechaIngreso, Sucursal sucursal,List<Pedido> pedido) {
		super();
		this.idLote=idLote;
		this.producto = producto;
		this.talle = talle;
		this.cantidadActual = cantidadActual;
		this.cantidadInicial = cantidadInicial;
		this.fechaIngreso = fechaIngreso;
		this.sucursal=sucursal;
		this.pedido=pedido;
	}


		public List<Pedido> getPedido() {
				return pedido;
			}
			public void setPedido(List<Pedido> pedido) {
				this.pedido = pedido;
			}
		public int getIdLote() {
				return idLote;
			}
			public void setIdLote(int idLote) {
				this.idLote = idLote;
			
		
			}
		public Producto getProducto() {
			return producto;
		}


		public void setProducto(Producto producto) {
			this.producto = producto;
		}


		public String getTalle() {
			return talle;
		}


		public void setTalle(String talle) {
			this.talle = talle;
		}


		public int getCantidadActual() {
			return cantidadActual;
		}


		public void setCantidadActual(int cantidadActual) {
			this.cantidadActual = cantidadActual;
		}


		public int getCantidadInicial() {
			return cantidadInicial;
		}


		public void setCantidadInicial(int cantidadInicial) {
			this.cantidadInicial = cantidadInicial;
		}


		public LocalDate getFechaIngreso() {
			return fechaIngreso;
		}


		public void setFechaIngreso(LocalDate fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}
		
		
		
		
		


		public Sucursal getSucursal() {
			return sucursal;
		}


		public void setSucursal(Sucursal sucursal) {
			this.sucursal = sucursal;
		}
}

	



