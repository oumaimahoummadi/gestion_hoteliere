package DaoImplementation;

import java.sql.*;

import java.util.*;

import Connection.Connexion;
import DAO.DaoGlobal;
import gestion_hoteliere.Clients;

public class ClientsImpl implements DaoGlobal<Clients> {
	ResultSet res;
    Connection con = Connexion.getCon();
    Statement stm;
    
	@Override
	public void add(Clients t) {
		String req="INSERT INTO client VALUES (?,?,?,?)";
		try {
			PreparedStatement client=con.prepareStatement(req);
			client.setInt(1,t.getId_client());
			client.setString(2,t.getNom());
			client.setString(3,t.getPrenom());
			client.setInt(4,t.getNum_compte());
			client.executeUpdate();
			System.out.print("ajout");

			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Clients t) {
		String req="UPDATE client SET nom=?,prenom=? ,Num_compte=? WHERE Id_client=?";
		try {
			PreparedStatement client=con.prepareStatement(req);
			client.setString(1,t.getNom());
			client.setString(2,t.getPrenom());
			client.setInt(3,t.getNum_compte());
			client.setInt(4,t.getId_client());
			System.out.print("modifier");
			client.executeUpdate();
			
		}catch(SQLException e) {
            System.out.println("Erreur ajout_Client!!"+e);
		}
		
	}

	@Override
	public void delete(int i) {
		
		String req="DELETE FROM client WHERE Id_client=?";
		try {
			PreparedStatement client=con.prepareStatement(req);
			client.setInt(1,i);
			client.executeUpdate();
			System.out.print("supprimer");

			
		}catch(SQLException e) {
            System.out.println("Erreur supp_Client!!"+e);
		}
		
	}

	@Override
	public List<Clients> get() {
		List<Clients> l = new ArrayList<>();
		String req="SELECT * FROM client";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()){
				Clients c =new Clients(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
				l.add(c);
				};
				System.out.println(l.toString());
		}
		catch(SQLException e) {
            System.out.println("Erreur affiche_Client!!"+e);
		}
		return l;
		
	}
	

	
	//public static void main(String[] args) {
//        Clients client =new Clients(18,"nom","prenom",999999);
//		ClientsImpl c= new ClientsImpl();
		//c.add(client);
//		client.setNom("tttttt");
//		System.out.println("sucess");
		
		//Clients client =new Clients(1, 8888, "yusra", "uuu");
//		ClientsImpl c= new ClientsImpl();
		//c.update(client);
		//c.delete(18);
		//c.get();
//		c.get();
//		for(Clients Client: c.get()) {
//			System.out.println(Client.getId_client()+"\t"+Client.getNom()+"\t"+Client.getPrenom()+"\t"+Client.getNum_compte());
//		}
//		System.out.println("\n sucess");
		
	//}

	
}
