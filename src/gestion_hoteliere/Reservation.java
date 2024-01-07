package gestion_hoteliere;


public class Reservation {
	private int id_reservation,id_chambre,id_client;
	private String date_debut,date_fin ;
	
	public Reservation(int id_reservation, int id_chambre, int id_client, String date_debut, String date_fin) {
		super();
		this.id_reservation = id_reservation;
		this.id_chambre = id_chambre;
		this.id_client = id_client;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public int getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(int id_chambre) {
		this.id_chambre = id_chambre;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

}
