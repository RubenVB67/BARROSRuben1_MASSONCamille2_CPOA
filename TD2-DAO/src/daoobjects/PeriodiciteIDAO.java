package daoobjects;
import daofactory.IDAO;
import metiers.Periodicite;

public interface PeriodiciteIDAO extends IDAO<Periodicite>{
    public abstract Periodicite getById(int id_perio);

}
