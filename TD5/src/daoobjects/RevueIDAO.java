package daoobjects;
import daofactory.IDAO;
import metiers.Revue;

public interface RevueIDAO extends IDAO<Revue>{
    public abstract Revue getById(int id_r);
}
