package connexion;
import java.sql.*;


public interface Connexion 
{
	public static Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/barros4u_cpoa";
		url += "?serverTimezone=Europe/Paris";
		String login = "barros4u_appli";
		String pwd = "31717855";
		Connection maConnexion = null;
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
			System.out.println("Connexion réussie");
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}
}
