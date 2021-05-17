package sopra.vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
<<<<<<< HEAD
=======
import javax.persistence.Entity;
>>>>>>> main
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
<<<<<<< HEAD

public class Aeroport {
	@Id
	@GeneratedValue
	private String code;
	@Column(name = "nom")
	private String nom;
	@ManyToMany
	@JoinTable(name = "villes", joinColumns = @JoinColumn(name = "ville_id"), inverseJoinColumns = @JoinColumn(name = "aeroport_code"))
=======
import javax.persistence.Table;
@Entity
@Table(name = "Aeroport")
public class Aeroport {
	@Id
	@Column(name = "Code")
	private String code;
	@Column(name = "Nom")
	private String nom;
	@ManyToMany
	@JoinTable(name = "Aero_Ville", joinColumns = @JoinColumn(name = "Ville_id"), inverseJoinColumns = @JoinColumn(name = "Aeroport_Code"))
>>>>>>> main
	private List<Ville> villes = new ArrayList<Ville>();

	public Aeroport() {
		super();
	}

	public Aeroport(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

}
