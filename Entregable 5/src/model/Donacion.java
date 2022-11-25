package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="donaciones", schema="manguito")
public abstract class Donacion {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_donacion")
	private int id;
	@Column(name="valor")
	private double valor;
	@Column(name="mensaje")
	private	String mensaje;
	@Column(name="fechaDeDonacion")
	private	Date fechaDeDonacion;
	@Column(name="medioDePago")
	private String medioDePago;
	
	//eager
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Usuario donador;
	
	public Donacion () {
		super();
	}
	public Donacion(double valorManguito,String mensajes,Date fechaDeDonacion,String medioDePago,Usuario donador) {
		this.setDonador(donador);
		this.setFechaDeDonacion(fechaDeDonacion);
		this.setMedioDePago(medioDePago);
		this.setMensajes(mensajes);
		this.setValorManguito(valorManguito);
	}
	
	
	public double getValorManguito() {
		return valor;
	}
	public void setValorManguito(double valorManguito) {
		this.valor = valorManguito;
	}
	public String getMensajes() {
		return mensaje;
	}
	public void setMensajes(String mensajes) {
		this.mensaje = mensajes;
	}
	public Date getFechaDeDonacion() {
		return fechaDeDonacion;
	}
	public void setFechaDeDonacion(Date fechaDeDonacion) {
		this.fechaDeDonacion = fechaDeDonacion;
	}
	public String getMedioDePago() {
		return medioDePago;
	}
	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}

	public Usuario getDonador() {
		return donador;
	}
	public void setDonador(Usuario donador) {
		this.donador = donador;
	}
	public int getId() {
		return id;
	}

}
