package Connection;
import java.sql.*;
public class Connexion {
	  static Connection con;
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","system");
				System.out.println("Connecter");
				}
			catch(ClassNotFoundException e) {
				System.out.println("Probl�me au niveau du pilote");
				}
			catch(SQLException e) {
				System.out.println("Probl�me au niveau de base au acc�s au donn�es");
				}
		}
		
		public static Connection getCon(){
			return con;
		}
	
	
	public static void main(String[] args) {
		System.out.print("This is the main class");
	}

}


