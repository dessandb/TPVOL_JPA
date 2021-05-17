package sopra.vol.model;

public class Adresse {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "street", length = 300)
	private String rue;

	@Column(name = "additional_details", length = 300)
	private String complement;

	@Column(name = "postal_code", length = 10)
	private String codePostal;

	@Column(name = "city", length = 50)
	private String ville;
	private String pays;
	@ManyToOne
	@JoinColumn(name = "Client_Id")
	private Client client;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String complement, String codePostal, String ville, String pays) {
		this(null, rue, complement, codePostal, ville, pays);
	}

	public Adresse(Long id, String rue, String complement, String codePostal, String ville, String pays) {
		super();
		this.id = id;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
