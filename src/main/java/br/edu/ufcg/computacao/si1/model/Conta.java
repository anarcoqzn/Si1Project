package br.edu.ufcg.computacao.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numero_conta", nullable = false, unique = true)
	private Long numero;

	@Column(name = "saldo_conta", nullable = false)
	private double saldo;

	
	
	public Conta(double saldo) {
		super();
		this.saldo = saldo;
	}

	public Long getNumero() {
		return numero;
	}

	@OneToOne(mappedBy = "numero_conta")
	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
