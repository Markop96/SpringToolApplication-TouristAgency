package rvabackend.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Hotel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "HOTEL_SEQ_GENERATOR", sequenceName = "hotel_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEL_SEQ_GENERATOR")
	private int id;

	private String naziv;
    private int brojZvezdica;
    private String opis;
    
    @ManyToOne
    @JoinColumn(name = "destinacija_id")
    private Destinacija destinacija;


    @OneToMany(mappedBy = "hotel", cascade = {CascadeType.DETACH, CascadeType.REMOVE})
    @JsonIgnore
    private List<Aranzman> aranzmani;
	
	public Hotel() {
		
	}
	
	public Hotel(int id, String naziv, int brojZvezdica, String opis, Destinacija destinacija,
			List<Aranzman> aranzmani) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.brojZvezdica = brojZvezdica;
		this.opis = opis;
		this.destinacija = destinacija;
		this.aranzmani = aranzmani;
	}
	
	 public int getId() {
			return id;
		}

	 public void setId(int id) {
			this.id = id;
		}

	public String getNaziv() {
			return naziv;
		}

	public void setNaziv(String naziv) {
			this.naziv = naziv;
		}

	public int getBrojZvezdica() {
			return brojZvezdica;
		}

	public void setBrojZvezdica(int brojZvezdica) {
			this.brojZvezdica = brojZvezdica;
		}

	public String getOpis() {
			return opis;
		}

	public void setOpis(String opis) {
			this.opis = opis;
		}

	public Destinacija getDestinacija() {
			return destinacija;
		}

	public void setDestinacija(Destinacija destinacija) {
			this.destinacija = destinacija;
		}

	public List<Aranzman> getAranzmani() {
			return aranzmani;
		}

	public void setAranzmani(List<Aranzman> aranzmani) {
			this.aranzmani = aranzmani;
		}

		

}
