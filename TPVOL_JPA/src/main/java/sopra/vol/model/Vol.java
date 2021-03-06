package sopra.vol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sopra.vol.model.StatutVol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Vol")
public class Vol {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "Statut_Vol")
	private StatutVol statutVol;
	@Column(name = "DateDepart")
	private Date dtDepart;
	@Column(name = "DateArrivee")
	private Date dtArrivee;
	@OneToOne
	@JoinColumn(name="Aeroport_Depart_Code")
	private Aeroport depart;
	@OneToOne
	@JoinColumn(name="Aeroport_Arrivee_Code")
	private Aeroport arrivee;
	@Column(name = "Nombre_Places_Disponibles")
	private int nbPlaceDispo;
	@OneToMany(mappedBy = "vol")
	private List<Billet> billets = new ArrayList<Billet>();
	@OneToMany(mappedBy = "vol")
	private List<CompagnieAerienneVol> compagnieAeriennes = new ArrayList<CompagnieAerienneVol>();

	public Vol() {
		super();
	}
	
	public Vol(StatutVol statutVol, Date dtDepart, Date dtArrivee, int nbPlaceDispo) {
		super();
		this.statutVol = statutVol;
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.nbPlaceDispo = nbPlaceDispo;
	}

	public Vol(Long id, StatutVol statutVol, Date dtDepart, Date dtArrivee, int nbPlaceDispo) {
		super();
		this.id = id;
		this.statutVol = statutVol;
		this.dtDepart = dtDepart;
		this.dtArrivee = dtArrivee;
		this.nbPlaceDispo = nbPlaceDispo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatutVol getStatutVol() {
		return statutVol;
	}

	public void setStatutVol(StatutVol statutVol) {
		this.statutVol = statutVol;
	}

	public List<Billet> getBillets() {
		return billets;
	}

	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}

	public Date getDtDepart() {
		return dtDepart;
	}

	public void setDtDepart(Date dtDepart) {
		this.dtDepart = dtDepart;
	}

	public Date getDtArrivee() {
		return dtArrivee;
	}

	public void setDtArrivee(Date dtArrivee) {
		this.dtArrivee = dtArrivee;
	}

	public Aeroport getDepart() {
		return depart;
	}

	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}

	public Aeroport getArrivee() {
		return arrivee;
	}

	public int getNbPlaceDispo() {
		return nbPlaceDispo;
	}

	public void setNbPlaceDispo(int nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}

	public void setArrivee(Aeroport arrivee) {
		this.arrivee = arrivee;
	}

	public List<CompagnieAerienneVol> getCompagnieAeriennes() {
		return compagnieAeriennes;
	}

	public void setCompagnieAeriennes(List<CompagnieAerienneVol> compagnieAeriennes) {
		this.compagnieAeriennes = compagnieAeriennes;
	}

}
