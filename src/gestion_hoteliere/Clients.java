package gestion_hoteliere;


public class Clients {
	private int id_client,num_compte;
	private String nom,prenom;
	
	

	public Clients(int id_client,String nom,String prenom,int num_compte) {
		this.id_client=id_client;
		this.nom=nom;
		this.prenom=prenom;
		this.num_compte=num_compte;
		
	}

	public Clients(String nom,String prenom,int num_compte) {
		this.nom=nom;
		this.prenom=prenom;
		this.num_compte=num_compte;
		
	}

	public Clients() {
		super();
	}
	
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getNum_compte() {
		return num_compte;
	}
	public void setNum_compte(int num_compte) {
		this.num_compte = num_compte;
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

}

