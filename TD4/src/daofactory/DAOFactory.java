package daofactory;
import daoobjects.*;

public abstract class DAOFactory {
	public static DAOFactory getDAOFactory(Persistance cible){
		DAOFactory daof=null;
		switch (cible){
			case Mysql:
				daof=new MySQLDAOFactory();
				break;
			case Liste:
				daof=new ListeMemoireDAOFactory();
			default:
				break;
				}	

		return daof;
		}

    // Interfaces m�tier en relation :
    public abstract ClientIDAO getClientDAO();

    public abstract RevueIDAO getRevueDAO();

    public abstract PeriodiciteIDAO getPeriodiciteDAO();

    public abstract AbonnementIDAO getAbonnementDAO();
}
