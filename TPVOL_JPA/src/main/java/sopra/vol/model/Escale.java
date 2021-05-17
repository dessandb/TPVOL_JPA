package sopra.vol.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Escale")
public class Escale {
	@Id
	@GeneratedValue
	private Long id;
	@Embedded
	@Column(name = "Horaire_Depart")
	private Horaire hDepart;
	@Embedded
	@Column(name = "Horaire_Arrivee")
	private Horaire hArrivee;
	@ManyToOne
	@JoinColumn(name = "Vol_Id")
	private Vol vol;
	@OneToOne
	@JoinColumn(name = "Aeroport_Code")
	private Aeroport aeroport;

	public Escale() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Horaire gethDepart() {
		return hDepart;
	}

	public void sethDepart(Horaire hDepart) {
		this.hDepart = hDepart;
	}

	public Horaire gethArrivee() {
		return hArrivee;
	}

	public void sethArrivee(Horaire hArrivee) {
		this.hArrivee = hArrivee;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

}
