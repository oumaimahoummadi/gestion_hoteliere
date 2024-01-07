package DaoImplementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.Connexion;
import DAO.DaoGlobal;
import gestion_hoteliere.Chambres;

public class ChambreImpl implements DaoGlobal<Chambres>{
	ResultSet res;
    Connection con = Connexion.getCon();
	@Override
	public void add(Chambres t) {
		
		
		String req="INSERT INTO chambre VALUES (?,?,?,?)";
		
		
		try {
			PreparedStatement chambre=con.prepareStatement(req);
			chambre.setInt(1,t.getId_chambre());
			chambre.setInt(2,t.getNombre_personne());
			chambre.setInt(3,t.getPrix());
			chambre.setString(4,t.getType());
			//System.out.print("ajout");
			chambre.executeUpdate();
			
		}catch(SQLException e) {
            System.out.println("Erreur add_Chambre!"+e);
		}			
	}

	@Override
	public void update(Chambres t) {
		
		
		String req="UPDATE chambre SET nombre_personne=?,prix=?,type=? WHERE id_chambre=?";
		
		
		try {
			PreparedStatement chambre=con.prepareStatement(req);
			chambre.setInt(1,t.getNombre_personne());
			chambre.setInt(2,t.getPrix());
			chambre.setString(3,t.getType());
			chambre.setInt(4,t.getId_chambre());

			System.out.print("modifier");
			chambre.executeUpdate();
			
			}
		catch(SQLException e) {
            System.out.println("Erreur modification de chambre!"+e);
		}		
	}

	@Override
	public void delete(int i) {
		
		
		String req="DELETE FROM chambre WHERE id_chambre=?";
		
		
		try {
			PreparedStatement chambre=con.prepareStatement(req);
			chambre.setInt(1,i);
			chambre.executeUpdate();
			System.out.print("supprimer");		
		}
		catch(SQLException e) {
            System.out.println("Erreur supp_Chambre!"+e);
		}
	}

	@Override
	public List<Chambres> get() {
		List<Chambres> l = new ArrayList<>();
		
		
		String req="SELECT * FROM chambre";
		
		
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()){
				Chambres c =new Chambres(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4));
				l.add(c);
				};
				System.out.println(l.toString());
		}
		catch(SQLException e) {
            System.out.println("Erreur affiche_Chambre!"+e);
		}
		return l;
	}
	
	public static void main(String[]args) {
		Chambres chmbr=new Chambres(899, 92, 9, "Classique");
		DaoGlobal ch =new ChambreImpl();
		//Tester add()--------------------
		//ch.add(chmbr);
		//chmbr.setNombre_personne(97);
		//ch.update(chmbr);
		ch.delete(899);
		//System.out.print("upp");
//		ch.get();
//		for(Chambres chambre: ch.get()) {
//			System.out.println(chambre.getId_chambre()+"\t"+chambre.getNombre_personne()+"\t"+chambre.getPrix()+"\t"+chambre.getType());
//		}
	}

}
