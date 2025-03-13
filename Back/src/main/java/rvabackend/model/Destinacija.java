package rvabackend.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Destinacija implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "DESTINACIJA_SEQ_GENERATOR", sequenceName = "destinacija_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESTINACIJA_SEQ_GENERATOR")
	private int id;

	private String mesto;
    private String drzava;
    private String opis;

    @OneToMany(mappedBy = "destinacija", cascade = {CascadeType.DETACH, CascadeType.REMOVE})
    @JsonIgnore
    private List<Hotel> hoteli;

    public Destinacija(){
    	
    }
    
	public Destinacija(int id, String mesto, String drzava, String opis, List<Hotel> hoteli) {
		super();
		this.id = id;
		this.mesto = mesto;
		this.drzava = drzava;
		this.opis = opis;
		this.hoteli = hoteli;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Hotel> getHoteli() {
		return hoteli;
	}

	public void setHoteli(List<Hotel> hoteli) {
		this.hoteli = hoteli;
	}
}
