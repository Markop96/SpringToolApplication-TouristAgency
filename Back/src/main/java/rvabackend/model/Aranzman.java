package rvabackend.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Aranzman implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ARANZMAN_SEQ_GENERATOR", sequenceName = "aranzman_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARANZMAN_SEQ_GENERATOR")
    private int id;


    private double ukupna_cena;
    private boolean placeno;
    private Date datum_realizacije;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "agencija_id")
    private TuristickaAgencija agencija;

    public Aranzman() {
        // Default constructor
    }

    // Constructor with parameters
    public Aranzman(double ukupna_cena, boolean placeno, Date datum_realizacije, Hotel hotel, TuristickaAgencija agencija) {
        this.ukupna_cena = ukupna_cena;
        this.placeno = placeno;
        this.datum_realizacije = datum_realizacije;
        this.hotel = hotel;
        this.agencija = agencija;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUkupna_cena() {
        return ukupna_cena;
    }

    public void setUkupna_cena(double ukupna_cena) {
        this.ukupna_cena = ukupna_cena;
    }

    public boolean isPlaceno() {
        return placeno;
    }

    public void setPlaceno(boolean placeno) {
        this.placeno = placeno;
    }

    public Date getDatum_realizacije() {
        return datum_realizacije;
    }

    public void setDatum_realizacije(Date datum_realizacije) {
        this.datum_realizacije = datum_realizacije;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public TuristickaAgencija getAgencija() {
        return agencija;
    }

    public void setAgencija(TuristickaAgencija agencija) {
        this.agencija = agencija;
    }
}
