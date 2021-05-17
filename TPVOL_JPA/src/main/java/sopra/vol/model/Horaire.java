package sopra.vol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Horaire")
public class Horaire {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	@Column(name="dateHeure")
	private Date dateHeure;

	public Horaire() {
		super();
	}

	public Horaire(Date dateHeure) {
		super();
		this.dateHeure = dateHeure;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

}
