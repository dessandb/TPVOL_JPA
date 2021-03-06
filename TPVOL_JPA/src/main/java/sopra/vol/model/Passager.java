package sopra.vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import sopra.vol.model.TypeIdentite;

@Entity
@Table(name = "Passager")
public class Passager {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="Nom")
	private String nom;
	@Column(name="Prenom")
	private String prenom;
	@Column(name="Numero_Identite")
	private String numeroIdentite;
	@Enumerated(EnumType.STRING)
	@Column(name="Type_Identite")
	private TypeIdentite typeIdentite;
	@OneToOne(mappedBy = "passager")
	private Reservation reservation;

	public Passager() {
		super();
	}
	
	public Passager(String nom, String prenom, String numeroIdentite, TypeIdentite typeIdentite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroIdentite = numeroIdentite;
		this.typeIdentite = typeIdentite;
	}

	public Passager(Long id, String nom, String prenom, String numeroIdentite, TypeIdentite typeIdentite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroIdentite = numeroIdentite;
		this.typeIdentite = typeIdentite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroIdentite() {
		return numeroIdentite;
	}

	public void setNumeroIdentite(String numeroIdentite) {
		this.numeroIdentite = numeroIdentite;
	}

	public TypeIdentite getTypeIdentite() {
		return typeIdentite;
	}

	public void setTypeIdentite(TypeIdentite typeIdentite) {
		this.typeIdentite = typeIdentite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
