package com.anamaria.magazin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produse")
public class Produse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "denumire")
	private String denumire;

	@Column(name = "pret")
	private float pret;

	@Column(name = "cantitate")
	public int cantitate;

	public Produse() {

	}

	public Produse(String denumire, int cantitate, float pret) {
		this.denumire = denumire;
		this.cantitate = cantitate;
		this.pret = pret;
	}

	public long getID() {
		return id;
	}

	public String getDenumire() {
		return denumire;
	}

	public int getCantitate() {
		return cantitate;
	}

	public float getPret() {
		return pret;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}




}
