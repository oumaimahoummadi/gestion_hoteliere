package DaoImplementation;

import java.sql.*;

import java.util.*;

import Connection.Connexion;
import DAO.DaoGlobal;
import gestion_hoteliere.Reservation;

public class RvImpl implements DaoGlobal<Reservation> {
	ResultSet res;
    Connection con = Connexion.getCon();
    Statement stm;
	@Override
	public void add(Reservation t) {
		String req="INSERT INTO reservation VALUES (?,?,?,?,?)";
		try {
			PreparedStatement client=con.prepareStatement(req);
			client.setInt(1,t.getId_reservation());
			client.setInt(2,t.getId_chambre());
			client.setInt(3,t.getId_client());
			client.setString(4,t.getDate_debut());
			client.setString(5,t.getDate_fin());
			client.executeUpdate();
			System.out.print("ajout");

			
		}catch(SQLException e) {
            System.out.println("Erreur l'ajout de Reservation!!"+e);
		}
		
	}

	@Override
	public void update(Reservation t) {
		String req="UPDATE reservation SET id_chambre=?,id_client=? ,date_debut=?,date_fin=? WHERE id_reservation=?";
		try {
			PreparedStatement client=con.prepareStatement(req);
			client.setInt(1,t.getId_chambre());
			client.setInt(2,t.getId_client());
			client.setString(3,t.getDate_debut());
			client.setString(4,t.getDate_fin());
			client.setInt(5,t.getId_reservation());
			System.out.print("modifier");
			client.executeUpdate();
			
		}catch(SQLException e) {
            System.out.println("\n Erreur modifier_Reservation!!"+e);
		}		
	}

	@Override
	public void delete(int i) {
		
		String req="DELETE FROM reservation WHERE id_reservation=?";
		try {
			PreparedStatement rv=con.prepareStatement(req);
			rv.setInt(1,i);
			System.out.print("supprimer");
			rv.executeUpdate();
			
		}catch(SQLException e) {
            System.out.println("\n Erreur suupression d'une reservation !!"+e);
		}
	}

	@Override
	public List<Reservation> get() {
		List<Reservation> l = new ArrayList<>();
		String req="SELECT * FROM reservation";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()){
				Reservation reservation =new Reservation(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5));
				l.add(reservation);
				};
				System.out.println(l.toString());
		}
		catch(SQLException e) {
            System.out.println("Erreur affichage des reservations !!"+e);
		}
		return l;
	}
	
	public static void main(String[] args) {
		//Reservation rv=new Reservation(4, 1, 8, "1-jaiiin-2021", "8-jan-2021");
		RvImpl rvI=new RvImpl();
//		rvI.add(rv);
//		rv.setId_client(1);
//		rvI.update(rv);
		//rvI.delete(4);	
		rvI.get();
		for(Reservation reservation: rvI.get()) {
			System.out.println(reservation.getId_reservation()+"\t"+reservation.getId_chambre()+"\t"+reservation.getId_client()+"\t"+reservation.getDate_debut()
			+"\t"+reservation.getDate_fin());
		}
	}

}
