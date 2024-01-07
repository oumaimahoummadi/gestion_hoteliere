package DaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.Connexion;
import DAO.DaoGlobal;
import gestion_hoteliere.Administrateurs;

public class AdminImpl implements DaoGlobal<Administrateurs> {
	ResultSet res;
    Connection con = Connexion.getCon();
    Statement stm;
    
	@Override
	public void add(Administrateurs t) {
		String req="INSERT INTO admin VALUES (?,?,?)";
		try {
			PreparedStatement admin=con.prepareStatement(req);
			admin.setInt(1,t.getId_admin());
			admin.setString(2,t.getLogin());
			admin.setString(3,t.getPassword());
			admin.executeUpdate();
			System.out.print("ajout d'admin.");
		}
		catch(SQLException e) {
            System.out.println("Erreur ajout d'admin!!"+e);
		}		
	}

	@Override
	public void update(Administrateurs t) {
		String req="UPDATE admin SET login=?,password=? WHERE id_admin=?";
		try {
			PreparedStatement admin=con.prepareStatement(req);
			admin.setString(1,t.getLogin());
			admin.setString(2,t.getPassword());
			admin.setInt(3,t.getId_admin());
			System.out.print("modifier");
			admin.executeUpdate();
			
		}
		catch(SQLException e) {
            System.out.println("Erreur modification d'admin!!"+e);
		}
		
	}

	@Override
	public void delete(int i) {
		String req="DELETE FROM admin WHERE id_admin=?";
		try {
			PreparedStatement admin=con.prepareStatement(req);
			admin.setInt(1,i);
			System.out.print("supprimer");
			admin.executeUpdate();
			
		}catch(SQLException e) {
            System.out.println("Erreur suppression d'adminitrateur !!"+e);
		}		
	}

	@Override
	public List<Administrateurs> get() {
		List<Administrateurs> l = new ArrayList<>();
		String req="SELECT * FROM admin";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ResultSet res =ps.executeQuery();
			while(res.next()){
				Administrateurs admin =new Administrateurs(res.getInt(1),res.getString(2),res.getString(3));
				l.add(admin);
				};
				System.out.println(l.toString());
		}
		catch(SQLException e) {
            System.out.println("Erreur affichage d'admin.!!"+e);
		}
		return l;
	}
	
	public static void main(String[] args) {
//		Administrateurs adminne=new Administrateurs(4,"yusra", "kamboua");
		AdminImpl ad=new AdminImpl();
//		ad.add(adminne);
		//ad.delete(1);
//		adminne.setLogin("admiin4");
//		ad.update(adminne);
//		ad.get();
		for(Administrateurs admin:ad.get()) {
			System.out.print(admin.getId_admin()+"\t"+admin.getLogin()+"\t"+admin.getPassword()+"\n");
			
		}
		
	}	

}
