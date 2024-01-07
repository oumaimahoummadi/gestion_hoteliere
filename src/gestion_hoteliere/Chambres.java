package gestion_hoteliere;


public class Chambres {
	private int id_chambre,nombre_personne,prix;
	private String type;
	
	public Chambres(int id_chambre, int nombre_personne, int prix, String type) {
		super();
		this.id_chambre = id_chambre;
		this.nombre_personne = nombre_personne;
		this.prix = prix;
		this.type = type;
	}
	
	public Chambres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_chambre() {
		return id_chambre;
	}
	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}
	public int getNombre_personne() {
		return nombre_personne;
	}
	public void setNombre_personne(int nombre_personne) {
		this.nombre_personne = nombre_personne;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
