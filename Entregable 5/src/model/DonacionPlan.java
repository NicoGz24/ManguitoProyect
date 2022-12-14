package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class DonacionPlan extends Donacion{
	
	@ManyToOne
	private Plan plan;
	@Column(name="beneficioCanjeado")
	private boolean beneficioCanjeado;
	
	
	public DonacionPlan () {
		super();
	}

	public DonacionPlan (double valor,String mensaje,Date fechaDeDonacion,String medioDePago,Usuario donador, Plan plan){
		super(valor,mensaje,fechaDeDonacion,medioDePago,donador);
		this.setBeneficioCanjeado(false);
		this.setPlan(plan);
	}
	
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public boolean isBeneficioCanjeado() {
		return beneficioCanjeado;
	}

	public void setBeneficioCanjeado(boolean beneficioCanjeado) {
		this.beneficioCanjeado = beneficioCanjeado;
	}
}
