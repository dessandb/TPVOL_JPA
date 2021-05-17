package sopra.vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Compagnie_Aerienne_Vol")
public class CompagnieAerienneVol {
	@Id
	private Long id;
	@Column(name = "Numero_Vol")
	private String numeroVol;
	@ManyToOne
	@JoinColumn(name = "Compagnie_Aerienne_Code")
	private CompagnieAerienne compagnieAerienne;
<<<<<<< HEAD
	@OneToMany(mappedBy="vols")
=======
	@ManyToOne
	@JoinColumn(name = "Vol_Id")
>>>>>>> main
	private Vol vol;

	public CompagnieAerienneVol() {
		super();
	}
	
	public CompagnieAerienneVol(String numeroVol) {
		super();
		this.numeroVol = numeroVol;
	}

	public CompagnieAerienneVol(Long id, String numeroVol) {
		super();
		this.id = id;
		this.numeroVol = numeroVol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}

	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

}
