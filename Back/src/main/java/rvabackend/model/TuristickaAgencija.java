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
public class TuristickaAgencija implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "AGENCIJA_SEQ_GENERATOR", sequenceName = "agencija_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENCIJA_SEQ_GENERATOR")
    private int id;
    
    private String naziv;
    private String adresa;
    private String kontakt;

    @OneToMany(mappedBy = "agencija" , cascade = {CascadeType.DETACH, CascadeType.REMOVE})
    @JsonIgnore
    private List<Aranzman> aranzmani;

    public TuristickaAgencija() {
    }

    public TuristickaAgencija(String naziv, String adresa, String kontakt) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.kontakt = kontakt;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	
	public List<Aranzman> getAranzmani() {
		return aranzmani;
	}

	public void setAranzmani(List<Aranzman> aranzmani) {
		this.aranzmani = aranzmani;
	}
}
