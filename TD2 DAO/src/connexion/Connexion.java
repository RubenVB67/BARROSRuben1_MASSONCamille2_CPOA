package connexion;
import java.sql.*;

public class Connexion {
		
	private static Connexion connexion = null;

	private Connexion(){}
	
	public static Connexion getInstance() {
		if(connexion == null){
			connexion = new Connexion();
		}
		return connexion;
	}
	
	
	public Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/etud1u_base";
		url += "?serverTimezone=Europe/Paris";
		String login = "etud1u_appli";
		String pwd = "pass_etud1u"; 
		Connection maConnexion = null;
		try
		{ 
			maConnexion = DriverManager.getConnection(url, login, pwd);	
		} 
		catch(SQLException sqle) {
			System.out.println("Erreur connexion"+ sqle.getMessage());
		}
		return maConnexion;
	}
}